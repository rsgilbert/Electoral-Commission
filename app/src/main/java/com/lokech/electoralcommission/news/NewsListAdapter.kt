package com.lokech.electoralcommission.news


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lokech.electoralcommission.data.News
import com.lokech.electoralcommission.databinding.NewsItemBinding

class NewsListAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<News, NewsListAdapter.ViewHolder>(ItemDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news: News = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(news)
        }
        holder.bind(news)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder.from(parent)

    class ViewHolder private constructor(private val binding: NewsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(news: News) {
            binding.news = news
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = NewsItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class OnClickListener(val clickListener: (news: News) -> Unit) {
        fun onClick(news: News) = clickListener(news)
    }
}

class ItemDiffCallback : DiffUtil.ItemCallback<News>() {
    override fun areItemsTheSame(
        oldNews: News, newNews
        : News
    ) =
        oldNews.id == newNews.id

    override fun areContentsTheSame(
        oldNews: News, newNews
        : News
    ) =
        oldNews == newNews
}
