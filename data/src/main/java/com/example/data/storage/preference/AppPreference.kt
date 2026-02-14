package com.example.data.storage.preference

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class AppPreference @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {
    private companion object {
        val IS_LOGGED_IN = booleanPreferencesKey("is_logged_in")
        val USER_TOKEN = stringPreferencesKey("user_token")
        val USER_ID_KEY = stringPreferencesKey("user_id")
    }

    suspend fun setUserLoggedIn(loggedIn: Boolean) {
        dataStore.edit { preferences ->
            preferences[IS_LOGGED_IN] = loggedIn
        }
    }

    fun getUserToken(): String? {
        return runBlocking {
            dataStore.data.first()[USER_TOKEN]
        }
    }

    fun getUserId(): String?{
        return runBlocking {
            dataStore.data.first()[USER_ID_KEY]
        }
    }
    suspend fun setUserId(userId: String?){
        dataStore.edit { preferences ->
            if (userId != null){
                preferences[USER_ID_KEY] = userId
            } else {
                preferences.remove(USER_ID_KEY)
            }
        }
    }
    suspend fun setUserToken(token: String?) {
        dataStore.edit { preferences ->
            if (token != null) {
                preferences[USER_TOKEN] = token
            } else {
                preferences.remove(USER_TOKEN)
            }
        }
    }
}