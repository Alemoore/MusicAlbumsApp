package com.example.musicalbumsapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.musicalbumsapp.databinding.FragmentTrackHolderBinding
import com.example.musicalbumsapp.domain.models.TrackDomainModel

class TracksAdapter : RecyclerView.Adapter<TracksAdapter.TracksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TracksViewHolder {
        val binding = FragmentTrackHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TracksViewHolder((binding))
    }

    override fun onBindViewHolder(holder: TracksViewHolder, position: Int) {
        val trackItem = differ.currentList[position]
        holder.bind(trackItem)
    }

    override fun getItemCount(): Int = differ.currentList.size


    private val differCallback = object : DiffUtil.ItemCallback<TrackDomainModel>() {
        override fun areItemsTheSame(oldItem: TrackDomainModel, newItem: TrackDomainModel): Boolean {
            return oldItem.trackId == newItem.trackId && oldItem.trackName == newItem.trackName
        }

        override fun areContentsTheSame(oldItem: TrackDomainModel, newItem: TrackDomainModel): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    inner class TracksViewHolder(private val binding: FragmentTrackHolderBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(trackItem: TrackDomainModel) {
            binding.apply {
                trackName.text = trackItem.trackName
            }
        }
    }
}