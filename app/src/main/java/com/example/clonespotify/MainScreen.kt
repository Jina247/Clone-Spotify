package com.example.clonespotify

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val playlist01 : List<Playlist> = listOf(
            Playlist(R.drawable.alec_ben_ab, getString(R.string.narrated_for_you)),
            Playlist(R.drawable.alec_ben_ab2, getString(R.string.let_me_down_slowly)),
            Playlist(R.drawable.taylor_swift_album, getString(R.string.lover)),
        )

        val recyclerView01 = findViewById<RecyclerView>(R.id.PlaylistRecycler01)
        recyclerView01.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView01.adapter = PlaylistViewAdapter(playlist01)

        val playlist02 : List<Playlist> = listOf(
            Playlist(R.drawable.ari_album, getString(R.string.eternal_sunshine_deluxe_brighter_days_ahead)),
            Playlist(R.drawable.shawn_album, "Shawn Mendes (Deluxe)"),
            Playlist(R.drawable.rosie_ab, "APT.")
        )

        val recyclerView02 = findViewById<RecyclerView>(R.id.PlaylistRecycler02)
        recyclerView02.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView02.adapter = PlaylistViewAdapter(playlist02)
    }

    // Made For You playlists
    val playlist03 : List<Playlist02> = listOf(
        Playlist02(R.drawable.taylor_swift_album, "Taylor Swift, Sabrina Carpenter and more"),
        Playlist02(R.drawable.shawn_album, "Shawn Mendes, Justin Bieber, Carly Rae Jepsen and more"),
        Playlist02(R.drawable.keshi_album, "keshi, Fujii Kaze, Bemax, RADWIMPS and more"),
        Playlist02(R.drawable.noeasy_alb, "Stray Kids, Seventeen, Tomorrow x Together and more"),
        Playlist02(R.drawable.about_you_alb, "The 1975")
    )

    val recyclerView03 = findViewById<RecyclerView>()

}