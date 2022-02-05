package com.example.apptokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var postsRecyclerView:RecyclerView
    lateinit var storiesRecyclerView:RecyclerView
    lateinit var posts:MutableList<FacebookPageItems>
    lateinit var stories:MutableList<FacebookStoryItems>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        test()
        postsRecyclerView=findViewById(R.id.posts)
        storiesRecyclerView=findViewById(R.id.stories)
        var storyLayoutManager:LinearLayoutManager= LinearLayoutManager(this)
        storyLayoutManager.setOrientation(RecyclerView.HORIZONTAL)
        storiesRecyclerView.layoutManager=storyLayoutManager
        storiesRecyclerView.adapter=FacebookStoryAdapter(stories)
        var postLayoutManager:LinearLayoutManager=LinearLayoutManager(this)
        postsRecyclerView.layoutManager=postLayoutManager
        postsRecyclerView.adapter=FacebookPageAdapter(posts)
    }
    fun test(){
        posts= mutableListOf()
        stories= mutableListOf()
        for (i in 0..10){
            posts.add(FacebookPageItems("name"+i,""+i+"h",R.drawable.android,postContent="hello "+i))
            posts.add(FacebookPageItems("name"+i,""+i+"h",R.drawable.ios,postContent="hello "+i))
            posts.add(FacebookPageItems("name"+i,""+i+"h",R.drawable.fullstack,postContent="hello "+i))
            stories.add(FacebookStoryItems(R.drawable.android,"name"+i))
            stories.add(FacebookStoryItems(R.drawable.ios,"name"+i))
            stories.add(FacebookStoryItems(R.drawable.fullstack,"name"+i))
        }
    }
}