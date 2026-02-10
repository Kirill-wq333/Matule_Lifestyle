package com.example.matule20.ui.presentation.approutes

import java.net.URLDecoder
import java.net.URLEncoder

object AppRoutes {
    const val SPLASH ="splash"
    const val AUTH = "auth"
    const val CREATE_NEW_PASSWORD = "create_new_password/{email}"
    const val CREATE_SECURE_CODE_PASSWORD = "create_secure_code_password"
    const val PROFILE = "profile"
    const val MAIN = "main"
    const val CATALOG = "catalog"
    const val CART = "cart"
    const val REGISTER = "register"
    const val PROJECTS = "projects"
    const val CREATE_PROJECT = "create_project"

    fun createPasswordRoute(email: String): String{
        return "create_new_password/${URLEncoder.encode(email, "UTF-8")}"
    }
    fun getEmailFromRoute(route: String?): String {
        return route?.substringAfter("create_new_password/")?.let {
            try {
                URLDecoder.decode(it, "UTF-8")
            } catch (e: Exception) {
                ""
            }
        } ?: ""
    }
}