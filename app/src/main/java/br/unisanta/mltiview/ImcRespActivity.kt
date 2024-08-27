package br.unisanta.mltiview

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ImcRespActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc_resp)
        val TextImc = findViewById<TextView>(R.id.IMC)
        val TextEstado = findViewById<TextView>(R.id.Estado)
        val IMC:String = intent.getStringExtra("IMC").toString()
        val Estado:String = intent.getStringExtra("Estado").toString()
        TextImc.text = IMC



        TextEstado.text =Estado

    }
}