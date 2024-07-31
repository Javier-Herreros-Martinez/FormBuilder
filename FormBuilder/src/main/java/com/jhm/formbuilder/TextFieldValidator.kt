package com.jhm.formbuilder

data class TextFieldValidator (
    val msg: String,
    val validate: (String) -> Boolean
)
