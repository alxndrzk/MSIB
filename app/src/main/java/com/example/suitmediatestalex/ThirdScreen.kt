package com.example.suitmediatestalex

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.suitmediatestalex.adapter.Adapter
import com.example.suitmediatestalex.databinding.ActivityThirdScreenBinding
import com.example.suitmediatestalex.model.ThirdActivityViewModel

class ThirdScreen : AppCompatActivity() {

    private lateinit var binding: ActivityThirdScreenBinding
    private val thirdActivityViewModel: ThirdActivityViewModel by viewModels {
        ViewModelFactory (this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvUser.layoutManager = LinearLayoutManager(this)

        binding.swiperefresh.setOnRefreshListener{
            getUsers()
        }

        binding.btnBack.setOnClickListener{
            val intent = Intent(this, SecondScreen::class.java)
            startActivity(intent)
        }

        getUsers()


    }

    private fun getUsers() {
        val adapter = Adapter { selected ->
            val intent = Intent(this, SecondScreen::class.java)
            intent.putExtra("selected", selected)
            setResult(Activity.RESULT_OK, intent)
            startActivity(intent)
            finish()
        }

        binding.rvUser.adapter = adapter

        thirdActivityViewModel.dataUser.observe(this){
            adapter.submitData(lifecycle, it)
            binding.swiperefresh.isRefreshing = false
        }


    }


}