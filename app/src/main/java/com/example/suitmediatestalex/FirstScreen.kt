package com.example.suitmediatestalex

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.suitmediatestalex.databinding.ActivityFirstScreenBinding

class FirstScreen : AppCompatActivity() {

    private lateinit var binding: ActivityFirstScreenBinding
    private lateinit var sharedPreference: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        sharedPreference = getSharedPreferences("MyPreference", Context.MODE_PRIVATE)

        binding.btnCheck.setOnClickListener {
            checkPalindrome()
        }

        binding.btnNext.setOnClickListener {
            val intent = Intent(this, SecondScreen::class.java)
            val name = binding.inputNama.text.toString()
            saveUsername(name)
            startActivity(intent)
        }



    }

    fun checkPalindrome() {
        val palindrome = binding.inputPalindrome.text.toString()
        val isPalindrome = isPalindrome(palindrome)

        if (isPalindrome)
            Toast.makeText(this, "isPalindrome", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(this, "not Palindrome", Toast.LENGTH_SHORT).show()



    }

    fun isPalindrome(string: String): Boolean {
        val clearString = string.replace("\\s".toRegex(), "")
        val reserveString = clearString.reversed()
        return clearString.equals(reserveString, ignoreCase = true)

    }

    fun saveUsername(name: String) {
        val inputName = sharedPreference.edit()
        inputName.putString("name", name)
        inputName.apply()

    }



}
