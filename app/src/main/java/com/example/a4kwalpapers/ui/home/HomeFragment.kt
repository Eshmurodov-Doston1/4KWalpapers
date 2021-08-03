package com.example.a4kwalpapers.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.a4kwalpapers.R
import com.example.a4kwalpapers.adapters.ViewPagerAdapter
import com.example.a4kwalpapers.databinding.FragmentHomeBinding
import com.example.a4kwalpapers.databinding.ItemTabBinding
import com.example.a4kwalpapers.fragments.ImagesFragment
import com.example.a4kwalpapers.fragments.NewFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    lateinit var fragmentHomebinding: FragmentHomeBinding
    lateinit var root:View
    lateinit var viewPagerAdapter: ViewPagerAdapter
    lateinit var list: ArrayList<Int>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentHomebinding= FragmentHomeBinding.inflate(inflater,container,false)
        root = fragmentHomebinding.root
        loadCategory()
        fragmentHomebinding.tabLayout.onItemSelected={
            when(it){
                0->{
                  fragmentHomebinding.viewpager2.currentItem = 0
                }
                1->{
                    fragmentHomebinding.viewpager2.currentItem = 1
                }
                2->{
                    fragmentHomebinding.viewpager2.currentItem = 2
                }
            }
        }
        
        setData()
        return root
    }

    private fun setData() {
        viewPagerAdapter = ViewPagerAdapter(requireActivity())
        fragmentHomebinding.viewpager2.adapter = viewPagerAdapter
        fragmentHomebinding.viewpager2.registerOnPageChangeCallback(object:ViewPager2.OnPageChangeCallback(){
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when(position){
                    0->{
                      fragmentHomebinding.tabLayout.itemActiveIndex = 0
                    }
                    1->{
                        fragmentHomebinding.tabLayout.itemActiveIndex = 1
                    }
                    2->{
                        fragmentHomebinding.tabLayout.itemActiveIndex = 2
                    }
                }
            }
        })
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.show()
    }


    private fun loadCategory() {
        list = ArrayList()
        list.add(R.drawable.ic_insert_picture_icon)
        list.add(R.drawable.ic_menu)
    }

}