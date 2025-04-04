package com.example.mymealplanner

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mymealplanner.ui.theme.MyMealPlannerTheme

class MainActivity : ComponentActivity() {
    class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            // Getting references from EditText, Buttons, and TextView
            val inputTimeOfDay = findViewById<EditText>(R.id.inputTimeOfDay)
            val submitButton = findViewById<Button>(R.id.submitButton)
            val resetButton = findViewById<Button>(R.id.resetButton)
            val resultText = findViewById<TextView>(R.id.resultText)

            // When the Submit Button is clicked
            submitButton.setOnClickListener {
                val timeOfDay = inputTimeOfDay.text.toString().trim()

                val foodSuggestion = when (timeOfDay) {
                    "Morning" -> "Scrambled Eggs with Toast, Greek Yogurt with Granola, Smoothie Bowl, Breakfast Burrito"
                    "Mid-Morning" -> "Almonds, Banana with Peanut Butter, Veggie Wrap, Green Juice"
                    "Afternoon" -> "Grilled Chicken Salad, Veggie Tacos, Quinoa Bowl, Veggie Stir-Fry"
                    "Afternoon Snack" -> "Hummus with Carrot Sticks, Trail Mix, Fruit Salad, Cheese and Crackers"
                    "Dinner" -> "Grilled Salmon with Asparagus, Vegan Burger, Risotto, Spaghetti Bolognese"
                    "After Dinner" -> "Fruit Sorbet, Chia Pudding, Dark Chocolate, Apple with Almond Butter"
                    else -> null
                }

                // Display the food suggestion or show a toast for invalid input
                if (foodSuggestion != null) {
                    resultText.text = "Suggested Food: $foodSuggestion"
                } else {
                    Toast.makeText(this, "Invalid input. Please enter a valid time of day", Toast.LENGTH_SHORT).show()
                    resultText.text = ""
                }
            }

            // When the Reset Button is clicked
            resetButton.setOnClickListener {
                inputTimeOfDay.text.clear()
                resultText.text = ""
            }
        }
        }}