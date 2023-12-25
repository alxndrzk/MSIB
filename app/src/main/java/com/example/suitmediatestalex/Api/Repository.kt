package com.example.suitmediatestalex.Api

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.suitmediatestalex.PagingSource
import com.example.suitmediatestalex.model.ResponseUser

class Repository(private val apiService: ApiService) {

    fun getUsers(): LiveData<PagingData<ResponseUser>>{
        return Pager(
            config = PagingConfig(
                pageSize = 5
            ),
            pagingSourceFactory = {
                PagingSource(apiService)
            }
        ).liveData
    }

}