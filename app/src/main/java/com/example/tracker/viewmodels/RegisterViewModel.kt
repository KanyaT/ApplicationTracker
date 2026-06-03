package com.example.tracker.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RegisterViewModel() : ViewModel() {

    var username by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    var confirmPassword by mutableStateOf("")
        private set

    var isRegisterEnabled by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun onUsernameChange(value: String) {
        username = value
        validate()
    }

    fun onPasswordChange(value: String) {
        if (value.length <= 4 && value.all { it.isDigit() }) {
            password = value
            validate()
        }
    }

    fun onConfirmPasswordChange(value: String) {
        if (value.length <= 4 && value.all { it.isDigit() }) {
            confirmPassword = value
            validate()
        }
    }

    private fun validate() {
        isRegisterEnabled = username.isNotBlank() &&
                password.length == 4 &&
                confirmPassword == password
    }

    fun register(onSuccess: () -> Unit) {
//        if (isRegisterEnabled) {
//            viewModelScope.launch {
//                val existingUser = userDao.getUserByUsername(username)
//                if (existingUser != null) {
//                    errorMessage = "Username already exists"
//                } else {
//                    userDao.insertUser(User(username, password))
//                    onSuccess()
//                }
//            }
//        }
    }

    fun clearError() {
        errorMessage = null
    }
}