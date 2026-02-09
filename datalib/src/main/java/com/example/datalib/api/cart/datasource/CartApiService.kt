package com.example.datalib.api.cart.datasource

import com.example.datalib.api.cart.dto.request.RequestCart
import com.example.datalib.api.cart.dto.response.ResponseCart
import retrofit2.http.Body
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
//    @WithAuthorization
    @POST("collections/cart/records")
    suspend fun postCart(@Body request: RequestCart): ResponseCart

    /**
     *
     * Обновление корзины по индификатору корзины пользователя
     *
     * @param idBucket Индификатор коризны пользователя
     * @param request Данные для того чтобы обновить корзину
     * @return Ответ с обновленными данными корзины
     */
//    @WithAuthorization
    @PATCH("collections/cart/records/{id_bucket}")
    suspend fun patchCart(@Path("id_bucket") idBucket: Int,@Body request: RequestCart): ResponseCart

}