package com.example.clonespotify

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class PlaylistViewAdapter(private val items : List<Playlist>) :
    RecyclerView.Adapter<PlaylistViewAdapter.ViewHolder>() {
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val image : ImageView = view.findViewById<ImageView>(R.id.ImageAlb)
        val title : Button = view.findViewById<Button>(R.id.PlaylistTittle)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_playlist, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.setImageResource(items[position].imageId)
        holder.title.text = items[position].tittle
    }

    override fun getItemCount(): Int {
        return items.size
    }


}