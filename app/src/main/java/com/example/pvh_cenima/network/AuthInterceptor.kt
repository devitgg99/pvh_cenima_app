package com.example.pvh_cenima.network

import com.example.pvh_cenima.common.constant.UserSession
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response


class AuthInterceptor : Interceptor {

    companion object {
        val SKIP_AUTH_PATHS = setOf(
            "auths/login",
            "auths/refresh-token",
            "auths/logout",
            "auths/verify-otp",
            "auths/reset-password",
            "auths/forgot-password",
            "auth/refresh",
        )
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        originalRequest.url.toString()
        val token = UserSession.getAccessToken()

        /**
         * some endpoint that no need token
         */
        if (shouldSkipAuth(originalRequest)) {
            return chain.proceed(originalRequest)
        }

        /**
         * add token to header
         */
        val request = if (token.isNotEmpty()) {
            val authRequest = originalRequest.newBuilder()
                .header("Authorization", "Bearer $token")
                .build()
            authRequest
        } else {
            originalRequest
        }

        val response = chain.proceed(request)
        return response
    }

    private fun shouldSkipAuth(request: Request): Boolean {
        val url = request.url.toString()
        return SKIP_AUTH_PATHS.any { path ->
            url.contains(path)
        }
    }
}