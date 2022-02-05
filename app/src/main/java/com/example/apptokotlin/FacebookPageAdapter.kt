package com.example.apptokotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FacebookPageAdapter(val posts:List<FacebookPageItems>):RecyclerView.Adapter<FacebookPageAdapter.FacebookPageVeiwHolder>() {


    class FacebookPageVeiwHolder(view:View):RecyclerView.ViewHolder(view){
        var txtName: TextView = view.findViewById(R.id.post_profile_name)
        var txtTime: TextView = view.findViewById(R.id.post_profile_time)
        var txtPostContent:TextView= view.findViewById(R.id.post_text)
        var image: ImageView = view.findViewById(R.id.post_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacebookPageVeiwHolder {
        var view:View=LayoutInflater.from(parent.context).inflate(R.layout.facebook_post,parent,false)
        return FacebookPageVeiwHolder(view);
    }

    override fun onBindViewHolder(holder: FacebookPageVeiwHolder, position: Int) {
        var post:FacebookPageItems=posts.get(position)
        post?.name?.let {
            holder.txtName.text=it
        }
        post?.time?.let {
            holder.txtTime.text=it
        }
        post?.postContent?.let {
            holder.txtPostContent.text=it
        }
        post?.iamgeId?.let {
            holder.image.setImageResource(it)
        }
    }

    override fun getItemCount(): Int {
        return posts.size
    }
}