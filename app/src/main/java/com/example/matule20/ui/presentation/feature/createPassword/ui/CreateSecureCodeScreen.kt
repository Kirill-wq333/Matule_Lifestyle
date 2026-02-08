package com.example.matule20.ui.presentation.feature.createPassword.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.matule20.ui.presentation.approutes.AppRoutes
import com.example.matulelibrary.R
import com.example.matulelibrary.color.MatuleColors
import com.example.matulelibrary.typography.MatuleTypography
import kotlinx.coroutines.delay

@Preview
@Composable
private fun Prev() {
    CreateSecureCodeScreen(navController = rememberNavController())
}

@Composable
fun CreateSecureCodeScreen(
    navController: NavHostController
) {

    var code by rememberSaveable { mutableStateOf("") }
    LaunchedEffect(code.length) {
        if (code.length == 4){
            delay(1500)
            navController.navigate(AppRoutes.PROFILE)
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(
                top = 100.dp,
                start = 43.dp,
                end = 44.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.create_password),
                color = Color.Black,
                style = MatuleTypography.titleExtraBold24,
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(R.string.password_description),
                color = Color(0xFF939396),
                style = MatuleTypography.textRegular15,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(56.dp))
        SecureCodeDashes(
            codeLength = code.length
        )
        Spacer(modifier = Modifier.height(60.dp))
        DigitalKeyboard(
            onClickDigit = { newDigit ->
                if (code.length < 4) {
                    code += newDigit
                }
            },
            isEnabled = code.length != 4,
            onClickDelete = {
                code = code.dropLast(1)
            }
        )
    }
}

@Composable
fun DigitalKeyboard(
    onClickDigit: (Int) -> Unit,
    isEnabled: Boolean,
    onClickDelete: () -> Unit,
) {
    val digits = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        items(digits.subList(0, 9)) { digit ->
            DigitalKey(
                item = digit,
                isEnabled = isEnabled,
                onClick = { onClickDigit(digit) }
            )
        }

        item {
            Spacer(modifier = Modifier.size(80.dp))
        }

        item {
            DigitalKey(
                item = 0,
                isEnabled = isEnabled,
                onClick = { onClickDigit(0) }
            )
        }

        item {
            DeleteTextIcon(
                onClick = onClickDelete
            )
        }

    }
}

@Composable
fun DigitalKey(
    item: Int,
    isEnabled: Boolean,
    onClick: () -> Unit
) {

    var isPressedState by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    LaunchedEffect(isPressed) {
        isPressedState = true
        delay(150) // Меняем цвет на 300 мс
        isPressedState = false
    }

    Box(
        modifier = Modifier
            .size(80.dp)
            .background(
                color = if (isPressedState) MatuleColors.accent else MatuleColors.inputBg,
                shape = CircleShape
            )
            .clickable(
                interactionSource = interactionSource,
                enabled = isEnabled,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "$item",
            color = if (isPressedState) Color.White else Color.Black,
            style = MatuleTypography.titleSemibold24,
        )
    }
}

@Composable
fun SecureCodeDashes(
    codeLength: Int,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        repeat(4){ i ->
            val isEnabled = (i in 0 until codeLength)
            Dash(
                isEnabled = isEnabled
            )
        }
    }
}

@Composable
fun Dash(
    isEnabled: Boolean,
) {
    Box(
        modifier = Modifier
            .size(16.dp)
            .background(
                color = if (isEnabled) MatuleColors.accent else Color.Unspecified,
                shape = CircleShape
            )
            .border(
                width = 1.dp,
                color = if (isEnabled) Color.Unspecified else MatuleColors.accent,
                shape = CircleShape
            )
    )
}

@Composable
fun DeleteTextIcon(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(80.dp)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_delete_text),
            contentDescription = null,
            tint = Color.Unspecified,
        )
    }
}
