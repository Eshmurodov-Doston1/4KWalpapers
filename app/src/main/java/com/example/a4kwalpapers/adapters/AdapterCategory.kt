package com.example.a4kwalpapers.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a4kwalpapers.R
import com.example.a4kwalpapers.databinding.ItemCategoryBinding
import com.example.a4kwalpapers.models.category.Category
import com.squareup.picasso.Picasso

class AdapterCategory(var onItemClicListener:OnItemClicListener,var list: List<Category>):RecyclerView.Adapter<AdapterCategory.Vh>() {
    inner class Vh(var itemCategoryBinding: ItemCategoryBinding):RecyclerView.ViewHolder(itemCategoryBinding.root){
        fun onBind(category:Category,position: Int){
            Picasso.get().load(category.image).placeholder(R.drawable.loading).into(itemCategoryBinding.imageCategory)
            itemCategoryBinding.name.text = category.name
            itemView.setOnClickListener {
                onItemClicListener.onImageClic(category,position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position],position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
    interface OnItemClicListener{
        fun onImageClic(category:Category,position: Int)
    }
}