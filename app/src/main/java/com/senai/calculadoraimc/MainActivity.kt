package com.senai.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat

private lateinit var pesoEditText: EditText
private lateinit var alturaEditText: EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcular = findViewById<Button>(R.id.calcular)
        val sair = findViewById<Button>(R.id.sair)

        calcular.setOnClickListener() {
            pesoEditText = findViewById<EditText>(R.id.peso)
            alturaEditText = findViewById<EditText>(R.id.altura)

            val resultadoImcTextView = findViewById<TextView>(R.id.resultadoImc)
            val resultadoTextView = findViewById<TextView>(R.id.resultado)

            if (validarCampos()) {
                val peso = pesoEditText.text.toString().toDouble()
                val altura = alturaEditText.text.toString().toDouble()

                val imc = calcularImc(peso, altura)

                val decimal = DecimalFormat("#,###.00")

                /*resultadoImcTextView.text = imc.toString()
                resultadoTextView.text = situacao(imc)*/

                //Variável responsável por chamar a activity
                val intent = Intent(this, ResultadoActivity::class.java)
                intent.putExtra("peso", "${peso}")
                intent.putExtra("altura", "${altura}")
                intent.putExtra("imc", "${decimal.format(imc)}")
                intent.putExtra("situacao", situacao(imc))
                startActivity(intent);
            }

            sair.setOnClickListener() {
                finish()
            }
        }

    }

    private fun validarCampos(): Boolean {
        var noError = true
        if (pesoEditText.text.isBlank()) {
            pesoEditText.setError("Digite seu peso!!")
            noError = false
        }
        if (alturaEditText.text.isBlank()) {
            alturaEditText.setError("Digite sua altura!!")
            noError = false
        }
        return noError
    }

}