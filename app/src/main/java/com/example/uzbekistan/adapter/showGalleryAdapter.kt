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
import com.example.uzbekistan.databinding.FragmentGalleryshowBinding
import com.example.uzbekistan.databinding.ItemViewBinding
import com.example.uzbekistan.fragmnets.galleryshow
import org.w3c.dom.Text

class showGalleryAdapter(var list: List<String>) :
    RecyclerView.Adapter<showGalleryAdapter.Vh>() {
    inner class Vh(val galleryshow: View) : RecyclerView.ViewHolder(galleryshow) {
        val textView: TextView = galleryshow.findViewById(R.id.gallerytext)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(LayoutInflater.from(parent.context).inflate(R.layout.galleryshow, parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.textView.text = list[position]
    }
}