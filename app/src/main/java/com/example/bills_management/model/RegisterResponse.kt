package com.example.bills_management.model

import com.google.gson.annotations.SerializedName

data class RegisterResponse(

 var message:String,
 @SerializedName("user_id")    var user:User,
)
