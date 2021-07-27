package com.example.a4kwalpapers.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.a4kwalpapers.fragments.CategoriesFragment
import com.example.a4kwalpapers.fragments.ImagesFragment
import com.example.a4kwalpapers.fragments.NewFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{
                ImagesFragment()
            }
            1->{
              NewFragment()
            }
            2->{
                CategoriesFragment()
            }
            else->{
                ImagesFragment()
            }
        }
    }

}