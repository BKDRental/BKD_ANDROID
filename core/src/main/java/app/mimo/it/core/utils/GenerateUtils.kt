package app.mimo.it.core.utils

import app.mimo.it.core.AppConstants

object GenerateUtils {

    fun textGenerate(): String {
        val sb = StringBuilder()
        repeat(AppConstants.characters.length) {
            sb.append(AppConstants.characters[(AppConstants.characters.indices).random()])
        }
        return sb.toString()
    }
}