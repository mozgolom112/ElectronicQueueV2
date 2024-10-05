package ru.mozgolom112.electronicqueue.domain.viewstate

data class AuthorizationViewState(
    val username: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isPasswordVisible: Boolean = false,
    val errorMessage: String = ""
)
