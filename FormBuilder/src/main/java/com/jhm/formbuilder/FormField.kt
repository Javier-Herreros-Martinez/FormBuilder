package com.jhm.formbuilder

data class FormField (
    val value: String,
    val validators: List<TextFieldValidator> = emptyList()
)