package br.unisanta.mltiview
import com.google.gson.annotations.SerializedName

data class Endereco(
  @SerializedName("logradouro") val rua: String,
  @SerializedName("bairro") val Bairro: String,
  @SerializedName("localidade") val Cidade: String,
  @SerializedName("uf") val Estado: String,
  @SerializedName("complemento") val Complemento: String,
  @SerializedName("unidade") val Unidade: String,
)
