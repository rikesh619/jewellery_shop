package com.smartherd.jewelleryshop.tabbar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.smartherd.jewelleryshop.R
import com.smartherd.jewelleryshop.adapter.CategoriesItemListAdapter
import com.smartherd.jewelleryshop.adapter.LatestEditionAdapter
import com.smartherd.jewelleryshop.adapter.SpecialEditionAdapter
import com.smartherd.jewelleryshop.databinding.FragmentHomeBinding
import com.smartherd.jewelleryshop.models.ItemCategoriesModel
import com.smartherd.jewelleryshop.models.LatestEditionModel
import com.smartherd.jewelleryshop.models.SpecialEditionModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        itemCategoriesRecycler()
        latestEditionRecycler()
        specialEditionRecycler()

        return binding.root
    }

    private fun itemCategoriesRecycler() {
        val itemList = ArrayList<ItemCategoriesModel>()

        itemList.add(ItemCategoriesModel(R.drawable.pngwing, "Rings"))
        itemList.add(ItemCategoriesModel(R.drawable.pngwing, "Rings"))
        itemList.add(ItemCategoriesModel(R.drawable.pngwing, "Rings"))
        itemList.add(ItemCategoriesModel(R.drawable.pngwing, "Rings"))
        itemList.add(ItemCategoriesModel(R.drawable.pngwing, "Rings"))
        itemList.add(ItemCategoriesModel(R.drawable.pngwing, "Rings"))
        itemList.add(ItemCategoriesModel(R.drawable.pngwing, "Rings"))
        itemList.add(ItemCategoriesModel(R.drawable.pngwing, "Rings"))

        binding.itemsCategoriesRecycler.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val adapter = CategoriesItemListAdapter(requireContext(), itemList)
        binding.itemsCategoriesRecycler.adapter = adapter
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

    private fun specialEditionRecycler(){
        val itemList = ArrayList<SpecialEditionModel>()

        itemList.add(SpecialEditionModel(R.drawable.pngwing , "Ring" , "$80000"))
        itemList.add(SpecialEditionModel(R.drawable.pngwing , "Ring" , "$80000"))
        itemList.add(SpecialEditionModel(R.drawable.pngwing , "Ring" , "$80000"))
        itemList.add(SpecialEditionModel(R.drawable.pngwing , "Ring" , "$80000"))
        itemList.add(SpecialEditionModel(R.drawable.pngwing , "Ring" , "$80000"))
        itemList.add(SpecialEditionModel(R.drawable.pngwing , "Ring" , "$80000"))
        itemList.add(SpecialEditionModel(R.drawable.pngwing , "Ring" , "$80000"))
        itemList.add(SpecialEditionModel(R.drawable.pngwing , "Ring" , "$80000"))
        itemList.add(SpecialEditionModel(R.drawable.pngwing , "Ring" , "$80000"))
        itemList.add(SpecialEditionModel(R.drawable.pngwing , "Ring" , "$80000"))
        itemList.add(SpecialEditionModel(R.drawable.pngwing , "Ring" , "$80000"))
        itemList.add(SpecialEditionModel(R.drawable.pngwing , "Ring" , "$80000"))
        itemList.add(SpecialEditionModel(R.drawable.pngwing , "Ring" , "$80000"))
        itemList.add(SpecialEditionModel(R.drawable.pngwing , "Ring" , "$80000"))
        itemList.add(SpecialEditionModel(R.drawable.pngwing , "Ring" , "$80000"))


        binding.specialEditionRecylerview.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val adapter = SpecialEditionAdapter(requireContext(), itemList)
        binding.specialEditionRecylerview.adapter = adapter

    }


}