package com.example.suitmediatestalex

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.suitmediatestalex.Api.ApiService
import com.example.suitmediatestalex.model.ResponseUser

class PagingSource(private val apiService: ApiService): PagingSource<Int, ResponseUser>() {

    private companion object{
        const val PAGE_INDEX = 1
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResponseUser> {
        return try {
            val page = params.key ?: PAGE_INDEX
            val response = apiService.getUsers(page, params.loadSize)

            LoadResult.Page(
                data = response.data,
                prevKey = if (page == 1) null else page -1,
                nextKey = if (page == response.totalPages) null else page +1
            )
        } catch (exception: Exception){
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ResponseUser>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey
        }
    }
}