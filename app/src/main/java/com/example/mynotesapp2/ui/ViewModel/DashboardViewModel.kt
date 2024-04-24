package com.example.mynotesapp2.ui.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynotesapp2.data.Model.Note
import com.example.mynotesapp2.data.Model.remote.ApiService
import kotlinx.coroutines.launch
import javax.inject.Inject

class DashboardViewModel @Inject constructor(private val repository: ApiService) : ViewModel() {
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
