package com.example.datalib.api.order.datasource

import com.example.datalib.api.order.dto.request.RequestOrders
import com.example.datalib.api.order.dto.response.ResponseOrders
import retrofit2.http.Body
import retrofit2.http.POST

/**
 *
 * Сервис на создание заказа
 *
 */
interface OrderApiService {
    /**
     *
     * Запрос на создание заказа
     *
     * @param request Данные для того чтобы создать заказ
     * @return Ответ на получение данных заказа
     */
//    @WithAuthorization
    @POST("collections/orders/records")
    suspend fun postOrders(@Body request: RequestOrders): ResponseOrders

}