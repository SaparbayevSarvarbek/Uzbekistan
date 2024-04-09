package com.example.uzbekistan.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ListAdapter
import com.example.uzbekistan.Data.city
import com.example.uzbekistan.databinding.ChildViewBinding
import com.example.uzbekistan.databinding.GroupViewBinding

class extebleAdapter(private val context: Context,private var map: Map<String, List<String>>, private var list: List<String>) :
    BaseExpandableListAdapter() {

    override fun getGroupCount(): Int {
        return list.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return map[list[groupPosition]]!!.size
    }

    override fun getGroup(groupPosition: Int): String {
        return list[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): String {
        return map[list[groupPosition]]!![childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup
    ): View {
        val binding: GroupViewBinding
        if (convertView == null) {
            binding =
                GroupViewBinding.inflate(LayoutInflater.from(parent.context), convertView, false)
        } else {
            binding = GroupViewBinding.bind(convertView)
        }
        val str = list[groupPosition]
        binding.groupTv.text = str
        return binding.root
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup
    ): View {
        val binding: ChildViewBinding
        if (convertView == null) {
            binding =
                ChildViewBinding.inflate(LayoutInflater.from(parent.context), convertView, false)
        } else {
            binding = ChildViewBinding.bind(convertView)
        }
        val str = map[list[groupPosition]]!![childPosition]
        binding.childTv.text = str
        return binding.root
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return false
    }
    fun setFilterListener(list1:List<String>,map1:Map<String,List<String>>){
        this.list=list1
        this.map=map1
        notifyDataSetChanged()
    }

}