package com.example.uzbekistan.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.GeneratedAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.uzbekistan.Data.city
import com.example.uzbekistan.Data.tuman
import com.example.uzbekistan.R
import com.example.uzbekistan.databinding.ItemViewBinding

class gallaeryAdapter(var list: List<tuman>,val listener:onClick) : RecyclerView.Adapter<gallaeryAdapter.Vh>() {

    inner class Vh(val itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image)
        val textView: TextView = itemView.findViewById(R.id.text)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                listener.onItemClick(position)
            }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false))
    }

    override fun getItemCount(): Int=list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.imageView.setImageResource(list[position].tumanRasm)
        holder.textView.text = list[position].TumanNomi
    }
        interface onClick{
            fun onItemClick(position: Int)
        }
    fun setFilterListener(list1:List<tuman>){
        this.list=list1
        notifyDataSetChanged()
    }


}