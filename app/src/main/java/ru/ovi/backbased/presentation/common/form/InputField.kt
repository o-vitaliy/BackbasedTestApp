package ru.ovi.backbased.presentation.common.form

open class InputField<T>(
    initialValue: T,
    private val validators: List<InputFieldValidator<T>>,
    private val validationCallback: ((IntArray) -> Unit)?
) {
    constructor(
        initialValue: T,
        validator: InputFieldValidator<T>,
        validationCallback: ((IntArray) -> Unit)? = null
    ) : this(initialValue, listOf(validator), validationCallback)

    var value: T = initialValue

    private var _errors = intArrayOf()

    val hasError: Boolean
        get() = _errors.isNotEmpty()

    fun validate() {
        _errors = validators.mapNotNull { it.validate(value) }.toIntArray()
        validationCallback?.invoke(_errors)
    }
}
