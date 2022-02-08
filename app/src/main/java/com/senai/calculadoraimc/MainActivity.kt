package com.senai.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val calcular = findViewById<Button>(R.id.calcular)
        val sair = findViewById<Button>(R.id.sair)

        calcular.setOnClickListener() {
            val peso = findViewById<EditText>(R.id.peso).text.toString().toDouble()
            val altura = findViewById<EditText>(R.id.altura).text.toString().toDouble()
            val resultado = findViewById<TextView>(R.id.resultado)

            val decimal = DecimalFormat("#,###.00")

            val imc = peso / (altura * altura)

            if (imc <= 18.5)
                resultado.text = "Seu IMC é: ${decimal.format(imc)} e você está abaixo do peso. Cuidado!"
            else if (imc > 18.5 && imc < 24.9)
                resultado.text = "Seu IMC é: ${decimal.format(imc)} , e você está no peso ideal, parabéns!"
            else if (imc > 25 && imc < 29.9)
                resultado.text = "Seu IMC é: ${decimal.format(imc)} ,e você está levemente acima do peso."
            else if (imc > 30 && imc < 34.9)
                resultado.text = "Seu IMC é: ${decimal.format(imc)} ,e você está com obesidade grau I."
            else if (imc > 35 && imc < 39.9)
                resultado.text = "Seu IMC é: ${decimal.format(imc)} ,e você está com obesidade grau II."
            else
                resultado.text = "Seu IMC é: ${decimal.format(imc)} ,e você está com obesidade grau III."
        }

        sair.setOnClickListener() {
            finish()
        }
    }
}