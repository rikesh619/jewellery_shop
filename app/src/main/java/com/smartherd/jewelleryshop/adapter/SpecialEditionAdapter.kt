package com.smartherd.jewelleryshop.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smartherd.jewelleryshop.databinding.ItemsCategoriesListBinding
import com.smartherd.jewelleryshop.databinding.SpecialEditionListBinding
import com.smartherd.jewelleryshop.models.ItemCategoriesModel
import com.smartherd.jewelleryshop.models.SpecialEditionModel

class SpecialEditionAdapter (val context: Context, val itemList: ArrayList<SpecialEditionModel>) :
    RecyclerView.Adapter<SpecialEditionAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val specialEditionBinding =
            SpecialEditionListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(specialEditionBinding)

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.specialEditionImg.setImageResource(itemList[position].itemImage)
        holder.binding.specialEditionItemName.text = itemList[position].itemName
        holder.binding.specialEditionItemPrice.text = itemList[position].itemPrice

    }

    class ViewHolder(val binding : SpecialEditionListBinding) : RecyclerView.ViewHolder(binding.root)

}