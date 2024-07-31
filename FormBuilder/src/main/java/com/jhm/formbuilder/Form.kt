package com.jhm.formbuilder

interface Form {
    val fields: Map<String, FormField>
    val isValid: () -> Boolean get() = {
        val validations = fields.map { mapEntry ->
            val formField = mapEntry.value
            formField.validators.any { validator -> validator.validate(formField.value) }
        }
        validations.all { !it }
    }
}