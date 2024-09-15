package com.example.bmi.presentation.calculatorui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.bmi.presentation.calculatorui.BmiViewModel

@Composable
fun DialogScreen(
  modifier: Modifier = Modifier, openDialog: () -> Unit, viewModel: BmiViewModel
) {
  Dialog(
    onDismissRequest = openDialog

  ) {
    Column(
      modifier
        .fillMaxWidth()
        .fillMaxHeight(0.3f)
        .clip(RoundedCornerShape(20.dp))
        .background(MaterialTheme.colorScheme.secondary)
        .padding(10.dp),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      Column(
        modifier
          .fillMaxWidth()
          .weight(1f), horizontalAlignment = Alignment.CenterHorizontally
      ) {

        //Upper Part of Dialog Screen
        Row(
          modifier
            .fillMaxWidth()
            .padding(10.dp), verticalAlignment = Alignment.CenterVertically
        ) {
          Icon(
            imageVector = Icons.Default.Close, contentDescription = "Close Button",
            modifier.clickable(
              onClick = openDialog
            ),
            tint = MaterialTheme.colorScheme.primary
          )
          Text(
            text = "BMI",
            color = MaterialTheme.colorScheme.primary,
            fontSize = 18.sp,
            style = TextStyle(
              fontSize = 24.sp,
              textAlign = TextAlign.End,
              fontWeight = FontWeight.SemiBold,
              fontFamily = FontFamily.Monospace,
              color = MaterialTheme.colorScheme.secondary
            ),
            modifier = Modifier.weight(1f)
          )
        }

        ShapeLine(color = MaterialTheme.colorScheme.primary, strokeWidth = 2f)


          Column(
            modifier
              .weight(1f)
              .fillMaxSize()
              .padding(30.dp,5.dp)
          ) {
            SimpleTextForDialog(sizeCount = viewModel.state.height, stateName = "HEIGHT")
            SimpleTextForDialog(sizeCount = viewModel.state.weight, stateName = "WEIGHT")
            SimpleTextForDialog(sizeCount = viewModel.state.result, stateName = "BMI =")
          }


      }

      //Chart About BMI State
      BmiChart()
      Spacer(modifier.padding(10.dp))
    }
  }
}


@Composable
fun SimpleTextForDialog(
  sizeCount: String,
  stateName: String,
) {
  Row(
    verticalAlignment = Alignment.CenterVertically
  ) {
    Text(
      text = stateName, style = TextStyle(
        fontSize = 14.sp,
        color = MaterialTheme.colorScheme.primary,
        fontWeight = FontWeight.ExtraBold,
        fontFamily = FontFamily.Monospace
      )
    )
    Text(
      text = sizeCount, style = TextStyle(
        fontSize = 12.sp,
        color = MaterialTheme.colorScheme.primary,
        textAlign = TextAlign.Right
      ), modifier = Modifier
        .fillMaxWidth()
        .weight(1f)
    )
  }
}