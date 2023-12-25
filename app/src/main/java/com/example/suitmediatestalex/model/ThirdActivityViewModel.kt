package com.example.suitmediatestalex.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.suitmediatestalex.Api.Repository

class ThirdActivityViewModel(repository: Repository): ViewModel() {
    val dataUser: LiveData<PagingData<ResponseUser>> = repository.getUsers().cachedIn(viewModelScope)
}