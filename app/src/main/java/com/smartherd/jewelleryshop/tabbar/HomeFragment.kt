package com.smartherd.jewelleryshop.tabbar

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import com.smartherd.jewelleryshop.R
import com.smartherd.jewelleryshop.activity.ProductDetailActivity
import com.smartherd.jewelleryshop.activity.TipsTestimonialActivity
import com.smartherd.jewelleryshop.adapter.CategoriesItemListAdapter
import com.smartherd.jewelleryshop.adapter.LatestEditionAdapter
import com.smartherd.jewelleryshop.adapter.SpecialEditionAdapter
import com.smartherd.jewelleryshop.databinding.FragmentHomeBinding
import com.smartherd.jewelleryshop.models.DailyRatesUpdateModel
import com.smartherd.jewelleryshop.models.ItemCategoriesModel
import com.smartherd.jewelleryshop.models.LatestEditionModel
import com.smartherd.jewelleryshop.models.SpecialEditionModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private var db = Firebase.firestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        itemCategoriesRecycler()
        latestEditionRecycler()
        specialEditionRecycler()
        dummyProductDetailClick()
        RateUpdates()

        return binding.root
    }

    private fun dummyProductDetailClick() {
        binding.dummyClick.setOnClickListener {
            val intent = Intent(requireContext(), ProductDetailActivity::class.java)
            requireContext().startActivity(intent)
        }

        binding.dummyTipsClick.setOnClickListener {
            val intent = Intent(requireContext(), TipsTestimonialActivity::class.java)
            requireContext().startActivity(intent)
        }
    }

    private fun itemCategoriesRecycler() {
        val itemList = mutableListOf<ItemCategoriesModel>()

        db = FirebaseFirestore.getInstance()
        db.collection("categories").get()
            .addOnSuccessListener {
                for (data in it.documents) {
                    val image = data.getString("image_name") ?: ""
                    val imageName = data.getString("name") ?: ""

                    val categories = ItemCategoriesModel(image, imageName)
                    itemList.add(categories)
                }
                val adapter = CategoriesItemListAdapter(requireContext(), itemList)
                binding.itemsCategoriesRecycler.adapter = adapter
                binding.itemsCategoriesRecycler.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            }
            .addOnFailureListener {
                Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT).show()
            }


    }

    private fun RateUpdates() {
        db = Firebase.firestore


        db.collection("today_rate").document("PxlmxfwNwvEUxBrGEXUY").get()
            .addOnSuccessListener {
                if (it != null && it.exists()) {
                    val rate = it.toObject(DailyRatesUpdateModel::class.java)

                    if (rate != null) {
                        val date = rate.date?.toDate()
                        val formattedDate = date?.toString()

                        binding.todaysDate.text = formattedDate

                        //Gold Rates Updates
                        rate.gold?.forEachIndexed { index, goldModel ->
                            if (index == 0) {
                                binding.hallmarkGoldQuality.text = goldModel.quality
                                binding.pureGoldTola.text = goldModel.price.toString()
                            } else if (index == 1) {
                                binding.tejabiGoldQuality.text = goldModel.quality
                                binding.tejabiGoldTola.text = goldModel.price.toString()
                            } else if (index == 2) {
                                binding.pureGoldGram.text = goldModel.price.toString()
                            } else if (index == 3) {
                                binding.tejabiGoldGram.text = goldModel.price.toString()
                            } else {
                                Toast.makeText(
                                    requireContext(),
                                    "Sorry ! No Data Has Been Found",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                        // Silver Rates Updates

                        rate.silver?.forEachIndexed { index, silverModel ->
                            if (index == 0 ){
                                binding.hallmarkSilverQuality.text = silverModel.quality
                                binding.silverTola.text = silverModel.price.toString()
                            }else if (index == 1){
                                binding.silverGram.text = silverModel.price.toString()
                            }
                        }


                    }
                }
            }
            .addOnFailureListener { }

    }

    private fun latestEditionRecycler() {
        val itemList = ArrayList<LatestEditionModel>()

        itemList.add(LatestEditionModel(R.drawable.pngwing, "Rings", "$ 5000"))
        itemList.add(LatestEditionModel(R.drawable.pngwing, "Rings", "$ 5000"))
        itemList.add(LatestEditionModel(R.drawable.pngwing, "Rings", "$ 5000"))
        itemList.add(LatestEditionModel(R.drawable.pngwing, "Rings", "$ 5000"))
        itemList.add(LatestEditionModel(R.drawable.pngwing, "Rings", "$ 5000"))
        itemList.add(LatestEditionModel(R.drawable.pngwing, "Rings", "$ 5000"))
        itemList.add(LatestEditionModel(R.drawable.pngwing, "Rings", "$ 5000"))
        itemList.add(LatestEditionModel(R.drawable.pngwing, "Rings", "$ 5000"))
        itemList.add(LatestEditionModel(R.drawable.pngwing, "Rings", "$ 9000"))
        itemList.add(LatestEditionModel(R.drawable.pngwing, "Rings", "$ 9000"))




        binding.latestEditionRecyclerview.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val adapter = LatestEditionAdapter(requireContext(), itemList)
        binding.latestEditionRecyclerview.adapter = adapter

    }

    private fun specialEditionRecycler() {
        val itemList = ArrayList<SpecialEditionModel>()

        itemList.add(SpecialEditionModel(R.drawable.pngwing, "Ring", "$80000"))
        itemList.add(SpecialEditionModel(R.drawable.pngwing, "Ring", "$80000"))
        itemList.add(SpecialEditionModel(R.drawable.pngwing, "Ring", "$80000"))
        itemList.add(SpecialEditionModel(R.drawable.pngwing, "Ring", "$80000"))
        itemList.add(SpecialEditionModel(R.drawable.pngwing, "Ring", "$80000"))
        itemList.add(SpecialEditionModel(R.drawable.pngwing, "Ring", "$80000"))
        itemList.add(SpecialEditionModel(R.drawable.pngwing, "Ring", "$80000"))
        itemList.add(SpecialEditionModel(R.drawable.pngwing, "Ring", "$80000"))
        itemList.add(SpecialEditionModel(R.drawable.pngwing, "Ring", "$80000"))
        itemList.add(SpecialEditionModel(R.drawable.pngwing, "Ring", "$80000"))
        itemList.add(SpecialEditionModel(R.drawable.pngwing, "Ring", "$80000"))
        itemList.add(SpecialEditionModel(R.drawable.pngwing, "Ring", "$80000"))
        itemList.add(SpecialEditionModel(R.drawable.pngwing, "Ring", "$80000"))
        itemList.add(SpecialEditionModel(R.drawable.pngwing, "Ring", "$80000"))
        itemList.add(SpecialEditionModel(R.drawable.pngwing, "Ring", "$80000"))


        binding.specialEditionRecylerview.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val adapter = SpecialEditionAdapter(requireContext(), itemList)
        binding.specialEditionRecylerview.adapter = adapter

    }


}