package com.example.pvh_cenima.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pvh_cenima.R
import com.example.pvh_cenima.ui.theme.bottomSheetColor
import com.example.pvh_cenima.ui.theme.primary

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, bottom = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Card(
                shape = CircleShape,
                modifier = Modifier.size(40.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.profile),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier.height(40.dp),
                verticalArrangement = Arrangement.spacedBy(2.dp, Alignment.CenterVertically)
            ) {
                Text(
                    "Hey, Yean Devit", style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    "Welcome Back!", style = MaterialTheme.typography.labelSmall,
                    color = primary
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            IconButton(
                onClick = {

                },
                modifier = Modifier.size(40.dp),
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = bottomSheetColor
                )
            ) {
                Icon(
                    painter = painterResource(
                        R.drawable.search_icon
                    ),
                    contentDescription = null,
                    tint = primary,
                    modifier = Modifier.size(20.dp)
                )
            }
            IconButton(
                onClick = {

                },
                modifier = Modifier.size(40.dp),
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = bottomSheetColor
                )
            ) {
                Icon(
                    painter = painterResource(
                        R.drawable.notification_icon
                    ),
                    contentDescription = null,
                    tint = primary,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}