package com.example.domain.ui.feature.project.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Project(
    val id: String,
    val collectionId: String,
    val collectionName: String,
    val created: String,
    val updated: String,
    val title: String,
    val dateStart: String,
    val dateEnd: String,
    val gender: String,
    @SerializedName("description_source")val descriptionSource: String,
    val category: String,
    val image: String,
    @SerializedName("user_id")val userId: String
)
