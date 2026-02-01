package com.example.data.feature.news.response

/**
 *
 * Ответ добавленных "Новостей и акций"
 *
 * @property page Текущая страница
 * @property perPage Следущая страница
 * @property totalPages Количество страниц
 * @property totalItems Количество новостей и акций
 * @property items Список новостей и акций
 */
data class ResponseNews(
    val page: Int,
    val perPage: Int,
    val totalPages: Int,
    val totalItems: Int,
    val items: List<News>
)

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
data class News(
    val collectionId: String,
    val collectionName: String,
    val id: String,
    val newsImage: String,
    val created: String,
    val updated: String
)
