package my.mildotdev.pesan.sign_up

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class SignUpUiState(val name: String = "", val username: String = "")

class SignUpViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState: StateFlow<SignUpUiState>
        get() = _uiState.asStateFlow()

    fun updateName(name: String) = _uiState.update { it.copy(name = name) }
    fun updateUsername(username: String) = _uiState.update { it.copy(username = username) }

    fun signUp() = viewModelScope.launch {

    }
}