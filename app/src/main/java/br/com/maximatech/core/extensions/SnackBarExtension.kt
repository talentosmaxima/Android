package br.com.maximatech.core.extensions

import android.view.View
import br.com.maximatech.R
import com.google.android.material.snackbar.Snackbar

fun View.showSnackbarWithAnchorView(
    message: String,
    length: Int = Snackbar.LENGTH_LONG,
) {
    val snackBar = Snackbar.make(this, message, length)
    snackBar.setAnchorView(R.id.bottom_nav_view)
    snackBar.setAction("fechar") {
        snackBar.dismiss()
    }
    snackBar.show()
}

fun View.showSnackbar(
    message: String,
    length: Int = Snackbar.LENGTH_LONG,
) {
    val snackBar = Snackbar.make(this, message, length)
    snackBar.setAction("fechar") {
        snackBar.dismiss()
    }
    snackBar.show()
}