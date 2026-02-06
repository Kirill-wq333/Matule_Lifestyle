package com.example.matule20.ui.presentation.feature.projects.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.matulelibrary.R
import com.example.matulelibrary.color.MatuleColors
import com.example.matulelibrary.shared.button.MatuleButton
import com.example.matulelibrary.shared.header.MatuleHeader
import com.example.matulelibrary.shared.input.MatuleTextField
import com.example.matulelibrary.shared.selection.Selection
import com.example.matulelibrary.typography.MatuleTypography

@Preview
@Composable
private fun CreateProjectScreenPrev() {
    CreateProjectScreen()
}

@Composable
fun CreateProjectScreen() {
    Content()
}

@Composable
private fun Content() {
    var nameProject by remember { mutableStateOf("") }
    var dateEnd by remember { mutableStateOf("") }
    var dateStart by remember { mutableStateOf("") }
    var sourceDescription by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = Color.White)
            .padding(top = 28.dp, bottom = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MatuleHeader(
            modifier = Modifier
                .padding(horizontal = 20.dp),
            headerText = stringResource(R.string.btn_create_a_project),
        )
        Spacer(modifier = Modifier.height(13.dp))
        LabelAndSelection(
            modifier = Modifier.padding(start = 21.dp, end = 19.dp),
            label = stringResource(R.string.type)
        )
        Spacer(modifier = Modifier.height(16.dp))
        MatuleTextField(
            modifier = Modifier.padding(start = 21.dp, end = 19.dp),
            label =  true,
            labelText = stringResource(R.string.name_project),
            text = nameProject,
            onTextChange = { nameProject = it }
        )
        Spacer(modifier = Modifier.height(16.dp))
        MatuleTextField(
            modifier = Modifier.padding(start = 21.dp, end = 19.dp),
            label =  true,
            labelText = stringResource(R.string.start_date),
            text = dateStart,
            onTextChange = { dateStart = it }
        )
        Spacer(modifier = Modifier.height(22.dp))
        MatuleTextField(
            modifier = Modifier.padding(start = 21.dp, end = 19.dp),
            label =  true,
            labelText = stringResource(R.string.end_date),
            text = dateEnd,
            onTextChange = { dateEnd = it }
        )
        Spacer(modifier = Modifier.height(10.dp))
        LabelAndSelection(
            modifier = Modifier.padding(start = 21.dp, end = 19.dp),
            label = stringResource(R.string.whom)
        )
        Spacer(modifier = Modifier.height(16.dp))
        MatuleTextField(
            modifier = Modifier.padding(start = 23.dp, end = 17.dp),
            label =  true,
            labelText = stringResource(R.string.end_date),
            text = sourceDescription,
            onTextChange = { sourceDescription = it }
        )
        Spacer(modifier = Modifier.height(17.dp))
        LabelAndSelection(
            modifier = Modifier.padding(start = 21.dp, end = 19.dp),
            label = stringResource(R.string.category)
        )
        Spacer(modifier = Modifier.height(37.dp))
        PhotoProject()
        Spacer(modifier = Modifier.height(32.dp))
        MatuleButton(
            modifier = Modifier.padding(horizontal = 20.dp),
            textBtn = stringResource(R.string.btn_),
            activeBtn = true,
            onClick = {}
        )
    }
}

@Composable
fun LabelAndSelection(
    modifier: Modifier = Modifier,
    label: String
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = label,
            color = MatuleColors.description,
            style = MatuleTypography.captionRegular14
        )
        Selection(
            selectionName = "прваолпрвло",
        )
    }
}

@Composable
fun PhotoProject() {
    Box(
        modifier = Modifier
            .background(
                color = MatuleColors.inputBg,
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_added_photo),
            contentDescription = null,
            modifier = Modifier
                .padding(
                    top = 56.dp,
                    start = 62.dp,
                    end = 60.dp,
                    bottom = 56.dp
                )
        )
    }
}
