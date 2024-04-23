package com.example.mynotesapp2.ui.ViewModel

import androidx.lifecycle.ViewModel
import com.example.mynotesapp2.data.Model.remote.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(private val repository: ApiService) : ViewModel(){
}