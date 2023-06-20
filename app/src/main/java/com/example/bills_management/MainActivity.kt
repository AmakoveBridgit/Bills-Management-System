package com.example.bills_management

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bills_management.databinding.ActivityMainBinding

    class MainActivity : AppCompatActivity() {
        lateinit var binding: ActivityMainBinding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)

            setContentView(binding.root)
        }


        override fun onResume() {
            super.onResume()

            binding.btButton2.setOnClickListener {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
            validateForm()
            clearErrors()
        }

fun validateForm() {
    val name = binding.etFirstName.text.toString()
    val name2=binding.etLastName.text.toString()
    val email = binding.etEmail.text.toString()
    val password=binding.etPassword.text.toString()
    var error=false
    if (name.isBlank()) {
        binding.tilFirstName.error = "First Name required"
        error = true
    }
    if (name2.isBlank()) {
        binding.tilFirstName.error = "Second Name required"
        error = true
    }
    if (password.isBlank()) {
        binding.tilLastName.error = "Phone Number is required"
        error = true
    }
    if (email.isBlank()) {
        binding.tilEmail.error = "Email  is required"
        error = true

    }

    if (!error) {
        Toast.makeText(
            this, "$name $password $email",
            Toast.LENGTH_LONG
        ).show()

    }
}

fun clearErrors(){
    binding.tilFirstName.error=null
    binding.tilLastName.error=null
    binding.tilEmail.error=null
    binding.tilPassword.error=null
}
}
