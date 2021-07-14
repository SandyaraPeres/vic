package com.sandyara.aula21.data.model

import com.sandyara.aula21.data.model.Character

data class Data(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<Character>
)