package com.lokech.electoralcommission.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lokech.electoralcommission.databinding.PictureBinding

class PictureListAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<String, PictureListAdapter.ViewHolder>(PictureDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: String = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(item)
        }
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder.from(parent)

    class ViewHolder private constructor(private val binding: PictureBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: String) {
            binding.picture = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = PictureBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class OnClickListener(val clickListener: (item: String) -> Unit) {
        fun onClick(item: String) = clickListener(item)
    }
}

class PictureDiffCallback : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldPicture: String, newPicture: String) =
        oldPicture == newPicture

    override fun areContentsTheSame(oldPicture: String, newPicture: String) =
        oldPicture == newPicture
}
