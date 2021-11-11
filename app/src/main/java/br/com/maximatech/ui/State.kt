package br.com.maximatech.ui

import android.view.View

enum class State { LOADING, ERROR, SUCCESS }

class ViewManagerState(
    private val mainView: View,
    private val btnTentarNovamente: View,
    private val loadingView: View
) {
    fun success() {
        mainView.visibility = View.VISIBLE
        btnTentarNovamente.visibility = View.GONE
        loadingView.visibility = View.GONE
    }

    fun loading() {
        mainView.visibility = View.GONE
        btnTentarNovamente.visibility = View.GONE
        loadingView.visibility = View.VISIBLE
    }

    fun error() {
        mainView.visibility = View.GONE
        btnTentarNovamente.visibility = View.VISIBLE
        loadingView.visibility = View.GONE
    }

}