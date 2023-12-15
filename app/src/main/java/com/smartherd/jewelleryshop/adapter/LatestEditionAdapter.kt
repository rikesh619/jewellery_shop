package com.smartherd.jewelleryshop.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smartherd.jewelleryshop.databinding.ItemsCategoriesListBinding
import com.smartherd.jewelleryshop.databinding.LatestCollectionListBinding
import com.smartherd.jewelleryshop.models.ItemCategoriesModel
import com.smartherd.jewelleryshop.models.LatestEditionModel

class LatestEditionAdapter(val context: Context, val itemList: ArrayList<LatestEditionModel>) :
    RecyclerView.Adapter<LatestEditionAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val latestCollectionBinding =
            LatestCollectionListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(latestCollectionBinding)

    }


    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.latestJewelleryIc.setImageResource(itemList[position].img)
        holder.binding.latestJewelleryItemName.text = itemList[position].itemName
        holder.binding.latestJewelleryItemPrice.text = itemList[position].itemPrice

    }

    class ViewHolder(val binding: LatestCollectionListBinding) :
        RecyclerView.ViewHolder(binding.root)

}
