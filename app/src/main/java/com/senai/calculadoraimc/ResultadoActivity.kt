package com.senai.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        //Declaração
        val pesoTextView = findViewById<TextView>(R.id.peso)
        val alturaTextView = findViewById<TextView>(R.id.altura)
        val imcTextView = findViewById<TextView>(R.id.resultadoImc)
        val situacaoTextView = findViewById<TextView>(R.id.situacaoImc)

        val intent: Intent = getIntent()

        val actionBar = supportActionBar

        actionBar!!.setDefaultDisplayHomeAsUpEnabled(true)

        //Ação
        pesoTextView.text = intent.getStringExtra("peso")
        alturaTextView.text = intent.getStringExtra("altura")
        imcTextView.text = intent.getStringExtra("imc")
        situacaoTextView.text = intent.getStringExtra("situacao")

    }
}