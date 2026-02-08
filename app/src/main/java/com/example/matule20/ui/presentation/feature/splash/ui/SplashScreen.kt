package com.example.matule20.ui.presentation.feature.splash.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.matule20.ui.presentation.approutes.AppRoutes
import com.example.matulelibrary.R
import kotlinx.coroutines.delay

@Preview
@Composable
private fun SplashScreenPrev() {
    SplashScreen(
        navController = rememberNavController()
    )
}

@Composable
fun SplashScreen(
    navController: NavHostController
) {

    val color = listOf(
        Brush.verticalGradient(
            listOf(
                Color(0xFF74C8E4),
                Color(0xFF73D5BC),
                Color(0xFF74C8E4)
            ),
        ),
        Brush.linearGradient(
            listOf(
                Color(0xFFA1CAFF),
                Color(0xFF4D9CFF),
                Color(0xFFA1CAFF)
            ),
        ),
        Brush.verticalGradient(
            listOf(
                Color(0xFF6269F0),
                Color(0xFF3740F5),
                Color(0xFF2254F5),
                Color(0xFF3740F5),
                Color(0xFF6269F0)
            ),
        ),
    )

    LaunchedEffect(Unit) {
        delay(1500)
        navController.navigate(AppRoutes.AUTH)
    }


    color.forEach {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = it,
                ),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .blur(128.dp)
                    .offset((-227).dp, (-227).dp)
                    .size(453.dp)
                    .background(
                        color = Color(0xFF83A0F8).copy(.6f),
                    )
                    .align(Alignment.TopStart)
            )
            Box(
                modifier = Modifier
                    .blur(128.dp)
                    .offset(227.dp, 227.dp)
                    .background(
                        color = Color(0xFF83A0F8).copy(.6f),
                    )
                    .size(453.dp)
                    .align(Alignment.BottomEnd)
            )
            Text(
                text = stringResource(R.string.name_app),
                color = Color.White,
                fontSize = 40.sp,
                lineHeight = 64.sp,
                letterSpacing = 1.04.sp,
                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                fontWeight = FontWeight.Normal
            )
        }
    }
}