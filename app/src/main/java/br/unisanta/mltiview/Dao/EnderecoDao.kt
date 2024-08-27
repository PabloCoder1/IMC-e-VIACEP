package br.unisanta.mltiview.Dao

import br.unisanta.mltiview.Endereco

interface EnderecoDao {
    fun salvarEndereco(Endereco: Endereco)
    fun obterEndereco():Endereco
}