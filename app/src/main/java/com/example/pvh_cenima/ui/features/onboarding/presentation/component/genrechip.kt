package com.example.pvh_cenima.ui.features.onboarding.presentation.component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pvh_cenima.ui.theme.primary
import com.example.pvh_cenima.ui.theme.secondary
import com.example.pvh_cenima.ui.utility.rememberHapticFeedback

@Composable
fun genreChip(
    name: String,
    onSelect: () -> Unit,
    isSelect: Boolean
){
    val hapticFeedback = rememberHapticFeedback()
    TextButton(
        onClick = {onSelect()
            hapticFeedback.click()
                  },
        colors = ButtonDefaults.buttonColors(
            containerColor = if(isSelect) primary else secondary.copy(0.5f)
        ),
        shape = RoundedCornerShape(
            10.dp
        ),
        modifier = Modifier.height(38.dp)
    ) {
        Text(name,
            style = MaterialTheme.typography.bodyMedium,
            color = secondary
        )

    }
}