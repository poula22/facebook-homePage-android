package com.example.apptokotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FacebookStoryAdapter(var stories:List<FacebookStoryItems>):RecyclerView.Adapter<FacebookStoryAdapter.FacebookStoryViewHolder>() {

    class FacebookStoryViewHolder:RecyclerView.ViewHolder{
        lateinit var image:ImageView
        lateinit var txtProfileName:TextView
        constructor(view:View):super(view){
            image=view.findViewById(R.id.story_image)
            txtProfileName=view.findViewById(R.id.story_profile_name)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacebookStoryViewHolder {
        val view:View=LayoutInflater.from(parent.context).inflate(R.layout.facebook_story,parent,false)
        return FacebookStoryViewHolder(view);
    }

    override fun onBindViewHolder(holder: FacebookStoryViewHolder, position: Int) {
        val story:FacebookStoryItems=stories.get(position)
        story?.imageId?.let {
            holder.image.setImageResource(it)
        }
        story?.profileName?.let {
            holder.txtProfileName.text=it
        }
    }

    override fun getItemCount(): Int {
        return stories.size
    }
}