package com.example.bmi.presentation.calculatorui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bmi.presentation.calculatorui.components.Calculate
import com.example.bmi.presentation.calculatorui.components.DialogScreen
import com.example.bmi.presentation.calculatorui.components.DisplayNumberButton
import com.example.bmi.presentation.calculatorui.components.Event
import com.example.bmi.presentation.calculatorui.components.ShapeLine
import com.example.bmi.presentation.calculatorui.components.SimpleText
import com.example.bmi.presentation.calculatorui.components.TopPart
import com.example.bmi.presentation.calculatorui.components.makeToast

@Composable
fun BmiScreen(
  modifier: Modifier = Modifier,
  viewModel: BmiViewModel = hiltViewModel()
) {

  val context = LocalContext.current
  var weight by rememberSaveable { mutableStateOf("0") }
  var height by rememberSaveable { mutableStateOf("0") }
  var text by rememberSaveable { mutableStateOf("") }
  var heightSelected by rememberSaveable { mutableStateOf(true) }
  var showDialog by remember { mutableStateOf(false) }

  Column(
    modifier
      .systemBarsPadding()
      .statusBarsPadding()
      .fillMaxSize()
      .background(MaterialTheme.colorScheme.primary)
      .padding(10.dp),
    verticalArrangement = Arrangement.Bottom,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {

    TopPart()
    Spacer(modifier = Modifier.padding(30.dp))

    Column(
      modifier = Modifier
        .weight(1f)
        .padding(20.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Top
    ) {

      if (text != "" && text.length <= 4) {
        if (heightSelected) {
          height = text
          viewModel.onEvent(Event.HeightChanged(height))
        } else {
          weight = text
          viewModel.onEvent(Event.WeightChanged(weight))
        }
      }

      SimpleText(
        countName = "HEIGHT",
        size = height,
        selected = heightSelected,
        onClick = {
          heightSelected = true
          text = ""
        }
      )
      Spacer(modifier = Modifier.padding(10.dp))
      SimpleText(
        countName = "WEIGHT",
        size = weight,
        selected = !heightSelected,
        onClick = {
          heightSelected = false
          text = ""
        }
      )
    }

    ShapeLine(color = MaterialTheme.colorScheme.secondary, strokeWidth = 2f)
    Spacer(modifier = Modifier.padding(10.dp))


    val list = listOf("AC", "0", ".")
    LazyVerticalGrid(
      columns = GridCells.Fixed(3),
    ) {
      for (i in 1..9) {
        item {
          DisplayNumberButton(
            intNo = i.toString(),
            onClick = {
              text += i.toString()
            }
          )
        }
      }
      items(list.size) {
        DisplayNumberButton(
          intNo = list[it],
          onClick = {
            if (list[it] == "AC") {
              if (heightSelected) height = "0" else weight = "0"
              text = ""
            } else {
              text += list[it]
            }
          }
        )
      }
    }

    DisplayNumberButton(
      intNo = "CALCULATE",
      modifier = Modifier
        .fillMaxWidth()
        .height(60.dp),
      onClick = {
        viewModel.onEvent(Event.Calculate)
        if(viewModel.state.result.toDouble() <= 5.00 || viewModel.state.result.toDouble() >= 40.00){
          makeToast(context,"ADD VALID NUMBER")
        }else {
          showDialog = true
        }
      }
    )

    if (showDialog) {
      DialogScreen(
        openDialog = {
          showDialog = false
        },
        viewModel = viewModel
      )
    }
  }
}