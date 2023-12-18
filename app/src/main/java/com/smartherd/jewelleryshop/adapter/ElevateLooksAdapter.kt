package com.smartherd.jewelleryshop.adapter

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smartherd.jewelleryshop.databinding.ElevateLooksTipsBinding
import com.smartherd.jewelleryshop.models.ElevateLooksModel

class ElevateLooksAdapter(val context: Context, val itemList: ArrayList<ElevateLooksModel>) :
    RecyclerView.Adapter<ElevateLooksAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val elevateLooksBinding =
            ElevateLooksTipsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(elevateLooksBinding)

    }


    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.elevateLooksImg.setImageResource(itemList[position].img)
        holder.binding.elevateLooksTxt.text = itemList[position].tips
        holder.binding.elevateLooksTxt.paintFlags = Paint.UNDERLINE_TEXT_FLAG

    }

    class ViewHolder(val binding: ElevateLooksTipsBinding) :
        RecyclerView.ViewHolder(binding.root)

}
