package com.example.matule20.ui.presentation.feature.projects.ui

import android.content.Context
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.core.content.FileProvider
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.matule20.ui.presentation.approutes.AppRoutes
import com.example.matule20.ui.presentation.feature.projects.viewmodel.ProjectViewModel
import com.example.matulelibrary.R
import com.example.matulelibrary.color.MatuleColors
import com.example.matulelibrary.shared.bottomsheet.MatuleBottomSheet
import com.example.matulelibrary.shared.button.MatuleButton
import com.example.matulelibrary.shared.header.MatuleHeader
import com.example.matulelibrary.shared.input.MatuleTextField
import com.example.matulelibrary.shared.selection.Selection
import com.example.matulelibrary.typography.MatuleTypography
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun CreateProjectScreen(
    vm: ProjectViewModel,
    navController: NavHostController
) {
    Content(
        vm = vm,
        navController = navController
    )
}

@Composable
private fun Content(
    vm: ProjectViewModel,
    navController: NavHostController
) {
    var showBottomSheet by remember { mutableStateOf(false) }
    var nameProject by remember { mutableStateOf("") }
    var type by remember { mutableStateOf("") }
    var dateEnd by remember { mutableStateOf("") }
    var dateStart by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var sourceDescription by remember { mutableStateOf("") }
    var profileImage by remember { mutableStateOf<String?>(null) }

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
            label = stringResource(R.string.type),
            selection = type
        )
        Spacer(modifier = Modifier.height(16.dp))
        MatuleTextField(
            modifier = Modifier.padding(start = 21.dp, end = 19.dp),
            label = true,
            labelText = stringResource(R.string.name_project),
            text = nameProject,
            onTextChange = { nameProject = it }
        )
        Spacer(modifier = Modifier.height(16.dp))
        MatuleTextField(
            modifier = Modifier.padding(start = 21.dp, end = 19.dp),
            label = true,
            labelText = stringResource(R.string.start_date),
            text = dateStart,
            onTextChange = { dateStart = it }
        )
        Spacer(modifier = Modifier.height(22.dp))
        MatuleTextField(
            modifier = Modifier.padding(start = 21.dp, end = 19.dp),
            label = true,
            labelText = stringResource(R.string.end_date),
            text = dateEnd,
            onTextChange = { dateEnd = it }
        )
        Spacer(modifier = Modifier.height(10.dp))
        LabelAndSelection(
            modifier = Modifier.padding(start = 21.dp, end = 19.dp),
            label = stringResource(R.string.whom),
            selection = gender
        )
        Spacer(modifier = Modifier.height(16.dp))
        MatuleTextField(
            modifier = Modifier.padding(start = 23.dp, end = 17.dp),
            label = true,
            labelText = stringResource(R.string.descriptions_source),
            text = sourceDescription,
            onTextChange = { sourceDescription = it }
        )
        Spacer(modifier = Modifier.height(17.dp))
        LabelAndSelection(
            modifier = Modifier.padding(start = 21.dp, end = 19.dp),
            label = stringResource(R.string.category),
            selection = category
        )
        Spacer(modifier = Modifier.height(37.dp))

        PhotoProject(
            image = profileImage,
            onClick = { showBottomSheet = true }
        )
        Spacer(modifier = Modifier.height(32.dp))
        MatuleButton(
            modifier = Modifier.padding(horizontal = 20.dp),
            textBtn = stringResource(R.string.btn_),
            activeBtn = true,
            onClick = {
                if (dateStart.isNotEmpty() &&
                    dateEnd.isNotEmpty() &&
                    sourceDescription.isNotEmpty() &&
                    nameProject.isNotEmpty()
                )
                    vm.createProject(
                        title = nameProject,
                        typeProject = type,
                        dateStart = dateStart,
                        dateEnd = dateEnd,
                        gender = gender,
                        descriptionSource = sourceDescription,
                        category = category,
                        image = profileImage.toString()
                    )
                    navController.navigate(AppRoutes.PROJECTS)
            }
        )

        ModalBottomSheetCreateProject(
            showBottomSheet = showBottomSheet,
            onDismiss = { showBottomSheet = false },
            onPhotoSelected = { imageUri ->
                profileImage = imageUri
            }
        )
    }
}

@Composable
fun ModalBottomSheetCreateProject(
    showBottomSheet: Boolean,
    onDismiss: () -> Unit,
    onPhotoSelected: (String) -> Unit
) {
    val context = LocalContext.current

    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        uri?.let {
            onPhotoSelected(it.toString())
        }
        onDismiss()
    }

    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture()
    ) { success ->
        if (success) {
            val savedUri = getTempUri(context)
            savedUri?.let {
                onPhotoSelected(it.toString())
            }
        }
        onDismiss()
    }
    fun createTempImageUri(): Uri {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val fileName = "JPEG_${timeStamp}.jpg"
        val file = File(context.cacheDir, fileName)
        return FileProvider.getUriForFile(
            context,
            "${context.packageName}.fileprovider",
            file
        )
    }
    var tempUri by remember { mutableStateOf<Uri?>(null) }
    if (showBottomSheet) {
        MatuleBottomSheet(
            nameProduct = "Добавить фото",
            content = {
                Spacer(modifier = Modifier.height(40.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Выбрать из галереи",
                        color = Color.Black,
                        style = MatuleTypography.titleSemiBold17,
                        modifier = Modifier
                            .clickable(
                                onClick = {
                                    galleryLauncher.launch("image/*")
                                }
                            )
                    )
                    Text(
                        text = "Сделать фото",
                        color = Color.Black,
                        style = MatuleTypography.titleSemiBold17,
                        modifier = Modifier
                            .clickable(
                                onClick = {
                                    tempUri = createTempImageUri()
                                    tempUri?.let { uri ->
                                        cameraLauncher.launch(uri)
                                    }
                                }
                            )
                    )
                }
            }
        )
    }

}

fun getTempUri(context: Context): Uri? {
    val cacheDir = context.cacheDir
    val files = cacheDir.listFiles { file -> file.name.startsWith("JPEG_") }
    val latestFile = files?.maxByOrNull { it.lastModified() }
    return latestFile?.let {
        FileProvider.getUriForFile(
            context,
            "${context.packageName}.fileprovider",
            it
        )
    }
}

@Composable
fun LabelAndSelection(
    modifier: Modifier = Modifier,
    label: String,
    selection: String
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
            selectionName = selection,
        )
    }
}

@Composable
fun PhotoProject(
    image: String?,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clickable(onClick = onClick)
            .background(
                color = MatuleColors.inputBg,
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        if (image != null){
            AsyncImage(
                model = image,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(0.6f)
            )
        } else {
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
}
