package com.example.mynotesapp2.ui.View

import RegisterViewModel2
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mynotesapp2.data.Model.remote.getAllUsers
import com.example.mynotesapp2.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class RegisterFragment : Fragment() {

    private val viewModel :  RegisterViewModel2 by viewModels()
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//         viewModel = ViewModelProvider(this)[RegisterViewModel2::class.java]
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//         val viewModel by viewModels<RegisterViewModel2>()


        viewModel.users.observe(viewLifecycleOwner){/*
            Log.e("TAG", "onViewCreated: ${it}")*/

        binding.btnRegister.setOnClickListener {
            viewModel.getUser1()
            val email = binding.tfCorreo.text.toString()
            val password = binding.tfpass.text.toString()
            val confirmPassword = binding.confirPass.text.toString()

            // Valida campos
            val errorMessage = viewModel.validateFields(email, password, confirmPassword)
            if (errorMessage != null) {
                Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
                binding.btnRegister
            }
            val emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}".toRegex()
            if (!email.matches(emailPattern)) {
                Toast.makeText(requireContext(),
                    "Formato de correo electrónico inválido",
                    Toast.LENGTH_SHORT
                ).show()
                binding.btnRegister
            }

            val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#\$%^&*()-_=+\\\\|\\[{\\]};:'\",<.>/?]).{8,}\$".toRegex()
            if(!password.matches(passwordPattern)){
                Toast.makeText(requireContext(),"La contraseña no cumple los parametros requeridos",
                    Toast.LENGTH_SHORT
                ).show()
                binding.btnRegister.setOnClickListener {viewModel}
            }
        }

        }
    }


}

