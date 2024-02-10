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
import com.zali.tripsearcher.R
import com.zali.tripsearcher.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private  val TAG = "HomeFragment"

    private lateinit var binding: FragmentHomeBinding

    private lateinit var owner: LifecycleOwner

    private lateinit var homeViewModel: HomeViewModel


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
                var test = t
                Log.d(TAG, "onCreateView: ")
            }





        return binding.root
    }
}