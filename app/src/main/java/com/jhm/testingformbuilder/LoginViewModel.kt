package com.jhm.testingformbuilder

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LoginState())
    val uiState = _uiState.asStateFlow()

    fun onFormValueChange(fieldId: String, value: String) {
        val loginForm = _uiState.value.loginForm
        val fields = loginForm.fields.toMutableMap()
        fields[fieldId] = fields[fieldId]!!.copy(value = value)
        _uiState.update {
            it.copy(loginForm = loginForm.copy(fields = fields))
        }
    }

}