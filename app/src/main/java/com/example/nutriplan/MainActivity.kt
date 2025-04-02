package com.example.nutriplan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
                mutableStateOf("heavy meal")
            }

            
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF2E3131))

            ) {
                Text(
                    text = " Nutri Plan ",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Black,
                    fontFamily = FontFamily.Monospace
                )
                Divider()

                Spacer(modifier = Modifier.size(30.dp))

                OutlinedTextField(value = timeofday, onValueChange = { text ->
                    timeofday = text


                },
                    placeholder = { Text(text = "Enter the time of day ",
                        color = Color.Black) }
                )
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = " Choose Meal Type ",
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Black
                )

                Row {
                    Button(
                        onClick = { mealtype = "light"},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = when (mealtype) {
                                "light" -> Color(0xFF81C784)
                                else -> Color.LightGray
                            }
                        )
                    ) {
                        Text("Light Meal",
                            color = Color.Black,
                            fontSize = 13.sp,
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Black
                            )

                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Button(
                        onClick = { mealtype = "heavy" },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = when (mealtype) {
                                "heavy" -> Color(0xFF81C784)
                                else -> Color.LightGray
                            }
                        )
                    ) {
                        Text("Heavy Meal",
                                color = Color.Black,
                            fontSize = 13.sp,
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold)
                    }
                }
                Spacer(modifier = Modifier.size(30.dp))
                    Row {

                        Button(onClick = {
                            meals = when (timeofday.lowercase()) {
                                "breakfast" -> when (mealtype) {
                                    "light" -> "Oatmeal with fruits"
                                    else -> "Eggs & bacon"
                                }

                                "mid-morning" -> when (mealtype) {
                                    "light" -> "Greek yogurt"
                                    else -> "Yogurt with granola"
                                }

                                "lunch"-> when (mealtype) {
                                    "light" -> "Vegetable salad"
                                    else -> "Chicken with rice"
                                }

                                "afternoon snack" -> when (mealtype) {
                                    "light" -> "Fruit salad"
                                    else -> "Sandwich with soup"
                                }

                                "dinner" -> when (mealtype) {
                                    "light" -> "Grilled fish"
                                    else -> "Steak with potatoes"
                                }

                                "evening snack" -> when (mealtype) {
                                    "light" -> "Herbal tea"
                                    else -> "Toast with peanut butter"
                                }

                                else -> "Invalid Time Of Day, Please try again"
                            }
                        }) {
                            Text(text = " Meal Suggestions "
                                )

                        }
                        Spacer(modifier = Modifier.width(220.dp))
                        Button(
                            onClick = {
                                timeofday = ""
                                meals = ""
                                mealtype = "Light"
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFEF5350)
                            )
                        ) {
                            Text("Reset")
                        }


                    }
                    Column {
                        Text(text = "Meal suggestion in $timeofday is : ",
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Black,
                            modifier = Modifier
                                .align(Alignment.Start)
                                .fillMaxWidth())
                        Text(text = meals,
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Black,
                            modifier = Modifier
                                .align(Alignment.Start)
                                .fillMaxWidth())

                    }
                }
            }
        }
    }




