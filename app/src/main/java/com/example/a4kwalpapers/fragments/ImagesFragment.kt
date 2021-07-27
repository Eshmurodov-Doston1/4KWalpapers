package com.example.a4kwalpapers.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import com.example.a4kwalpapers.R
import com.example.a4kwalpapers.databinding.FragmentImagesBinding
import com.example.a4kwalpapers.retrofit.ApiClient
import com.example.a4kwalpapers.viewmodel.AppViewModel
import com.example.a4kwalpapers.viewmodel.ViewModelFactory
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ImagesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ImagesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    lateinit var fragmentImagesBinding: FragmentImagesBinding
    lateinit var root:View
    lateinit var appViewModel: AppViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       fragmentImagesBinding = FragmentImagesBinding.inflate(inflater,container,false)
        root =fragmentImagesBinding.root
        appViewModel = ViewModelProviders.of(this,ViewModelFactory("all",ApiClient.apiServise))[AppViewModel::class.java]
        lifecycleScope.launch {
            appViewModel.unsplashImage.collect {

            }
        }
        return root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ImagesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ImagesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}