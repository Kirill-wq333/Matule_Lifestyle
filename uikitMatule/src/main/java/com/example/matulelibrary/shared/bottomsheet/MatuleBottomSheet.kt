package com.example.matulelibrary.shared.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.matulelibrary.R
import com.example.matulelibrary.shared.button.iconbtn.SmallIconButton
import com.example.matulelibrary.spacers.MatuleSpacers
import com.example.matulelibrary.typography.MatuleTypography
import kotlinx.coroutines.launch

/**
 *
 * Функция которая отображает данные продукта
 *
 * @param content Функция, которая отображает контент
 * @param nameProduct Текст, который отображает название продукта
 */

@Composable
fun MatuleBottomSheet(
    content: @Composable () -> Unit,
    nameProduct: String
) {
    MatuleModalBottomSheet(
        onDismissRequest = {}
    ) { hide ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = MatuleSpacers.spacer20,
                    end = MatuleSpacers.spacer20,
                    bottom = MatuleSpacers.spacer40
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    text = nameProduct,
                    color = Color.Black,
                    style = MatuleTypography.titleExtraBold20
                )
                SmallIconButton(
                    shape = CircleShape,
                    size = 10.dp,
                    onClick = { hide() },
                    icon = R.drawable.ic_close,
                    padding = 7.dp,
                )
            }
            Spacer(modifier = Modifier.height(MatuleSpacers.spacer20))
            content()
        }
    }
}

/**
 *
 * Функция для отображения модального окна
 *
 * @param modifier Модификатор для настройки внешнего вида и поведения
 * @param onDismissRequest Лямбда-функция, где при нажатии на само "модальное окно" сворачивает его.
 * @param content Функция, которая отображает контент
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MatuleModalBottomSheet(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    content: @Composable ColumnScope.(hide: () -> Unit) -> Unit
) {

    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    ModalBottomSheet(
        modifier = modifier,
        sheetState = sheetState,
        containerColor = Color.White,
        onDismissRequest = onDismissRequest
    ) {

        val hide = {
            scope.launch {
                sheetState.hide()
                onDismissRequest()
            }; Unit
        }

        content.invoke(this, hide)
    }

}