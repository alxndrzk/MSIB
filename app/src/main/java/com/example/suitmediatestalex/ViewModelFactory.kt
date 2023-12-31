package com.example.suitmediatestalex

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.suitmediatestalex.Api.Injection
import com.example.suitmediatestalex.model.ThirdActivityViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ThirdActivityViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ThirdActivityViewModel(Injection.provideRepository(context)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}