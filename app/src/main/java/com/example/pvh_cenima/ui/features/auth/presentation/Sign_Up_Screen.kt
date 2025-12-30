package com.example.pvh_cenima.ui.features.auth.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pvh_cenima.R
import com.example.pvh_cenima.navigation.Screen
import com.example.pvh_cenima.ui.theme.bottomSheetColor
import com.example.pvh_cenima.ui.theme.primary
import com.example.pvh_cenima.ui.theme.secondary

@Composable
fun Sign_Un_Screen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var isVisible by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(
                        R.drawable.pvh_cenima_logo,
                    ),
                    modifier = Modifier.size(150.dp),
                    contentDescription = "Logo",
                )
            }

        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 35.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    "Already have account? ",
                    color = secondary.copy(0.8f),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    "Sign In",
                    color = primary,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.clickable(
                        onClick = {
                            navController.navigate(Screen.SignInScreen.route)
                        }
                    )
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).fillMaxHeight(0.9f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "Sign Up",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                color = primary,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
            ) {
                OutlinedTextField(
                    value = firstName,
                    onValueChange = {
                        firstName = it
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.47f),
                    placeholder = {
                        Text(
                            "First Name"
                        )
                    },
                    shape = RoundedCornerShape(16.dp)
                )
                Spacer(modifier = Modifier.width(15.dp))
                OutlinedTextField(
                    value = lastName,
                    onValueChange = {
                        lastName = it
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    placeholder = {
                        Text(
                            "Last Name"
                        )
                    },
                    shape = RoundedCornerShape(16.dp)
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
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
            Spacer(modifier = Modifier.height(15.dp))
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
                visualTransformation = if(isVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(
                        onClick = {
                            isVisible = !isVisible
                        }
                    ) {
                        Icon(
                            painter = painterResource(if(isVisible) R.drawable.eyesicon else R.drawable.eyesclose),
                            contentDescription = null
                        )
                    }
                }
            )
            Spacer(modifier = Modifier.height(25.dp))
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth().padding(horizontal = 16.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    "Sign Up",
                    color = secondary,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleSmall,
                )
            }
            Spacer(modifier = Modifier.height(25.dp))

            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Spacer(modifier = Modifier.fillMaxWidth(0.45f).height(1.dp).background(secondary))
                Text(
                    "or",
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
                Spacer(modifier = Modifier.fillMaxWidth().height(1.dp).background(secondary))
            }
            Spacer(modifier = Modifier.height(25.dp))

            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(0.3f).height(45.dp),
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = bottomSheetColor
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.facebook),
                        contentDescription = null
                    )
                }
                IconButton(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(0.45f).height(45.dp),
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = bottomSheetColor
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.google)
                        ,contentDescription = null
                    )
                }
                IconButton(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(0.8f).height(45.dp),
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = bottomSheetColor
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.instagram),
                        contentDescription = null
                    )
                }
            }
        }
    }
}