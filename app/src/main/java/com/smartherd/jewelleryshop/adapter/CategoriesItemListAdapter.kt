package com.smartherd.jewelleryshop.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smartherd.jewelleryshop.databinding.ItemsCategoriesListBinding
import com.smartherd.jewelleryshop.models.ItemCategoriesModel

class CategoriesItemListAdapter(val context: Context, val itemList: ArrayList<ItemCategoriesModel>) :
    RecyclerView.Adapter<CategoriesItemListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val categoryBinding =
            ItemsCategoriesListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(categoryBinding)

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.itemCategoriesImg.setImageResource(itemList[position].image)
        holder.binding.itemCategoriesName.text = itemList[position].itemName

    }

    class ViewHolder(val binding : ItemsCategoriesListBinding) : RecyclerView.ViewHolder(binding.root)

}