package com.sandyara.aula21.data.model

data class Movie(
    val name: String,
    val description: String
) {
    fun getDataInfo() = "$name\n$description"
}