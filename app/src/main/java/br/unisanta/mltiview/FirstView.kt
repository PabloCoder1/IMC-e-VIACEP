package br.unisanta.mltiview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FirstView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_first_view)
        val btnNavegarIMC = findViewById<Button>(R.id.imc)
        val btnNavegarCep = findViewById<Button>(R.id.cep)
        btnNavegarIMC.setOnClickListener{
            val intent = Intent(this,ImcActivity::class.java)
            startActivity(intent)
        }
        btnNavegarCep.setOnClickListener{
            val intent = Intent(this,CepActivity::class.java)
            startActivity(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }
    }
}