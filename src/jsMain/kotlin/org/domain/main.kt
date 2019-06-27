package org.domain

import kotlin.browser.document

fun main() {
    document.body!!.textContent = "Hello from ${someLogic()}"
}

fun someLogic(): String {
    return "Kotlin/JS"
}
