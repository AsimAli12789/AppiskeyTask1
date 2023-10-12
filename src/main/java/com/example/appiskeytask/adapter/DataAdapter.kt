package com.example.appiskeytask.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appiskeytask.databinding.DataItemListBinding
import com.example.appiskeytask.model.ImageData

class DataAdapter(val context: Context, private var arrayList: ArrayList<ImageData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun updateData(imageData: ArrayList<ImageData>) {
        arrayList = imageData
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemList(DataItemListBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val bind = (holder as ItemList)
        val infoModel = arrayList[position]

        Glide.with(context).load(infoModel.largeImageURL).into( bind.binding.imgDisplay)

        bind.binding.tagsTextView.text = "Tags: "+infoModel.tags
        bind.binding.userTextView.text = "Users: "+infoModel.user
        bind.binding.likesTextView.text ="Likes: "+ infoModel.likes.toString()


    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    inner class ItemList(val binding: DataItemListBinding) :
        RecyclerView.ViewHolder(binding.root)
}