package com.example.uzbekistan.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.uzbekistan.Data.User
import com.example.uzbekistan.databinding.AdminitemviewBinding

class AdminRv(var list: List<User>) : RecyclerView.Adapter<AdminRv.Vh>() {
    inner class Vh(val binding: AdminitemviewBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(AdminitemviewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
    holder.binding.apply {
        name.text = list[position].Ismi+" "+list[position].Familiyasi
        number.text=list[position].telraqami
    }
    }
}