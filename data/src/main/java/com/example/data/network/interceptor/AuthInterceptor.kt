package com.example.data.network.interceptor

import com.example.data.network.annotation.WithAuthorization
import com.example.data.storage.token.TokenProvider
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Invocation
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val tokenProvider: TokenProvider
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val isWithAuthorization = originalRequest.tag(Invocation::class.java)
            ?.method()
            ?.annotations
            ?.any { it is WithAuthorization } == true

        val isAuthEndpoint = originalRequest.url.toString().contains("/collections/")

        val newRequest = if (isWithAuthorization && !isAuthEndpoint) {
            val token = tokenProvider.getToken()
            if (token != null) {
                originalRequest.newBuilder()
                    .header("Authorization", "Bearer $token")
                    .build()
            } else {
                originalRequest
            }
        } else {
            originalRequest
        }

        return chain.proceed(newRequest)
    }
}