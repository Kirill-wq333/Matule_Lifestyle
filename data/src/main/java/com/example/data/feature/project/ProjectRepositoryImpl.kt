package com.example.data.feature.project

import com.example.data.feature.project.datasource.ProjectApiService
import com.example.data.feature.project.dto.ProjectDto.Companion.toProject
import com.example.data.feature.project.dto.request.RequestProject
import com.example.domain.ui.feature.project.model.Project
import com.example.domain.ui.feature.project.repository.ProjectRepository

class ProjectRepositoryImpl(
    private val apiService: ProjectApiService
) : ProjectRepository {
    override suspend fun postProject(
        title: String,
        typeProject: String,
        userId: String,
        dateStart: String,
        dateEnd: String,
        gender: String,
        descriptionSource: String,
        category: String,
        image: String
    ): Result<Project> = runCatching {
        val response = apiService.postProject(
            RequestProject(
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
        )
        Result.success(response.toProject())
    }.fold(
        onSuccess = { it },
        onFailure = { Result.failure(it) }
    )

    override suspend fun projects(): Result<List<Project>> = runCatching {
        val response = apiService.getProjects()
        Result.success(response.items.map { it.toProject() })
    }.fold(
        onFailure = { Result.failure(it) },
        onSuccess = { it }
    )
}