package com.example.matule20.ui.presentation.feature.projects.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.ui.feature.project.interactor.ProjectInteractor
import com.example.domain.ui.feature.project.model.Project
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProjectViewModel @Inject constructor(
    private  val projectInteractor: ProjectInteractor
): ViewModel() {

    private val _project: MutableStateFlow<List<Project>> = MutableStateFlow(listOf())
    val project = _project.asStateFlow()

    fun projects(){
        viewModelScope.launch {
            val result = projectInteractor.projects()
            result
                .onSuccess {
                    _project.emit(it)
                }
        }
    }

    fun createProject(
        title: String,
        typeProject: String,
        dateStart: String,
        dateEnd: String,
        gender: String,
        descriptionSource: String,
        category: String,
        image: String
    ){
        viewModelScope.launch {
            projectInteractor.postProject(
                title,
                typeProject,
                "",
                dateStart,
                dateEnd,
                gender,
                descriptionSource,
                category,
                image
            )
        }
    }
}