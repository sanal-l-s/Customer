package com.example.customer.util

import android.view.View
import android.widget.Toast

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.toggleVisibility() {
    visibility = if (visibility == View.VISIBLE) View.INVISIBLE else View.VISIBLE
}

fun View.isVisible(): Boolean {
    return visibility == View.VISIBLE
}

fun View.isNotVisible(): Boolean {
    return visibility != View.VISIBLE
}

fun View.showShortToast(message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun View.showLongToast(message: String) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}