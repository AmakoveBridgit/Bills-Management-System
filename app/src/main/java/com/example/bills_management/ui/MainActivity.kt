package com.example.bills_management.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.bills_management.databinding.ActivityMainBinding
import com.example.bills_management.model.RegisterRequest
import com.example.bills_management.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }


    override fun onResume() {
        super.onResume()

        binding.button2.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        userViewModel.errLiveData.observe(this, Observer { err ->
            Toast.makeText(this, err, Toast.LENGTH_LONG).show()
//            binding.pbRegister.visibility = View.GONE
        })
        userViewModel.regLiveData.observe(this, Observer { regResponse ->
            Toast.makeText(this, regResponse.message, Toast.LENGTH_LONG).show()
            startActivity(Intent(this, LoginActivity::class.java))
        })
        validateForm()
        clearErrors()
    }


    fun validateForm() {
        val firstname = binding.etFirstname.text.toString()
        val lastname = binding.etLastname.text.toString()
        val phoneNumber=binding.etPhone.text.toString()
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        val confirm=binding.etConfirm.text.toString()
        var error = false
        if (firstname.isBlank()) {
            binding.tilFirstname.error = "First Name required"
            error = true
        }
        if (lastname.isBlank()) {
            binding.tilLastname.error = "Second Name required"
            error = true
        }
        if (password.isBlank()) {
            binding.tilEmail.error = "Phone Number is required"
            error = true
        }
        if (email.isBlank()) {
            binding.tilPassword.error = "Email  is required"
            error = true

        }

        if (!error) {
            val registerRequest = RegisterRequest(
                firstName =firstname,
                lastname = lastname,
                phoneNumber=phoneNumber,
                email = email,
                password=password,
                confirm=confirm,



            )
            binding.progressBar3.visibility = View.GONE
            userViewModel.registerUser(registerRequest)



        }
    }

    fun clearErrors() {
        binding.tilFirstname.error = null
        binding.tilLastname.error = null
        binding.etPhone.error=null
        binding.tilEmail.error = null
        binding.tilPassword.error = null
        binding.tilConfirm.error=null

    }
}
