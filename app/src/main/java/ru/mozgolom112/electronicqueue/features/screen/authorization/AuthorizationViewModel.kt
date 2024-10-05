package ru.mozgolom112.electronicqueue.features.screen.authorization

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.mozgolom112.electronicqueue.domain.viewstate.AuthorizationViewState

class AuthorizationViewModel : ViewModel() {
    //State of screen
    private val _authorizationState = MutableStateFlow(AuthorizationViewState())
    val authorizationState: StateFlow<AuthorizationViewState> = _authorizationState

    //Processing of changes to the state
    fun onUsernameChange(newUsername: String) {
        _authorizationState.value = _authorizationState.value.copy(username = newUsername)
    }

    fun onPasswordChange(newPassword: String) {
        _authorizationState.value = _authorizationState.value.copy(password = newPassword)
    }

    //Click processing
    fun onShowPasswordClick() {
        _authorizationState.value =
            _authorizationState.value.copy(isPasswordVisible = !_authorizationState.value.isPasswordVisible)
    }

    fun onLoginClick() {
        _authorizationState.value = _authorizationState.value.copy(errorMessage = "")
        val currentState = _authorizationState.value

        //check currentState
        if (currentState.username.isEmpty() || currentState.password.isEmpty()) {
            _authorizationState.value = currentState.copy(errorMessage = "Username and password cannot be empty")
            return
        }

        viewModelScope.launch {
            _authorizationState.value = currentState.copy(isLoading = true)

            delay(1000)
            // Moc Simple Check
            if (currentState.username == "admin" && currentState.password == "password") {
                _authorizationState.value = currentState.copy(
                    errorMessage = "Login successful",
                    isLoading = false
                )
            } else {
                _authorizationState.value = currentState.copy(
                    errorMessage = "Invalid credentials",
                    isLoading = false
                )
            }

        }

    }

    fun onRegistrationClick() {
        //navigate to Registration Screen
    }
}