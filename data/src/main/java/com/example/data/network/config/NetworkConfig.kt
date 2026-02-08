package com.example.data.network.config

object NetworkConfig {

    const val MATULE_BASE_URL = "http://103.90.75.40:8787/"

    object Routes{

        const val RECORDS = "${MATULE_BASE_URL}/collections/users/records"
        const val AUTH = "${MATULE_BASE_URL}/collections/users/auth-with-password"
        const val PROMOTIONS_NEWS = "${MATULE_BASE_URL}/collections/news/records"
        const val PRODUCTS = "${MATULE_BASE_URL}/collections/products/records"
        const val PROJECT = "${MATULE_BASE_URL}/collections/project/records"
        const val CART = "${MATULE_BASE_URL}/collections/cart/records"
        const val ORDERS = "${MATULE_BASE_URL}/collections/orders/records"
        const val AUTH_ORIGINS = "${MATULE_BASE_URL}/collections/_authOrigins/records"
    }

}