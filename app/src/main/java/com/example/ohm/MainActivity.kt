package com.example.ohm

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import com.example.ohm.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calcular.setOnClickListener {
            try {



            val corrente = binding.correntetext.text.toString().toFloat()
            val resistencia = binding.resistenciatext.text.toString().toFloat()

                val ohm = Ohm(corrente, resistencia)
                binding.resposta.text = "Resultado: ${ohm.calcularOhm()}Ω"

            } catch(e: NumberFormatException){
                binding.resposta.text = "Numero invalido!"
            }
        }
    }

    class Ohm(val corrente: Float, val resistencia: Float) {
        fun calcularOhm(): Float = corrente * resistencia


        fun descricaoOhm(): String {

            return "O resultado é: ${calcularOhm()}"
        }
    }
}