package com.example.pvh_cenima.ui.features.auth.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.pvh_cenima.ui.theme.primary
import com.example.pvh_cenima.ui.theme.secondary

@Composable
fun sign_In_Screen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            Text(
                "Skip",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                color = primary,
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.bodyLarge
            )
        },
        bottomBar = {
            Text(
                "Don’t you have an account? Sign Up",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 35.dp),
                color = secondary,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Sign In",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                color = primary,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.SemiBold
            )
            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                placeholder = {
                    Text(
                        "E-mail"
                    )
                },
                shape = RoundedCornerShape(16.dp)
            )
            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                placeholder = {
                    Text(
                        "Password"
                    )
                },
                shape = RoundedCornerShape(16.dp),
//                leadingIcon = {
//                    Icon(
//                        painter =
//                    )
//                }
            )
        }
    }
}