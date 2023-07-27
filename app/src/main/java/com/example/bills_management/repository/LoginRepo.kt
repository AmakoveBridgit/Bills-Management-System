package com.example.bills_management.repository

import com.example.bills_management.api.ApiClient
import com.example.bills_management.api.ApiInterface
import com.example.bills_management.model.LoginRequest
import com.example.bills_management.model.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class LoginRepo {

    val apiClient = ApiClient.buildClient(ApiInterface::class.java)
    suspend fun loginUser(loginRequest: LoginRequest): Response<LoginResponse> {
        return withContext(Dispatchers.IO) {
            apiClient.loginUser(loginRequest)
        }
    }
}
