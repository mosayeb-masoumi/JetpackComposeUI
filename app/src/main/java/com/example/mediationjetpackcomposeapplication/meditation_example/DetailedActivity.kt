package com.example.mediationjetpackcomposeapplication.meditation_example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mediationjetpackcomposeapplication.ui.theme.DeepBlue

class DetailedActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val title = intent.getStringExtra("TITLE")

           Box(
               modifier = Modifier
                   .fillMaxSize()
                   .background(DeepBlue),
               contentAlignment = Alignment.Center
           ){

               Text(text = title!!, style = TextStyle(color = Color.White , fontSize = 20.sp , fontWeight = FontWeight.Bold))
           }
        }
    }
}

