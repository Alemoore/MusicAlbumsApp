package com.example.musicalbumsapp.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.musicalbumsapp.databinding.FragmentTracksBinding
import com.example.musicalbumsapp.models.TrackItem

class TracksAdapter: RecyclerView.Adapter<TracksAdapter.TracksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TracksViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: TracksViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    val differCallback = object : DiffUtil.ItemCallback<TrackItem>() {
        override fun areItemsTheSame(oldItem: TrackItem, newItem: TrackItem): Boolean {
            TODO("Not yet implemented")
        }

        override fun areContentsTheSame(oldItem: TrackItem, newItem: TrackItem): Boolean {
            TODO("Not yet implemented")
        }

    }

    inner class TracksViewHolder(binding: FragmentTracksBinding): RecyclerView.ViewHolder(binding.root)
}