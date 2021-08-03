package com.example.a4kwalpapers.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.a4kwalpapers.R
import com.example.a4kwalpapers.adapters.AdapterImageViwepager
import com.example.a4kwalpapers.databinding.FragmentLoadImageBinding
import com.example.a4kwalpapers.models.Result
import com.example.a4kwalpapers.retrofit.ApiClient
import com.example.a4kwalpapers.utils.MyList
import com.example.a4kwalpapers.viewmodel.AppViewModel
import com.example.a4kwalpapers.viewmodel.ViewModelFactory
import com.squareup.picasso.Picasso
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoadImageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoadImageFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var fragmentLoadmageBinding:FragmentLoadImageBinding
    lateinit var root:View
    lateinit var appViewModel: AppViewModel
    lateinit var adapterImageViewpager:AdapterImageViwepager
    var position1:Int=0
    private  val TAG = "LoadImageFragment"
    var category:String=""
    lateinit var listResult:ArrayList<Result>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         position1 = arguments?.getInt("position")!!
         category = arguments?.getString("category").toString()
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentLoadmageBinding = FragmentLoadImageBinding.inflate(inflater,container,false)
        root = fragmentLoadmageBinding.root
        listResult = ArrayList()

        val image = arguments?.getString("image")
        val category = arguments?.getString("category")
        (activity as AppCompatActivity).supportActionBar?.hide()
        Picasso.get().load(image).into(fragmentLoadmageBinding.image)

//        adapterImageViewpager = AdapterImageViwepager()
//        appViewModel = ViewModelProviders.of(this,
//            category?.let { ViewModelFactory(it, ApiClient.apiServise) })[AppViewModel::class.java]
//
//        lifecycleScope.launch {
//            appViewModel.unsplashImage.collect {
//
//            }
//        }
//        fragmentLoadmageBinding.viewpager2.adapter = adapterImageViewpager


        return root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoadImageFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoadImageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}