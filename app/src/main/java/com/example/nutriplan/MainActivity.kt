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
            // state variables to store user inputs and selections
            var timeofday by remember {
                mutableStateOf("")// stores time of day (e.g., breakfast, lunch)
            }
            var meals by remember {
                mutableStateOf("")
            }
            var mealtype by remember {
                mutableStateOf("heavy meal")// stores meal type (light/heavy), defaults to heavy
            }

            // column layout that contains all elements
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,// center aligns the elements horizontally
                modifier = Modifier
                    .fillMaxSize()// this takes up all the availabale space
                    .background(Color(0xFF2E3131))//sets the background color

            ) {
                // the app title
                Text(
                    text = " Nutri Plan ",
                    fontSize = 45.sp,// font size
                    fontWeight = FontWeight.Black,
                    fontFamily = FontFamily.Monospace
                )
                Divider()// adds a horizontal divider line

                Spacer(modifier = Modifier.size(30.dp)) // this adds vertical space

                OutlinedTextField(value = timeofday, onValueChange = { text -> //text field to enter time of day
                    timeofday = text//this updates the time of day when the text changes
                     },
                    placeholder = { Text(text = "Enter eg.breakfast/afternoon snack/dinner ",
                        color = Color.Black) }
                )
                Spacer(modifier = Modifier.height(20.dp))//adds vertical space
                    //title for meal type
                Text(
                    text = " Choose Meal Type ",
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Black
                )
                    //row containing the meal types eg. light/heavy
                Row {
                    Button(
                        onClick = { mealtype = "light"},//sets the button to light when clicked
                        colors = ButtonDefaults.buttonColors(
                            containerColor = when (mealtype) {
                                "light" -> Color(0xFF81C784)//turns green when selected
                                else -> Color.LightGray//turns gray when selected
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
                    Spacer(modifier = Modifier.width(12.dp))//space horizontal
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
                Spacer(modifier = Modifier.size(30.dp))//adds vertical space
                //row containing action of buttons
                    Row {
//this button genertaes the meals suggestions
                        Button(onClick = {
                            meals = when (timeofday.lowercase()) {//case insensitive
                                "breakfast" -> when (mealtype) {
                                    "light" -> "Oatmeal with fruits"
                                    else -> "Eggs & bacon"
                                }

                                "mid-morning" -> when (mealtype) {//when light or heavy is selected the display will only show certian suggestions
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

                                else -> "Invalid Time Of Day, Please try again"// default message for invalid input
                            }
                        }) {
                            Text(text = " Meal Suggestions "
                                )

                        }
                        Spacer(modifier = Modifier.width(220.dp))//space betweeen buttons
                        Button(//resets all inuput/clears all input
                            onClick = {
                                timeofday = ""
                                meals = ""
                                mealtype = "Light"
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFEF5350)//reset button is red
                            )
                        ) {
                            Text("Reset")
                        }


                    }
                //column to display the meal suggestions
                    Column {
                        Text(text = "Meal suggestion in $timeofday is : ",
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Black,
                            modifier = Modifier
                                .align(Alignment.Start)//this makes the text go to the left
                                .fillMaxWidth())
                        Text(text = meals,// the actual meal suggestion text
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




