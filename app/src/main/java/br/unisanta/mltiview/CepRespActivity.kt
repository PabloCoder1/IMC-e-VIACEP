package br.unisanta.mltiview

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import br.unisanta.mltiview.Dao.EnderecoDaoImpl

class CepRespActivity : AppCompatActivity() {
    private val EnderecoDao = EnderecoDaoImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cep_resp)
        val txtRua = findViewById<TextView>(R.id.rua)
        val txtBairro = findViewById<TextView>(R.id.Bairr)
        val txtCidade = findViewById<TextView>(R.id.Cidade)
        val txtUF = findViewById<TextView>(R.id.UF)
        val txtCom = findViewById<TextView>(R.id.complemento)
        val txtUni = findViewById<TextView>(R.id.Unidade)

        val endereco:Endereco = EnderecoDao.obterEndereco()

        txtRua.text = "Rua: "+endereco.rua
        txtBairro.text = "Bairro: "+endereco.Bairro
        txtCidade.text = "Cidade: "+endereco.Cidade
        txtUF.text = "Estado: "+endereco.Estado
        txtCom.text = "Complemento: "+endereco.Complemento
        txtUni.text = "Unidade: "+endereco.Unidade
    }
}