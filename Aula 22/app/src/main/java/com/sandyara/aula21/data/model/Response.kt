package com.sandyara.aula21.data.model

import com.sandyara.aula21.data.model.Data

data class Response(
    val code: Int,
    val etag: String,
    val data: Data
)