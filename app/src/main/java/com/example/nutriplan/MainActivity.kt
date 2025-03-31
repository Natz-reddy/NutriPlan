package com.example.nutriplan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.nutriplan.ui.theme.NutriPlanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var timeofday by remember {
                mutableStateOf("")
            }
            var meals by remember {
                mutableStateOf("")
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = " Nutri Plan ")
                OutlinedTextField(value = timeofday, onValueChange = { text ->
                    timeofday = text

                },
                    placeholder = { Text(text = "Enter the time of day ") }
                )
                Row {
                    Button(onClick = {
                        meals= when(timeofday){
                            "Morning" ->"Eggs & Toast"
                            "Mid-Morning"->" Greek yogurt & berries "
                            "Lunch" -> " Grilled cheese toast and tomato soup "
                            "Afternoon"->" dried almonds and dark chocolate"
                            "Dinner"->" Roasted beef with mash & veggies "
                            "Evening snack"->"Herbal tea & biscuits"

                            else -> "Invalid Time Of Day" }
                    }) {
                        Text(text = " Meal Suggestions ")
                        
                    }

                Button(onClick = { timeofday=""
                    meals=""}) {
                    Text(text = " Reset ")
                }
                }

            Text(text = "Meal suggestion in $timeofday is : " )

            }
        }
    }
}
