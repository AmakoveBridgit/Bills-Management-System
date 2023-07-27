package com.example.bills_management.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bills_management.model.LoginRequest
import com.example.bills_management.model.RegisterRequest
import com.example.bills_management.model.RegisterResponse
import com.example.bills_management.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

  private  val userRepo = UserRepository()
    val regLiveData = MutableLiveData<RegisterResponse>()
    var errLiveData = MutableLiveData<String>()

    fun registerUser(registerRequest: RegisterRequest) {

        viewModelScope.launch {

//            val response = userRepo.registerUser(registerRequest)
//            if (response.isSuccessful) {
//                regLiveData.postValue(response.body())
//            } else {
//                errLiveData.postValue(response.errorBody()?.string())

            }
        }
    }
//}