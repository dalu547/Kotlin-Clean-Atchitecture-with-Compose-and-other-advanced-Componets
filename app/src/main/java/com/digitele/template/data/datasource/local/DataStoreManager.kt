package com.digitele.template.data.datasource.local

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private const val DATASTORE_NAME = "app_prefs"

// Extension property for Context
val Context.dataStore by preferencesDataStore(name = DATASTORE_NAME)

class DataStoreManager(private val context: Context) {

    companion object {
        val USERNAME_KEY = stringPreferencesKey("username")
        val IS_LOGGED_IN_KEY = booleanPreferencesKey("is_logged_in")
    }

    // Save username
    suspend fun saveUsername(username: String) {
        context.dataStore.edit { prefs ->
            prefs[USERNAME_KEY] = username
        }
    }

    // Read username
    val username: Flow<String?> = context.dataStore.data
        .map { prefs -> prefs[USERNAME_KEY] }

    // Save login status
    suspend fun setLoginStatus(isLoggedIn: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[IS_LOGGED_IN_KEY] = isLoggedIn
        }
    }

    // Read login status
    val isLoggedIn: Flow<Boolean> = context.dataStore.data
        .map { prefs -> prefs[IS_LOGGED_IN_KEY] ?: false }

    // Clear all data
    suspend fun clearAll() {
        context.dataStore.edit { it.clear() }
    }
}

