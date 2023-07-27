package com.example.bills_management.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bills_management.databinding.ActivityLoginBinding
import com.example.bills_management.home

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()

        binding.btnLog.setOnClickListener {
            val intent = Intent(this, home::class.java)
            startActivity(intent)

//            binding.btnLog.setOnClickListener {
//                Intent(this,home::class.java)
//                startActivity(intent)
//            }
        }
        validateForm()
        clearErrors()
    }


    private fun validateForm() {
        val username = binding.etName.text.toString()
        val phoneNumber = binding.etName.text.toString()
        val email = binding.etEmail.text.toString()
        val password=binding.etPass.text.toString()

        var error = false
        if (username.isBlank()) {
            binding.tilName.error = " Name required"
            error = true
        }
        if (phoneNumber.isBlank()) {
            binding.tilName.error = "Phone Number is required"
            error = true
        }
        if (email.isBlank()) {
            binding.tilEmail.error = "Email  is required"
            error = true
        }
        if (password.isBlank()) {
            binding.tilPass.error = "Email  is required"
            error = true
        }

//
//        if (confirmpassword.isBlank()) {
//            binding.tilConfirm.error = "Email  is required"
//            error = true
//        }

        if (!error) {
            Toast.makeText(
                this, "$username $phoneNumber $email",
                Toast.LENGTH_LONG
            ).show()

        }
    }

    fun clearErrors() {
        binding.tilName.error = null
        binding.tilEmail.error = null
        binding.tilPass.error=null
    }
}

