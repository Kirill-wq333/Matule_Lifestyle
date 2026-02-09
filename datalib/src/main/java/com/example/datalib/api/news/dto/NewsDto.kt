package com.example.datalib.api.news.dto

/**
 *
 * Новости и акции
 *
 * @property collectionId Идентификатор коллекции/таблицы новостей и акций в базе данных
 * @property collectionName Название коллекции/таблицы новостей и акций
 * @property id Инидификатор новости и акции
 * @property newsImage Изображение новости и акции
 * @property created Дата и время последнего создания новости и акции
 * @property updated Дата и время последнего обновления новости и акции
 */
data class NewsDto(
    val collectionId: String,
    val collectionName: String,
    val id: String,
    val newsImage: String,
    val created: String,
    val updated: String
)