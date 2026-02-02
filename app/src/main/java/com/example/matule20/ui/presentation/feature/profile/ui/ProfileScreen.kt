package com.example.matule20.ui.presentation.feature.profile.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.matulelibrary.R
import com.example.matulelibrary.color.MatuleColors
import com.example.matulelibrary.shared.toggle.Toggle
import com.example.matulelibrary.typography.MatuleTypography

@Preview
@Composable
private fun ProfilePrev() {
    ProfileScreen()
}

@Composable
fun ProfileScreen() {
    Content()
}

@Composable
fun Content() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(
                top = 32.dp,
                start = 20.dp,
                end = 20.dp
            )
    ) {
        FirstNameAndMail(
            firstName = "dsadhdfhfd",
            mail = "kiril@gsdjkghn"
        )
        Spacer(modifier = Modifier.height(24.dp))
        ProfileContent()
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                Text(
                    text = stringResource(R.string.privacy_police),
                    color = Color(0xFF939396),
                    style = MatuleTypography.textMedium15,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = stringResource(R.string.user_agreement),
                    color = Color(0xFF939396),
                    style = MatuleTypography.textMedium15,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = stringResource(R.string.btn_exit),
                    color = MatuleColors.error,
                    style = MatuleTypography.textMedium15,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .clickable(onClick = {})
                )
            }
        }
    }
}

@Composable
fun FirstNameAndMail(
    firstName: String,
    mail: String
) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = firstName,
            color = Color.Black,
            style = MatuleTypography.titleExtraBold24
        )
        Text(
            text = mail,
            color = Color(0xFF939396),
            style = MatuleTypography.headlineRegular16
        )
    }
}

@Composable
fun ProfileContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Item(
            icon = R.drawable.ic_orders,
            text = R.string.my_order
        )
        Item(
            icon = R.drawable.ic_notification,
            text = R.string.notification,
            visibleToggle = true
        )
    }
}

@Composable
private fun Item(
    icon: Int,
    text: Int,
    visibleToggle: Boolean = false
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 16.dp,
                bottom = 16.dp,
                end = if (visibleToggle) 15.dp else 0.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp)
            )
            Text(
                text = stringResource(text),
                color = Color.Black,
                style = MatuleTypography.titleSemiBold17
            )
        }
        if (visibleToggle) {
            Toggle(
                onSelectionChange = {}
            )
        }
    }
}