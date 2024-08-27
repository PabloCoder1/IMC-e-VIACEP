package br.unisanta.mltiview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ImcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc)
        val btnVoltar = findViewById<Button>(R.id.voltar)
        val btnCalc = findViewById<Button>(R.id.Calcular)


        btnVoltar.setOnClickListener{
            val intent = Intent(this,FirstView::class.java)
            startActivity(intent)
        }
        btnCalc.setOnClickListener{
            val Peso = findViewById<EditText>(R.id.Peso)
            val Altura = findViewById<EditText>(R.id.Altura)
            if(Peso.text.toString() == "" || Altura.text.toString() == "")
                Toast.makeText(this, "Preencha as duas medidas", Toast.LENGTH_SHORT).show()
            else{
                val P = Peso.text.toString().toFloat()
                val A = Altura.text.toString().toFloat()
                val IMC = P / (A*A)
                val intent = Intent(this,ImcRespActivity::class.java)
                var Estado = ""

                val imcnunber = IMC.toFloat()
                if (imcnunber <= 18.5)
                    Estado= "Abaixo do normal"
                else if (imcnunber in 18.6..24.9)
                    Estado= "Normal"
                else if (imcnunber in 25.0..29.9)
                    Estado= "Sobrepeso"
                else if (imcnunber in 30.0 ..34.9)
                    Estado= "Obesidade grau I"
                else if (imcnunber in 35.0 ..39.9)
                    Estado= "Obesidade grau II"
                else if (imcnunber >= 40.0)
                    Estado= "Obesidade grau III"
                else
                    Estado = "Invalido"

                intent.putExtra("IMC",String.format("%.2f", IMC))
                intent.putExtra("Estado", Estado)
                startActivity(intent)
            }

        }

    }
}