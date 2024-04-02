package com.example.mynotesapp2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.mynotesapp2.ViewModel.RegisterViewModel
import com.example.mynotesapp2.ViewModel.viewModelFactory
import com.example.mynotesapp2.data.Model.remote.ApiService
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class registerFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var viewModel: RegisterViewModel
    private val retrofitService = ApiService.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val factory = viewModelFactory {
            RegisterViewModel(retrofitService)
        }
        viewModel = ViewModelProvider(this, factory).get(RegisterViewModel::class.java)

        val btn = view?.findViewById<Button>(R.id.btnLogin)

        lifecycleScope.launch {
            while (true){
                delay(10000)
                viewModel.registerViewModel2.getUser()
            }

        }

        btn?.setOnClickListener {
            lifecycleScope.launch {
                viewModel.getUsers()
            }
        }



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_register, container, false)
    }


}