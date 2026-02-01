package com.example.data.feature.order.datasource

import com.example.data.feature.order.request.RequestOrders
import com.example.data.feature.order.response.ResponseOrders
import com.example.data.network.annotation.WithAuthorization
import com.example.data.network.config.NetworkConfig
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
    @WithAuthorization
    @POST(NetworkConfig.Routes.ORDERS)
    suspend fun postOrders(request: RequestOrders): ResponseOrders

}