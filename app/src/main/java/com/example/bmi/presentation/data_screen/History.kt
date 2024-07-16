package com.example.bmi.presentation.data_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bmi.R
import com.example.bmi.domain.model.HistoryModel
import com.example.bmi.presentation.calculator.BMIViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun History(
    viewModel: BMIViewModel = hiltViewModel(), navigateBack: () -> Unit
) {
    val bmiHistory by viewModel.getAllData().collectAsState(initial = emptyList())
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(18.dp)
    ) {
        Scaffold(topBar = {
            TopAppBar(title = {
                Text("Student List")
            }, actions = {
                IconButton(onClick = {
                    navigateBack()
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.colon),
                        contentDescription = "Exit"
                    )
                }
            })
        }, content = { paddingValues ->
            Column(
                modifier = Modifier.padding(paddingValues)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                ) {
                    items(bmiHistory.size) {
                        MyScreen(it, bmiHistory)
                    }
                }

            }
        })
    }

}


@Composable
fun MyScreen(
    itemIndex: Int, itemList: List<HistoryModel>
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        OutlinedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .height(60.dp),
            border = BorderStroke(1.dp, Color.Green),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            )

        ) {
            Column(
                modifier = Modifier.padding(35.dp, 8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp, 0.dp, 30.dp, 0.dp),
                    horizontalArrangement = Arrangement.Absolute.SpaceBetween
                ) {

                    Box(
                        modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "${itemList[itemIndex].bodyState}",
                            fontSize = 20.sp,
                            style = TextStyle(
                                textAlign = TextAlign.Center
                            )
                        )
                    }

                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "${itemList[itemIndex].date} : ${itemList[itemIndex].time}",
                            fontSize = 5.sp,
                        )
                        Spacer(modifier = Modifier.padding(2.dp))
                        Text(text = "${itemList[itemIndex].bmi}")

                    }
                }
            }
        }

    }

}
