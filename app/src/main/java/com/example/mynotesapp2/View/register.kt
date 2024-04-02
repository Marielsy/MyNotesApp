import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.mynotesapp2.databinding.FragmentRegisterBinding
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnRegister.setOnClickListener {
            val username = binding.tfCorreo.text.toString()
            val password = binding.tfpass.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                registerToServer(username, password)
            } else {
                Toast.makeText(requireContext(), "Ingrese un usuario y contraseña", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun registerToServer(username: String, password: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://apirest1.tecnoparaguana.org.ve/")
            .build()
// como crear una instancia global

    }


}
