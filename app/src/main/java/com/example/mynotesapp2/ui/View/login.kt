package com.example.mynotesapp2.ui.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mynotesapp2.R
import com.example.mynotesapp2.databinding.FragmentLoginBinding
import com.example.mynotesapp2.ui.ViewModel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            val email = binding.tfCorreo.text.toString()
            val password = binding.tfpass.text.toString()

            viewModel.login(email, password) { loginSuccess ->
                if (loginSuccess) {
                    findNavController().navigate(R.id.login)
                    Toast.makeText(requireContext(), "Iniciando sesión", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireContext(), "Datos invalidos", Toast.LENGTH_SHORT).show()
                }
            }
        }
        binding.registrarse.setOnClickListener {
            findNavController().navigate(R.id.registerFragment)
        }
    }
}
