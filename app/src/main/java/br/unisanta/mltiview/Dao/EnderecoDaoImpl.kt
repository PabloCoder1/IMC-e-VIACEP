package br.unisanta.mltiview.Dao

import br.unisanta.mltiview.Endereco

class EnderecoDaoImpl:EnderecoDao {
    companion object{
        private var endereco:Endereco? =null
    }
    override fun salvarEndereco(ende: Endereco) {
        Companion.endereco = ende
    }

    override fun obterEndereco(): Endereco {
        return Companion.endereco?: Endereco("","","","","","");
    }
}