package com.smartherd.jewelleryshop.adapter

import android.content.Context
import android.text.TextUtils
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.storage
import com.smartherd.jewelleryshop.databinding.ItemsCategoriesListBinding
import com.smartherd.jewelleryshop.models.ItemCategoriesModel

class CategoriesItemListAdapter(val context: Context, val itemList: List<ItemCategoriesModel>) :
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
        val categoriesData = itemList[position]
        val layoutWidth = 80
        val layoutHeight = 80
        val layout : ViewGroup.LayoutParams = holder.binding.itemCategoriesImg.layoutParams

        val storageRef = Firebase.storage.reference.child("Categories/${categoriesData.image_name}")

        storageRef.downloadUrl.addOnSuccessListener {

            Glide.with(holder.itemView.context)
                .load(it)
                .into(holder.binding.itemCategoriesImg)

            layout.height = layoutHeight
            layout.width = layoutWidth

            holder.binding.itemCategoriesImg.layoutParams = layout

        }.addOnFailureListener {
            Toast.makeText(holder.itemView.context , it.toString() , Toast.LENGTH_SHORT).show()

        }

        holder.binding.itemCategoriesName.text = categoriesData.name


    }

    class ViewHolder(val binding : ItemsCategoriesListBinding) : RecyclerView.ViewHolder(binding.root)

}