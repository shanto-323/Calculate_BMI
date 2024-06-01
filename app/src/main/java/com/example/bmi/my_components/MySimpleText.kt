package com.example.bmi.my_components

import android.util.Size
import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun MySimpleText(
    label:String,
    size: Int,
    fontWeight: FontWeight,
    color: Color = MaterialTheme.colorScheme.secondary
) {
    Text(
        text = label,
        style = TextStyle(
            fontSize = size.sp,
            fontWeight = fontWeight,
            color = color
        )
    )
}