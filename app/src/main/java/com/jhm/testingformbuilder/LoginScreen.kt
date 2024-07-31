package com.jhm.testingformbuilder

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jhm.formbuilder.OutlinedTextFieldWithValidator

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = viewModel()
) {
    val uiState by loginViewModel.uiState.collectAsState()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(top = 40.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            val userField = uiState.loginForm.fields[LoginForm.USER]!!
            OutlinedTextFieldWithValidator(
                value = userField.value,
                onValueChange =  {
                    loginViewModel.onFormValueChange(LoginForm.USER, it)
                },
                validators = userField.validators,
                label = {
                    Text(text = "Usuario")
                }
            )

            val passwordField = uiState.loginForm.fields[LoginForm.PASSWORD]!!
            OutlinedTextFieldWithValidator(
                value = passwordField.value,
                onValueChange =  {
                    loginViewModel.onFormValueChange(LoginForm.PASSWORD, it)
                },
                validators = passwordField.validators,
                label = {
                    Text(text = "Contraseña")
                }
            )

            val context = LocalContext.current
            Button(
                onClick = {
                    Toast.makeText(context, if(uiState.loginForm.isValid()) "Valido" else "Invalido", Toast.LENGTH_SHORT).show()
                }
            ) {
                Text(text = "Login")
            }
        }
    }
}