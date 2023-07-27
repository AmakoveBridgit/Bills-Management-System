package com.example.bills_management.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bills_management.model.LoginRequest
import com.example.bills_management.model.RegisterResponse
import com.example.bills_management.repository.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    val userRepo = UserRepository()
    val regLiveData = MutableLiveData<RegisterResponse>()
    var errorLiveData = MutableLiveData<Throwable>()

    fun loginUser(loginRequest: LoginRequest) {
        viewModelScope.launch {
            val response = userRepo.registerUser(loginRequest)
            if (response.isSuccessful) {
                regLiveData.postValue(response.body())
            } else {
                errorLiveData.postValue(response.errorBody()?.string()?.
                let { Throwable(it) })
            }
        }
    }
}
