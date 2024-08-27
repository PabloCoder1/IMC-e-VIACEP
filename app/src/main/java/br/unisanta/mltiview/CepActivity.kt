package br.unisanta.mltiview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import br.unisanta.mltiview.Dao.EnderecoDaoImpl
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

class CepActivity : AppCompatActivity() {
    private val EnderecoDao = EnderecoDaoImpl()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cep)
        val btnVoltar = findViewById<Button>(R.id.Voltar)
        val btnCep = findViewById<Button>(R.id.CepBTN)
        val gson = Gson()

        btnVoltar.setOnClickListener{
            val intent = Intent(this,FirstView::class.java)
            startActivity(intent)
        }

        btnCep.setOnClickListener{
            val txtCep = findViewById<EditText>(R.id.CepText)
            if(txtCep.length() <= 7 || txtCep.length() >= 9)
                Toast.makeText(this, "Preencha a informação corretamente", Toast.LENGTH_SHORT).show()
            else {
                val cep = txtCep.text.toString()
                val url = "https://viacep.com.br/ws/$cep/json/"
                fetchUrl(url) { json ->
                    if (json != null) {
                        try {
                          val Json = gson.fromJson(json, Endereco::class.java)
                            EnderecoDao.salvarEndereco(Json)
                            val intent = Intent(this,CepRespActivity::class.java)
                            startActivity(intent)
                        } catch (e: Exception) {
                            Toast.makeText(this, "Erro ao processar o JSON", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(this, "Erro na requisição", Toast.LENGTH_SHORT).show()
                    }
                }


            }
        }
    }

    private  fun fetchUrl(URL:String , callback: (String?) -> Unit) {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val url = URL(URL)
                val connection = url.openConnection() as HttpURLConnection
                connection.requestMethod = "GET"
                connection.connect()

                val responseCode = connection.responseCode
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    val inputStream = connection.inputStream
                    val result = inputStream.bufferedReader().use { it.readText() }

                    withContext(Dispatchers.Main) {
                        callback(result)
                    }
                }else {
                    withContext(Dispatchers.Main) {
                        callback(null)
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                withContext(Dispatchers.Main) {
                    callback(null)
                }
            }
        }
    }
}