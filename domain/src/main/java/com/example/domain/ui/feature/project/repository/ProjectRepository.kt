package com.example.domain.ui.feature.project.repository

import com.example.domain.ui.feature.project.model.Project

interface ProjectRepository {
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
    ): Result<Project>

    suspend fun projects(): Result<List<Project>>
}