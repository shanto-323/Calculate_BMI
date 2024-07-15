package com.example.bmi.presentation.data_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bmi.R
import com.example.bmi.domain.model.HistoryModel
import com.example.bmi.presentation.calculator.BMIViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun History(
    viewModel: BMIViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {
    val bmiHistory by viewModel.getAllData().collectAsState(initial = emptyList())
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(18.dp)
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("Student List")
                    },
                    actions = {
                        IconButton(
                            onClick = {
                                navigateBack()
                            }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.colon),
                                contentDescription = "Exit"
                            )
                        }
                    }
                )
            },
            content = { paddingValues ->
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
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
            }
        )


    }

}



@Composable
fun MyScreen(
    itemIndex: Int,
    itemList: List<HistoryModel>
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(text = itemList[itemIndex].id.toString())
            Spacer(modifier = Modifier.padding(20.dp))
            Text(text = itemList[itemIndex].bmi)
            Spacer(modifier = Modifier.padding(20.dp))
            Text(text = itemList[itemIndex].bodyState)
            Spacer(modifier = Modifier.padding(20.dp))
        }
    }
}