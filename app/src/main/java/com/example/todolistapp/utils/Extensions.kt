package com.example.todolistapp.utils

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

fun Fragment.toastMessage(message: String) {
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}

fun Fragment.snackBar(message: String) {
    val snackBar = Snackbar.make(requireView(), message, Snackbar.LENGTH_SHORT).setAction("Action", null)
    snackBar.show()
}