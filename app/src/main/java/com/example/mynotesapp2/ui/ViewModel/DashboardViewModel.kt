package com.example.mynotesapp2.ui.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Database
import com.example.mynotesapp2.data.Model.Note
import com.example.mynotesapp2.data.Model.database.dao.UserModelDao
import com.example.mynotesapp2.data.Model.remote.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel

class DashboardViewModel @Inject constructor(
    private val repository: ApiService,
) : ViewModel() {
    fun fetchDashboardData(onDataFetched: (Boolean) -> Unit) {
        viewModelScope.launch {
            val response = repository.getAllNotesbyIdUSer(idP = 1)
            if (response.isSuccessful) {
                val dashboardData = response.body()
                onDataFetched(dashboardData != null)
            } else {
                onDataFetched(false)
            }
        }
    }
}
