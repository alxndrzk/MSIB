package com.example.suitmediatestalex.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.suitmediatestalex.databinding.ItemUserBinding
import com.example.suitmediatestalex.model.ResponseUser

class Adapter(private val onClick: (String) -> Unit
): PagingDataAdapter<ResponseUser, Adapter.MyViewHolder>(DIFF_CALLBACK)  {

    class MyViewHolder(private val onClick: (String) -> Unit,
                       private val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ResponseUser){
            binding.tvUserName.text = data.FirstName +" "+ data.LastName
            binding.tvEmail.text = data.email
            Glide.with(binding.root)
                .load(data.avatar)
                .centerCrop()
                .circleCrop()
                .into(binding.imgUser)

            itemView.setOnClickListener {
                onClick.invoke(data.FirstName +" "+ data.LastName)
            }
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = getItem(position)
        if(data != null) {
            holder.bind(data)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(onClick, binding)
    }

    companion object  {
        private val DIFF_CALLBACK = object: DiffUtil.ItemCallback<ResponseUser>() {
            override fun areItemsTheSame(oldItem: ResponseUser, newItem: ResponseUser): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ResponseUser, newItem: ResponseUser): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }


}