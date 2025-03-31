package com.example.nutriplan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
            var mealtype by remember {
                mutableStateOf("")
            }







            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                .fillMaxSize().background(Color(0xFFAAFFFF))

            ) {
                Text(text = " Nutri Plan ",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Default
                )
               Divider()
                
                Spacer(modifier = Modifier.size(30.dp))
                
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
                Text(text = meals)
            }
        }
    }
}
