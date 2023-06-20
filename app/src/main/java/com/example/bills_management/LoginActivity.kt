package com.example.bills_management

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bills_management.databinding.ActivityLoginBinding
import com.example.bills_management.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()

        binding.btButton3.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        validateForm()
        clearErrors()
    }


    fun validateForm() {
        val username = binding.etName.text.toString()
        val phoneNumber = binding.etPhone.text.toString()
        val email = binding.etEmail.text.toString()
        val password=binding.etPassword.text.toString()
        val confirmpassword=binding.etConfirm.text.toString()

        var error = false
        if (username.isBlank()) {
            binding.tilName.error = " Name required"
            error = true
        }
        if (phoneNumber.isBlank()) {
            binding.tilPhone.error = "Phone Number is required"
            error = true
        }
        if (email.isBlank()) {
            binding.tilEmail.error = "Email  is required"
            error = true
        }
        if (password.isBlank()) {
            binding.tilPassword.error = "Email  is required"
            error = true
        }


        if (confirmpassword.isBlank()) {
            binding.tilConfirm.error = "Email  is required"
            error = true
        }

        if (!error) {
            Toast.makeText(
                this, "$username $phoneNumber $email",
                Toast.LENGTH_LONG
            ).show()

        }
    }

    fun clearErrors() {
        binding.tilName.error = null
        binding.tilPhone.error = null
        binding.tilEmail.error = null
        binding.tilPassword.error=null
        binding.tilConfirm.error=null
    }
}

