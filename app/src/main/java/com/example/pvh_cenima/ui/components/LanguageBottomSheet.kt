package com.example.pvh_cenima.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.pvh_cenima.ui.theme.bottomSheetColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanguageBottomSheet(onDismissRequest: () -> Unit) {
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val maxSheetHeight = screenHeight / 2
    var isSelected by remember { mutableStateOf(false) }
    ModalBottomSheet(
        onDismissRequest = {
            onDismissRequest()
        },
        sheetState = sheetState,
        sheetMaxWidth = 640.dp,
        dragHandle = {

        },
        containerColor = bottomSheetColor
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(16.dp)
                .heightIn(max = maxSheetHeight),
            verticalArrangement = Arrangement.SpaceBetween

        ) {
            Column {
                Text(
                    "Choose language",
                    style = MaterialTheme.typography.displaySmall
                )
                Spacer(Modifier.height(5.dp))
                Text(
                    "Which language do you want to use?",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(Modifier.height(15.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(
                            onClick = {
                                isSelected = !isSelected
                            },
                            indication = null,       // ← This removes the ripple
                            interactionSource = remember { MutableInteractionSource() }
                        ),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "English",
                        style = MaterialTheme.typography.titleMedium
                    )
                    RadioButton(
                        selected = isSelected,
                        onClick = {
                            isSelected = !isSelected
                        },
                    )
                }
                Spacer(
                    Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(
                            color = Color.Gray.copy(0.5f)
                        )
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(
                            onClick = {
                                isSelected = !isSelected
                            },
                            indication = null,       // ← This removes the ripple
                            interactionSource = remember { MutableInteractionSource() }
                        ),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Khmer",
                        style = MaterialTheme.typography.titleMedium
                    )
                    RadioButton(
                        selected = isSelected,
                        onClick = {
                            isSelected = !isSelected
                        },
                    )
                }
            }
            Button(
                onClick = {

                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    "Use English",
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.White
                )
            }
        }
    }
}