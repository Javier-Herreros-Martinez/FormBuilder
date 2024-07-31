package com.jhm.testingformbuilder

import com.jhm.formbuilder.DefaultTextFieldValidator
import com.jhm.formbuilder.Form
import com.jhm.formbuilder.FormField
import com.jhm.formbuilder.TextFieldValidator

data class LoginForm(
    override val fields: Map<String, FormField> = mapOf(
        USER to FormField(
            value = "",
            validators = listOf(
                TextFieldValidator(
                    msg = "Campo obligatorio",
                    validate = DefaultTextFieldValidator::required
                ),
                TextFieldValidator(
                    msg = "Formato de email incorrecto",
                    validate = DefaultTextFieldValidator::email
                )
            )
        ),
        PASSWORD to FormField(
            value = "",
            validators = listOf(
                TextFieldValidator(
                    msg = "Campo obligatorio",
                    validate = DefaultTextFieldValidator::required
                ),
                TextFieldValidator(
                    msg = "Minimo 10 caracteres",
                    validate = {
                        it.length < 10
                    }
                )
            )
        )
    )
) : Form {
    companion object {
        const val USER = "user"
        const val PASSWORD = "password"
    }
}
