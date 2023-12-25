package com.example.suitmediatestalex.model

import com.google.gson.annotations.SerializedName

data class Response(
    @field:SerializedName("page")
    val page: Int,

    @field:SerializedName("per_page")
    val perPage: Int,

    @field:SerializedName("total")
    val total: Int,

    @field:SerializedName("total_pages")
    val totalPages: Int,

    @field:SerializedName("data")
    val data: List<ResponseUser>,

    @field:SerializedName("support")
    val support: ResponseSupport

)
