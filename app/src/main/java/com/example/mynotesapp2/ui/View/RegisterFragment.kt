package com.example.mynotesapp2.ui.View

import com.example.mynotesapp2.ui.ViewModel.RegisterViewModel2
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mynotesapp2.R
import com.example.mynotesapp2.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private val viewModel: RegisterViewModel2 by viewModels()

    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getUser()
        binding.btnRegister.setOnClickListener {
            val email = binding.tfCorreo.text.toString()
            val password = binding.tfpass.text.toString()
            val confirmPassword = binding.confirPass.text.toString()

            val result = viewModel.validateFields(email, password, confirmPassword)
            if (result == "Registrado Exitosamente") {
                viewModel.registerUser(
                    email,
                    password,
                    confirmPassword
                    ){
                    Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()

                }
//
//                findNavController().navigate(R.id.action_registerFragment_to_login)
            }/* else {
                Toast.makeText(requireContext(), result, Toast.LENGTH_SHORT).show()
            }*/
        }
    }
}
