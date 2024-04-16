//import android.util.Log
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.mynotesapp2.data.Model.remote.ApiService
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.withContext
//import javax.inject.Inject
//
//@HiltViewModel
//class LoginViewModel @Inject constructor(
//    private val apiService: ApiService
//) : ViewModel() {
//
//    fun getUser() {
//        viewModelScope.launch {
//            try {
//                val response = apiService.getAllUsers()
//                if (response.isSuccessful) {
//                    withContext(Dispatchers.Main) {
//                        Log.e("TAG", "getUser: ${response.body()}")
//                    }
//                } else {
//                    Log.e("TAG", "getUser: ${response.errorBody()?.string()}")
//                }
//            } catch (e: Exception) {
//                Log.e("TAG", "getUser: Error - ${e.message}")
//            }
//        }
//    }
//
//    class LoginViewModel @Inject constructor(
//        private val apiService: ApiService
//    ) : ViewModel() {
//
//        private fun isValidEmail(email: String): Boolean {
//            val emailPattern = Regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
//            return emailPattern.matches(email)
//        }
//
//
//        private fun isValidPassword(password: String): Boolean {
//            val passwordPattern =
//                Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#\$%^&*()-_=+\\\\|\\[{\\]};:'\",<.>/?]).{8,}\$")
//            return passwordPattern.matches(password)
//        }
//
//        fun authenticateUser(email: String, password: String) {
//            viewModelScope.launch {
//                if (!isValidEmail(email)) {
//                    // Manejar caso de correo electrónico no válido
//                    // Puedes lanzar una excepción o manejarlo de otra manera
//                    return@launch
//                }
//
//                if (!isValidPassword(password)) {
//                    // Manejar caso de contraseña no válida
//                    // Puedes lanzar una excepción o manejarlo de otra manera
//                    return@launch
//                }
//
//                // Aquí puedes proceder con la autenticación del usuario
//            }
//        }
//    }
//}
//
//
//
//
//
//
