package com.example.mediationjetpackcomposeapplication.login_example

import android.graphics.Paint
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle

import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.KeyboardType.Companion.Email
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.mediationjetpackcomposeapplication.R
import com.example.mediationjetpackcomposeapplication.login_example.ui.theme.purplish
import com.example.mediationjetpackcomposeapplication.ui.theme.BlueViolet3
import com.example.mediationjetpackcomposeapplication.ui.theme.orangish


@Preview(showBackground = true)
@Composable
fun LoginPage() {

//    val emailState = remember { mutableStateOf(TextFieldValue("mb.masoumi@gmail.com"))}

    var emailState by remember { mutableStateOf("Hello World") }
    var passState by remember { mutableStateOf("enter password") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = purplish)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(60.dp).copy(
                        topEnd = ZeroCornerSize,
                        topStart = ZeroCornerSize
                    )
                )
                .height(500.dp)
                .background(Color.White)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,

            ) {

                val maxLength = 110
                Image(painter = painterResource(id = R.drawable.ic_vaccum), contentDescription = "")
                Spacer(modifier = Modifier.height(4.dp))
                OutlinedTextField(

                    value = emailState,
                    onValueChange = { emailState = it }, singleLine = true,
                    label = {Text(text = "Email")},

                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = purplish,
                        unfocusedBorderColor = Color.Gray
                    ),
                )

                Spacer(modifier = Modifier.height(4.dp))
//                OutlinedTextField(
//                    value = passState,
//                    onValueChange = { passState = it },
//                    singleLine = true,
//                    label = { Text(text = "password") },
//                    colors = TextFieldDefaults.outlinedTextFieldColors(
//                        focusedBorderColor = purplish,
//                        unfocusedBorderColor = Color.Gray
//                    )
//                )
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    value = passState,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Blue,
                        cursorColor = Color.Black,
                        disabledLabelColor = BlueViolet3,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    onValueChange = {
                        if (it.length <= maxLength) passState = it
                    },
                    shape = RoundedCornerShape(16.dp),
                    singleLine = true,
                    label = {Text(text = "password")},
                    trailingIcon = {
                        if (passState.isNotEmpty()) {
                            IconButton(onClick = { passState = "" }) {
                                Icon(
                                    imageVector = Icons.Outlined.Close,
                                    contentDescription = null
                                )
                            }
                        }
                    }
                )

                Spacer(modifier = Modifier.padding(vertical = 12.dp))

                val modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                Text(text = "Forgot password?", textAlign = TextAlign.End , style = TextStyle(color = Gray), modifier = modifier)

                Spacer(modifier = Modifier.padding(vertical = 12.dp))

                Button(onClick = {} ,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(color = orangish)
                    .padding(5.dp))

                {
                    Text(text = "Log in")
                }



            }

        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent),
            contentAlignment = Alignment.BottomCenter
        ) {

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.ic_fb),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(50.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_google), contentDescription = "",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(50.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_twitter), contentDescription = "",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(50.dp)
                )
            }

        }
    }


//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .align(Alignment.BottomCenter)
//                .height(100.dp),
//        ) {
//
//        }

//    }
}


