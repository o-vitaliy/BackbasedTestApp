package ru.ovi.backbased.presentation.common.form

import ru.ovi.backbased.R
import java.util.regex.Pattern

class EmailValidator : InputFieldValidator<String> {
    override fun validate(input: String): Int? {
        if (!isValid(input)) {
            return R.string.form_validate_invalid_email
        }
        return null
    }

    private fun isValid(email: String?): Boolean {
        val emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$"

        val pat = Pattern.compile(emailRegex)
        return if (email == null) false else pat.matcher(email).matches()
    }
}
