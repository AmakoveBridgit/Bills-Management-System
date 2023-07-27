package com.example.bills_management.repository

import com.example.bills_management.api.ApiClient
import com.example.bills_management.api.ApiInterface
import com.example.bills_management.model.LoginRequest
import com.example.bills_management.model.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {

    val apiClient = ApiClient.buildClient(ApiInterface::class.java)

    suspend fun registerUser(registerRequest: LoginRequest): Response<RegisterResponse> {
        return withContext(Dispatchers.IO) {
            apiClient.registerUser(registerRequest)
        }
    }
}