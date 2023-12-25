package com.example.suitmediatestalex.model

import com.google.gson.annotations.SerializedName

data class ResponseSupport(

    @field:SerializedName("url")
    val url: String,

    @field:SerializedName("text")
    val text: String

)
