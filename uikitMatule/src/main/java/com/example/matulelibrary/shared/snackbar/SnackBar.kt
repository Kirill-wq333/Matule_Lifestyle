package com.example.matulelibrary.shared.snackbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.matulelibrary.R
import com.example.matulelibrary.typography.MatuleTypography

@Composable
fun SnackBar(
    message: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .height(120.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(8.dp)
            )
            .shadow(
                elevation = (-6).dp,
                shape = RoundedCornerShape(8.dp),
                ambientColor = Color.White.copy(0.5f)
            )
    ) {
        Text(
            text = message,
            color = Color.Black,
            style = MatuleTypography.titleExtraBold20,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 20.dp, top = 24.dp)
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_dismiss),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .offset(10.dp,(-10).dp)
        )
    }
}