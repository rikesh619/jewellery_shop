package com.smartherd.jewelleryshop.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import com.smartherd.jewelleryshop.R
import com.smartherd.jewelleryshop.adapter.CategoriesItemListAdapter
import com.smartherd.jewelleryshop.adapter.ElevateLooksAdapter
import com.smartherd.jewelleryshop.databinding.ActivityTipsTestimonialBinding
import com.smartherd.jewelleryshop.models.ElevateLooksModel
import com.smartherd.jewelleryshop.models.ItemCategoriesModel

class TipsTestimonialActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTipsTestimonialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTipsTestimonialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        elevateTipsRecycler()


    }

    private fun elevateTipsRecycler() {
        val itemList = ArrayList<ElevateLooksModel>()


        itemList.add(ElevateLooksModel(R.drawable.wedding_bg , "5 Ways to Styling your hair when you wear earings"))
        itemList.add(ElevateLooksModel(R.drawable.wedding_bg , "5 Ways to Styling your hair when you wear earings"))
        itemList.add(ElevateLooksModel(R.drawable.wedding_bg , "5 Ways to Styling your hair when you wear earings"))
        itemList.add(ElevateLooksModel(R.drawable.wedding_bg , "5 Ways to Styling your hair when you wear earings"))
        itemList.add(ElevateLooksModel(R.drawable.wedding_bg , "5 Ways to Styling your hair when you wear earings"))
        itemList.add(ElevateLooksModel(R.drawable.wedding_bg , "5 Ways to Styling your hair when you wear earings"))
        itemList.add(ElevateLooksModel(R.drawable.wedding_bg , "5 Ways to Styling your hair when you wear earings"))
        itemList.add(ElevateLooksModel(R.drawable.wedding_bg , "5 Ways to Styling your hair when you wear earings"))


        binding.elevateLooksTipsRecyclerview.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapter = ElevateLooksAdapter(this, itemList)
        binding.elevateLooksTipsRecyclerview.adapter = adapter
    }
}