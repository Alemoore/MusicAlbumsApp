package com.example.musicalbumsapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musicalbumsapp.databinding.ItemAlbumPreviewBinding
import com.example.musicalbumsapp.domain.models.AlbumDomainModel

class AlbumsAdapter : RecyclerView.Adapter<AlbumsAdapter.AlbumsViewHolder>() {

    private var onItemClickListener: ((AlbumDomainModel) -> Unit)? = null

    fun setOnItemClickListener(listener: ((AlbumDomainModel) -> Unit)) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumsViewHolder {
        val binding = ItemAlbumPreviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlbumsViewHolder(binding)
    }


    override fun onBindViewHolder(holder: AlbumsViewHolder, position: Int) {
        val album = differ.currentList[position]
        holder.bind(album)
        holder.itemView.setOnClickListener {
            onItemClickListener?.let {
                it(album)
            }
        }
    }


    override fun getItemCount(): Int = differ.currentList.size

    private val differCallback = object : DiffUtil.ItemCallback<AlbumDomainModel>() {
        override fun areItemsTheSame(oldItem: AlbumDomainModel, newItem: AlbumDomainModel): Boolean {
            return oldItem.collectionId == newItem.collectionId
        }

        override fun areContentsTheSame(oldItem: AlbumDomainModel, newItem: AlbumDomainModel): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    inner class AlbumsViewHolder(private val binding: ItemAlbumPreviewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(album: AlbumDomainModel) {
            Glide.with(binding.root)
                    .load(album.artworkUrl60)
                    .into(binding.albumPreviewImage)
        }
    }

}