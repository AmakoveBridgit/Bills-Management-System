package com.example.bills_management.api

import com.example.bills_management.model.LoginRequest
import com.example.bills_management.model.LoginResponse
import com.example.bills_management.model.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/users/register")
    suspend fun registerUser(@Body registerRequest: LoginRequest): Response<RegisterResponse>

    @POST("/users/login")
    suspend fun loginUser(@Body loginRequest: LoginRequest):Response<LoginResponse>
}