package com.lokech.electoralcommission.gallery


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lokech.electoralcommission.data.Picture
import com.lokech.electoralcommission.databinding.PictureItemBinding

class PictureListAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<Picture, PictureListAdapter.ViewHolder>(ItemDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val picture: Picture = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(picture)
        }
        holder.bind(picture)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder.from(parent)

    class ViewHolder private constructor(private val binding: PictureItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(picture: Picture) {
            binding.picture = picture
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = PictureItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class OnClickListener(val clickListener: (picture: Picture) -> Unit) {
        fun onClick(picture: Picture) = clickListener(picture)
    }
}

class ItemDiffCallback : DiffUtil.ItemCallback<Picture>() {
    override fun areItemsTheSame(oldPicture: Picture, newPicture: Picture) =
        oldPicture.pictureUrl == newPicture.pictureUrl

    override fun areContentsTheSame(oldPicture: Picture, newPicture: Picture) =
        oldPicture == newPicture
}
