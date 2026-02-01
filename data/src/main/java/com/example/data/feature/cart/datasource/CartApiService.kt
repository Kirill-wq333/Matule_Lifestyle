package com.example.data.feature.cart.datasource

import com.example.data.feature.cart.request.RequestCart
import com.example.data.feature.cart.response.ResponseCart
import com.example.data.network.annotation.WithAuthorization
import com.example.data.network.config.NetworkConfig
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

/**
 *
 * Сервис для работы с обновленнием корзины и добавление в корзину товара
 *
 */
interface CartApiService {

    /**
     *
     * Добавление товара в корзину
     *
     * @param request Данные для того чтобы добавить товар в корзину
     * @return Ответ с данными добваленного товара
     */
    @WithAuthorization
    @POST(NetworkConfig.Routes.CART)
    suspend fun postCart(request: RequestCart): ResponseCart

    /**
     *
     * Обновление корзины по индификатору корзины пользователя
     *
     * @param idBucket Индификатор коризны пользователя
     * @param request Данные для того чтобы обновить корзину
     * @return Ответ с обновленными данными корзины
     */
    @WithAuthorization
    @PATCH("${NetworkConfig.Routes.CART}/{id_bucket}")
    suspend fun patchCart(@Path("id_bucket") idBucket: Int, request: RequestCart): ResponseCart

}