package com.example.matulelibrary.typography

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.matulelibrary.R

class MTypography(
    // Title 1
    val titleSemibold24: TextStyle,
    val titleExtraBold24: TextStyle,

    // Title 2
    val titleRegular20: TextStyle,
    val titleSemibold20: TextStyle,
    val titleExtraBold20: TextStyle,

    // Title 3
    val titleRegular17: TextStyle,
    val titleMedium17: TextStyle,
    val titleSemiBold17: TextStyle,

    // Headline
    val headlineRegular16: TextStyle,
    val headlineMedium16: TextStyle,

    // Text
    val textRegular15: TextStyle,
    val textMedium15: TextStyle,

    // Caption
    val captionRegular14: TextStyle,
    val captionSemiBold14: TextStyle,

    // Caption 2
    val captionRegular12: TextStyle,
    val captionBold12: TextStyle,
)

val roboto = FontFamily(
    Font(R.font.roboto_bold, FontWeight.Bold),
    Font(R.font.roboto_regular, FontWeight.Normal),
    Font(R.font.roboto_medium, FontWeight.Medium),
    Font(R.font.roboto_semibold, FontWeight.SemiBold),
    Font(R.font.roboto_extrabold, FontWeight.ExtraBold)
)

val MatuleTypography: MTypography
    @Composable
    get() = MTypography(
        titleSemibold24 = TextStyle(
            fontSize = 24.sp,
            lineHeight = 28.sp,
            letterSpacing = 0.33.sp,
            fontFamily = roboto,
            fontWeight = FontWeight.SemiBold
        ),
        titleExtraBold24 = TextStyle(
            fontSize = 24.sp,
            lineHeight = 28.sp,
            letterSpacing = 0.33.sp,
            fontFamily = roboto,
            fontWeight = FontWeight.ExtraBold
        ),
        titleRegular20 = TextStyle(
            fontSize = 20.sp,
            lineHeight = 28.sp,
            letterSpacing = 0.38.sp,
            fontFamily = roboto,
            fontWeight = FontWeight.Normal
        ),
        titleSemibold20 = TextStyle(
            fontSize = 20.sp,
            lineHeight = 28.sp,
            letterSpacing = 0.38.sp,
            fontFamily = roboto,
            fontWeight = FontWeight.SemiBold
        ),
        titleExtraBold20 = TextStyle(
            fontSize = 20.sp,
            lineHeight = 28.sp,
            letterSpacing = 0.38.sp,
            fontFamily = roboto,
            fontWeight = FontWeight.ExtraBold
        ),
        titleRegular17 = TextStyle(
            fontSize = 17.sp,
            lineHeight = 24.sp,
            fontFamily = roboto,
            fontWeight = FontWeight.Normal
        ),
        titleMedium17 = TextStyle(
            fontSize = 17.sp,
            lineHeight = 24.sp,
            fontFamily = roboto,
            fontWeight = FontWeight.Medium
        ),
        titleSemiBold17 = TextStyle(
            fontSize = 17.sp,
            lineHeight = 24.sp,
            fontFamily = roboto,
            fontWeight = FontWeight.SemiBold
        ),
        headlineRegular16 = TextStyle(
            fontSize = 16.sp,
            lineHeight = 20.sp,
            letterSpacing = (-0.32).sp,
            fontFamily = roboto,
            fontWeight = FontWeight.Normal
        ),
        headlineMedium16 = TextStyle(
            fontSize = 16.sp,
            lineHeight = 20.sp,
            letterSpacing = (-0.32).sp,
            fontFamily = roboto,
            fontWeight = FontWeight.Medium
        ),
        textRegular15 = TextStyle(
            fontSize = 15.sp,
            lineHeight = 20.sp,
            fontFamily = roboto,
            fontWeight = FontWeight.Normal
        ),
        textMedium15 = TextStyle(
            fontSize = 15.sp,
            lineHeight = 20.sp,
            fontFamily = roboto,
            fontWeight = FontWeight.Medium
        ),
        captionRegular14 = TextStyle(
            fontSize = 14.sp,
            lineHeight = 20.sp,
            fontFamily = roboto,
            fontWeight = FontWeight.Normal
        ),
        captionSemiBold14 = TextStyle(
            fontSize = 14.sp,
            lineHeight = 20.sp,
            fontFamily = roboto,
            fontWeight = FontWeight.SemiBold
        ),
        captionRegular12 = TextStyle(
            fontSize = 12.sp,
            lineHeight = 16.sp,
            fontFamily = roboto,
            fontWeight = FontWeight.Normal
        ),
        captionBold12 = TextStyle(
            fontSize = 12.sp,
            lineHeight = 20.sp,
            fontFamily = roboto,
            fontWeight = FontWeight.Bold
        )
    )