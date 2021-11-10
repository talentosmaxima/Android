package br.com.maximatech.core.extensions

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.showSnackbar(
    message: String,
    length: Int = Snackbar.LENGTH_LONG,
    anchorView: View
) {
    val snackBar = Snackbar.make(this, message, length)
    snackBar.anchorView = anchorView
    snackBar.setAction("fechar") {
        snackBar.dismiss()
    }
    snackBar.show()
}
