package com.medkissi.remotedatasourceappgroup2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.medkissi.remotedatasourceappgroup2.R
import com.medkissi.remotedatasourceappgroup2.data.model.Photo

class PhotoAdapter:ListAdapter<Photo,PhotoAdapter.PhotoViewHolder>(PhotoDiffUtil()) {

    class PhotoViewHolder(itemView: View):ViewHolder(itemView.rootView){
        val image = itemView.findViewById<ImageView>(R.id.photo)
        val title =  itemView.findViewById<TextView>(R.id.title_image)
        fun bind(photo: Photo){
            title.text = photo.title
            Glide
                .with(itemView)
                .load(photo.url)
                .into(image)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_list2,parent,false)
        return  PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = getItem(position)
        holder.bind(photo)
    }
}

class PhotoDiffUtil():DiffUtil.ItemCallback<Photo>(){
    override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return   oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return  oldItem ==  newItem
    }

}