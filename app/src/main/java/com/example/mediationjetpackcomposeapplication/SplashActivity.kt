package com.example.mediationjetpackcomposeapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.mediationjetpackcomposeapplication.collaps_toolbar.CollapsToolbarActivity
import com.example.mediationjetpackcomposeapplication.grocery_shop.GroceryShopActivity
import com.example.mediationjetpackcomposeapplication.login_example.LoginActivity
import com.example.mediationjetpackcomposeapplication.meditation_example.MainActivity
import com.example.mediationjetpackcomposeapplication.recepi_example.RecipeActivity
import com.example.mediationjetpackcomposeapplication.ui.theme.DeepBlue


class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val context = LocalContext.current
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(DeepBlue),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            )
            {

                Button(onClick = {
                    context.startActivity(Intent(this@SplashActivity , MainActivity::class.java))
                }) {
                    Text(text = "meditaion activity" , color = Color.White)
                }
                
                Spacer(modifier = Modifier.height(5.dp))
                
                Button(onClick = {
                    context.startActivity(Intent(this@SplashActivity , RecipeActivity::class.java))
                }) {
                    Text(text = "recipe activity" , color = Color.White)
                }

                Spacer(modifier = Modifier.height(5.dp))

                Button(onClick = {
                    context.startActivity(Intent(this@SplashActivity , CollapsToolbarActivity::class.java))
                }) {
                    Text(text = "collapse toolbar activity" , color = Color.White)
                }

                Spacer(modifier = Modifier.height(5.dp))

                Button(onClick = {
                    context.startActivity(Intent(this@SplashActivity , LoginActivity::class.java))
                }) {
                    Text(text = "Login activity" , color = Color.White)
                }

                Spacer(modifier = Modifier.height(5.dp))

                Button(onClick = {
                    context.startActivity(Intent(this@SplashActivity , GroceryShopActivity::class.java))
                }) {
                    Text(text = "Grocery activity" , color = Color.White)
                }

            }
        }
    }
}

