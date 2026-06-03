package com.example.tracker.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    var username by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    var isLoginEnabled by mutableStateOf(false)
        private set

    fun onUsernameChange(value: String) {
        username = value
        validate()
    }

    fun onPasswordChange(value: String) {
        // Enforce numeric and length <= 4
        if (value.length <= 4 && value.all { it.isDigit() }) {
            password = value
            validate()
        }
    }

    private fun validate() {
        isLoginEnabled = username.isNotBlank() && password.length == 4
    }

    fun login(onSuccess: () -> Unit) {
        if (isLoginEnabled) {
            onSuccess()
        }
    }
}
