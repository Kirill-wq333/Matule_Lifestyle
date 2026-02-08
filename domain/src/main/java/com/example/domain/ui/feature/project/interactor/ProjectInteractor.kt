package com.example.domain.ui.feature.project.interactor

import com.example.domain.ui.feature.project.model.Project
import com.example.domain.ui.feature.project.repository.ProjectRepository

class ProjectInteractor(
    private val projectRepository: ProjectRepository
) {
    suspend fun projects(): Result<List<Project>> {
        return projectRepository.projects()
    }
    suspend fun postProject(
        title: String,
        typeProject: String,
        userId: String,
        dateStart: String,
        dateEnd: String,
        gender: String,
        descriptionSource: String,
        category: String,
        image: String
    ): Result<Project>{
        return projectRepository.postProject(
            title,
            typeProject,
            userId,
            dateStart,
            dateEnd,
            gender,
            descriptionSource,
            category,
            image
        )
    }
}