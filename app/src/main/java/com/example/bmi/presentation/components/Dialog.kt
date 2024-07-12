package com.example.bmi.presentation.components

import android.app.AlertDialog
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


fun dialog(
    context: Context,
    text: String,
) {
    val builder: AlertDialog.Builder = AlertDialog.Builder(context)
    builder.setMessage("$text")
    val dialog: AlertDialog = builder.create()
    dialog.show()
}