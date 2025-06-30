package com.example.clonespotify

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView

class Playlist02ViewAdapter(private val item : List<Playlist02>) :
    RecyclerView.Adapter<Playlist02ViewAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image : ImageButton = view.findViewById(R.id.AlbImage)
        val description : Button = view.findViewById(R.id.Playlist02Tittle)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_playlist02, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.setImageResource(item[position].albumCover)
        holder.description.text = item[position].description
    }

    override fun getItemCount(): Int {
        return item.size
    }
}