package ru.ovi.backbased.presentation.common.form

class InputStringField(
    validator: InputFieldValidator<String>,
    validationCallback: ((IntArray) -> Unit)?,
    initialValue: String = ""
) : InputField<String>(initialValue, validator, validationCallback)
