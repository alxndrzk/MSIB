package com.example.suitmediatestalex.model

import com.google.gson.annotations.SerializedName

data class ResponseUser(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("email")
    val email: String,

    @field:SerializedName("first_name")
    val FirstName: String,

    @field:SerializedName("last_name")
    val LastName: String,

    @field:SerializedName("avatar")
    val avatar: String,
)
