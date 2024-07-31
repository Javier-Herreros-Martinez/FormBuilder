package com.jhm.formbuilder

import android.util.Patterns

object DefaultTextFieldValidator {

    fun required(value: String): Boolean = value.isEmpty()

    fun email(value: String): Boolean {
        return value.isNotEmpty() && !Patterns.EMAIL_ADDRESS.matcher(value).matches()
    }



}