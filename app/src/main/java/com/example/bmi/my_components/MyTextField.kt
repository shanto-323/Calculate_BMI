package com.example.bmi.my_components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun MyTextField(
    mod: Modifier,
    color: Color,
    onTextSelected:(String) -> Unit
) {
    var text by remember {mutableStateOf("") }

    Box(modifier = Modifier.then(mod)){
        TextField(
            value = text,
            onValueChange = {
                text = it
                onTextSelected(it)
            },
            modifier = Modifier
                .fillMaxWidth()
                .border(2.dp, color = color),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}