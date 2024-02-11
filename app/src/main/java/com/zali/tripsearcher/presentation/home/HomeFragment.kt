package com.zali.tripsearcher.presentation.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.zali.tripsearcher.DataItemType
import com.zali.tripsearcher.databinding.FragmentHomeBinding
import com.zali.tripsearcher.domain.DataItem
import com.zali.tripsearcher.presentation.home.homelist.HomeAdapter


class HomeFragment : Fragment() {

    private  val TAG = "HomeFragment"

    private lateinit var binding: FragmentHomeBinding

    private lateinit var owner: LifecycleOwner

    private lateinit var homeViewModel: HomeViewModel

    private lateinit var homeAdapter : HomeAdapter

    private var listItem  = ArrayList<DataItem>()
    override fun onAttach(context: Context) {
        super.onAttach(context)
        owner = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)



        homeViewModel.requestListMain()
            .observe(owner){t->
                val test = t

                for (i  in 0 until test.data.size){
                    when (test.data[i].type) {
                        "slide" -> {
                            listItem.add(DataItem(DataItemType.SLIDER,test.data[i].items))
                        }
                        "story" -> {
                            listItem.add(DataItem(DataItemType.STORY,test.data[i].items))
                        }
                        "banner" -> {
                            listItem.add(DataItem(DataItemType.BANNER,test.data[i].items))
                        }
                    }
                }

                homeAdapter = HomeAdapter(listItem)

                binding.recyclerMain.adapter = homeAdapter
                binding.recyclerMain.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
                Log.d(TAG, "onCreateView: ")
            }





        return binding.root
    }


}