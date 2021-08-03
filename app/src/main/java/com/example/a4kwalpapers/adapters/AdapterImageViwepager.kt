package com.example.a4kwalpapers.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.a4kwalpapers.databinding.ItemPageBinding
import com.example.a4kwalpapers.models.Result
import com.squareup.picasso.Picasso

class AdapterImageViwepager:ListAdapter<Result,AdapterImageViwepager.Vh>(MyDiffUtill()) {
    inner class Vh(var itemPageBinding: ItemPageBinding):RecyclerView.ViewHolder(itemPageBinding.root){
        fun onBind(result: Result,position: Int){
            Picasso.get().load(result.urls.regular).into(itemPageBinding.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemPageBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        getItem(position)?.let { holder.onBind(it,position) }
    }

    class MyDiffUtill:DiffUtil.ItemCallback<Result>(){
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }
    }
}