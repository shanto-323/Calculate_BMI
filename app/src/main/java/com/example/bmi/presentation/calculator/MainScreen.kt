package com.example.bmi.presentation.calculator

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmi.R
import com.example.bmi.presentation.calculator.items.UIEvent
import com.example.bmi.presentation.components.MySimpleText
import com.example.bmi.presentation.components.MyTextField

@Composable
fun BmiCalculator(
    bmiViewModel: BMIViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Text(
                    text = bmiViewModel.uiState.value.calculate,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 40.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.End
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Text(
                    text = bmiViewModel.uiState.value.bodyState,
                    color = bmiViewModel.uiState.value.color,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.End
                )
            }
        }


        Shape(
            color = MaterialTheme.colorScheme.secondary
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(68.dp)
                .padding(top = 10.dp)
        ) {
            Box(
                modifier = Modifier
                    .padding(end = 5.dp)
                    .fillMaxWidth(0.5f)
                    .align(Alignment.CenterVertically)
                    .background(MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ) {
                MySimpleText(
                    label = "HEIGHT",
                    size = 32,
                    fontWeight = FontWeight.Bold,
                )
            }
            MyTextField(
                onTextSelected = {
                    bmiViewModel.onEvent(UIEvent.FirstNumberChanged(it))
                },
                painter = painterResource(id = R.drawable.height),
                length = 3
            )
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(68.dp)
                .padding(top = 5.dp)
        ) {
            Box(
                modifier = Modifier
                    .padding(end = 5.dp)
                    .fillMaxWidth(0.5f)
                    .align(Alignment.CenterVertically)
                    .background(MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ) {
                MySimpleText(
                    label = "WEIGHT",
                    size = 32,
                    fontWeight = FontWeight.Bold,
                )
            }
            MyTextField(
                onTextSelected = {
                    bmiViewModel.onEvent(UIEvent.SecondNumberChanged(it))
                },
                painter = painterResource(id = R.drawable.scale),
                length = 3
            )
        }


        Spacer(modifier = Modifier.padding(20.dp))
        Box(
            modifier = Modifier
                .height(50.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(color = MaterialTheme.colorScheme.tertiary),
            contentAlignment = Alignment.Center

        ) {
            TextButton(
                onClick = {
                    bmiViewModel.calculate()
                },
                modifier = Modifier
                    .fillMaxSize()
            ) {
                MySimpleText(
                    label = "CALCULATE",
                    size = 24,
                    fontWeight = FontWeight.Bold,
                )
            }
        }

        Spacer(modifier = Modifier.padding(3.dp))
        Box(
            modifier = Modifier
                .height(50.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(color = MaterialTheme.colorScheme.error),
            contentAlignment = Alignment.Center

        ) {
            TextButton(
                onClick = {
                    bmiViewModel.clean()
                },
                modifier = Modifier
                    .fillMaxSize()
            ) {
                MySimpleText(
                    label = "AC",
                    size = 24,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
        Spacer(modifier = Modifier.padding(40.dp))
    }
}


@Composable
fun Shape(
    color: Color
) {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
    ) {
        drawLine(
            start = Offset(0f, 0f),
            end = Offset(size.width, 0f),
            color = color,
            strokeWidth = 10f
        )
    }
}