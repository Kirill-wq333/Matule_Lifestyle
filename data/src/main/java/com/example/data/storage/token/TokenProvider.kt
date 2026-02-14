package com.example.data.storage.token

import com.example.data.storage.preference.AppPreference
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class TokenProvider @Inject constructor(
    private val appPreferences: AppPreference
) {
    fun getToken(): String? {
        val token = appPreferences.getUserToken()
        return token?.ifEmpty { null }
    }

    fun getUserId(): String?{
        val token = appPreferences.getUserId()
        return token?.ifEmpty { null }
    }
    fun saveUserId(userId: String){
        runBlocking {
            appPreferences.setUserId(userId)
            appPreferences.setUserLoggedIn(true)
        }
        getToken()
    }
    fun saveToken(token: String) {
        runBlocking {
            appPreferences.setUserToken(token)
            appPreferences.setUserLoggedIn(true)
        }

        getToken()
    }
}