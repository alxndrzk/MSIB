package com.example.suitmediatestalex

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.suitmediatestalex.databinding.ActivitySecondScreenBinding

class SecondScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySecondScreenBinding
    private lateinit var sharedPreference: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        sharedPreference = getSharedPreferences("MyPreference", Context.MODE_PRIVATE)

        val name = sharedPreference.getString("name", "Guest")
        binding.tvName.text ="$name"

        selectedUser()

        binding.btnBack.setOnClickListener{
            val intent = Intent(this, FirstScreen::class.java)
            startActivity(intent)
        }

        binding.btnChoose.setOnClickListener{
            val intent = Intent(this, ThirdScreen::class.java)
            startActivity(intent)
        }


    }

    fun selectedUser(){
        var selectedUser = intent.getStringExtra("selected")
        if (selectedUser==null){
            binding.tvSelectedUsername.text = "selected User Name"
        }
        else
            binding.tvSelectedUsername.text = "$selectedUser"

    }

}