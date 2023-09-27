package com.medkissi.remotedatasourceappgroup2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.medkissi.remotedatasourceappgroup2.R
import com.medkissi.remotedatasourceappgroup2.data.model.Post

class PostAdapter : ListAdapter<Post, PostAdapter.PostViewHolder>(PostDiffUtil()) {

    class PostViewHolder(itemView: View) : ViewHolder(itemView.rootView) {
        val title = itemView.findViewById<TextView>(R.id.title)
        val body = itemView.findViewById<TextView>(R.id.body)

        fun bind(post: Post) {
            title.text = post.title
            body.text = post.body
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return  PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
       val post = getItem(position)
        holder.bind(post)
    }
}

class PostDiffUtil() : DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {

        return oldItem == newItem
    }

}