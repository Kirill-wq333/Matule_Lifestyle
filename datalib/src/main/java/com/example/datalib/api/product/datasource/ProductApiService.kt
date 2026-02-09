package com.example.datalib.api.product.datasource

import com.example.datalib.api.product.dto.ProductDto
import com.example.datalib.api.product.dto.response.ResponseProduct
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *
 * Сервис на получение товаров и товара
 *
 */
interface ProductApiService {
    /**
     *
     * Запрос на получение списка товаров
     *
     * @return Ответ на получение списка товаров
     */
//    @WithAuthorization
    @GET("collections/products/records")
    suspend fun getProducts(): ResponseProduct

    /**
     *
     * Запрос получения товара по индификатору
     *
     * @param idProduct Индификатор товара
     * @return Ответ на получение товара
     */
//    @WithAuthorization
    @GET("collections/products/records/{id_product}")
    suspend fun getProduct(@Path("id_product") idProduct: Int): ProductDto

}