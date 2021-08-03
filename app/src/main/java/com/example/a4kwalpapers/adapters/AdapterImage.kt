package com.example.a4kwalpapers.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.a4kwalpapers.R
import com.example.a4kwalpapers.databinding.ItemImageBinding
import com.example.a4kwalpapers.models.Result
import com.squareup.picasso.Picasso

class AdapterImage(var onItemClickListener: OnItemClickListener):PagingDataAdapter<Result,AdapterImage.Vh>(MyDiffUtill()) {
    inner class Vh(var itemImageBinding: ItemImageBinding):RecyclerView.ViewHolder(itemImageBinding.root){
        fun onBid(result: Result,position: Int){
            Picasso.get().load(result.urls.thumb).placeholder(R.drawable.loading).into(itemImageBinding.imageMy)
            itemImageBinding.leek.setOnClickListener {
               onItemClickListener.leekClick(result,position)
            }
            itemView.setOnClickListener {
                onItemClickListener.onItemClick(result,position)
            }
        }
    }

    class MyDiffUtill:DiffUtil.ItemCallback<Result>(){
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.equals(newItem)
        }

    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        getItem(position)?.let { holder.onBid(it,position) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemImageBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    interface OnItemClickListener{
        fun onItemClick(result: Result,position: Int)
        fun leekClick(result: Result,position: Int)
    }

}