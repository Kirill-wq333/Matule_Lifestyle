package com.example.matulelibrary.shared.bottombar

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.matulelibrary.R
import com.example.matulelibrary.color.MatuleColors
import com.example.matulelibrary.shared.divider.MatuleHorizontalDivider
import com.example.matulelibrary.spacers.MatuleSpacers
import com.example.matulelibrary.typography.MatuleTypography
/**
 * Нижняя панель навигации для переключения между основными экранами приложения.
 * Отображает иконки с подписями и подсвечивает активный экран.
 *
 * @param navController Контроллер навигации для перехода между экранами.
 */
@Composable
fun BottomBar(
    navController: NavHostController
) {

    val bottomBar = listOf(
        BottomBarDC(
            route = "",
            name = R.string.main,
            icon = R.drawable.ic_main
        ),
        BottomBarDC(
            route = "",
            name = R.string.catalog,
            icon = R.drawable.ic_catalog
        ),
        BottomBarDC(
            route = "",
            name = R.string.projects,
            icon = R.drawable.ic_project
        ),
        BottomBarDC(
            route = "",
            name = R.string.profile,
            icon = R.drawable.ic_profile
        )
    )

    val currentRoute = navController
        .currentBackStackEntryAsState()
        .value
        ?.destination
        ?.route

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
    ) {
        MatuleHorizontalDivider()
        Spacer(modifier = Modifier.height(MatuleSpacers.spacer8))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 7.dp, end = 7.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            bottomBar.forEach { item ->
                val isSelected = currentRoute == item.route

                val color by animateColorAsState(
                    targetValue = if (isSelected) MatuleColors.accent else Color(0xFFB8C1CC),
                    animationSpec = tween(500)
                )

                BottomBarItem(
                    icon = item.icon,
                    text = stringResource(item.name),
                    color = color,
                    onClick = { navController.navigate(item.route) }
                )
            }
        }
    }
}

@Composable
fun BottomBarItem(
    icon: Int,
    text: String,
    color: Color,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .clickable(
                onClick = onClick
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(icon),
            contentDescription = null,
            tint = color
        )
        Text(
            text = text,
            color = color,
            style = MatuleTypography.captionRegular12
        )
    }
}

private data class BottomBarDC(
    val route: String,
    val name: Int,
    val icon: Int
)