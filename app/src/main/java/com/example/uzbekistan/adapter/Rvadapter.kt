package com.example.uzbekistan.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uzbekistan.Data.city
import com.example.uzbekistan.R
import com.example.uzbekistan.databinding.ItemViewBinding
import org.w3c.dom.Text

class Rvadapter(var list: List<city>, val listener: MyClickListener) :
    RecyclerView.Adapter<Rvadapter.Vh>() {
    inner class Vh(val itemview: View) : RecyclerView.ViewHolder(itemview) {
        val imageView: ImageView = itemview.findViewById(R.id.image)
        val textView: TextView = itemview.findViewById(R.id.text)

        init {
            itemview.setOnClickListener {
                val position = adapterPosition
                listener.onItemClick(position)
            }
        }
    }
    fun setFilterListener(list1:List<city>){
        this.list=list1
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.imageView.setImageResource(list[position].Rasm)
        holder.textView.setText(list[position].Nomi)
    }

    interface MyClickListener {
            fun onItemClick(position: Int);
        }
    }