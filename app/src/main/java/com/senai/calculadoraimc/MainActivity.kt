package com.senai.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

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

            val resultadoTextView = findViewById<TextView>(R.id.resultado)

            if (validarCampos()) {
                val peso = pesoEditText.text.toString().toDouble()
                val altura = alturaEditText.text.toString().toDouble()

                val imc = calcularImc(peso, altura)

                resultadoTextView.text = situacao(imc)
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