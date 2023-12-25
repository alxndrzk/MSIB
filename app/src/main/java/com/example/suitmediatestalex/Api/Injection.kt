package com.example.suitmediatestalex.Api

import android.content.Context

object Injection {
    fun provideRepository(context: Context): Repository {
        val apiService = ApiConfig.getApiService()
        return Repository(apiService)
    }
}