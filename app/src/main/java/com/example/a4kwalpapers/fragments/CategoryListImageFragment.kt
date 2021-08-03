package com.example.a4kwalpapers.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.a4kwalpapers.R
import com.example.a4kwalpapers.adapters.AdapterImage
import com.example.a4kwalpapers.databinding.FragmentCategoryListImageBinding
import com.example.a4kwalpapers.models.Result
import com.example.a4kwalpapers.retrofit.ApiClient
import com.example.a4kwalpapers.utils.MyList
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
 * Use the [CategoryListImageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoryListImageFragment : Fragment() {
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
    lateinit var fragmentCategoryListImageBinding:FragmentCategoryListImageBinding
    lateinit var root:View
    lateinit var appViewModel: AppViewModel
    lateinit var adapterImage:AdapterImage
    lateinit var handler: Handler
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      fragmentCategoryListImageBinding = FragmentCategoryListImageBinding.inflate(inflater,container,false)
        root = fragmentCategoryListImageBinding.root
        handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            fragmentCategoryListImageBinding.spinKit.visibility = View.INVISIBLE
        },3000)
        val category = arguments?.getString("name")
        (activity as AppCompatActivity).supportActionBar?.title = category

        adapterImage = AdapterImage(object:AdapterImage.OnItemClickListener{
            override fun onItemClick(result: Result, position: Int) {
                var bundle = Bundle()
                bundle.putInt("position",position)
                bundle.putString("image",result.urls.regular)
                bundle.putString("category",category)

                findNavController().navigate(R.id.loadImageFragment,bundle)
            }

            override fun leekClick(result: Result, position: Int) {

            }

        })
        appViewModel = ViewModelProviders.of(this,
            category?.let { ViewModelFactory(it, ApiClient.apiServise) })[AppViewModel::class.java]
        lifecycleScope.launch {
            appViewModel.unsplashImage.collect {
                adapterImage.submitData(it)
            }
        }
        fragmentCategoryListImageBinding.categoryRv.adapter = adapterImage
        return root
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CategoryListImageFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CategoryListImageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}