package com.lokech.electoralcommission.news


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.lokech.electoralcommission.R
import com.lokech.electoralcommission.databinding.NewsListBinding
import org.jetbrains.anko.support.v4.toast


class NewsListFragment : Fragment() {
    private val newsListViewModel: NewsListViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding =
            DataBindingUtil.inflate<NewsListBinding>(
                inflater,
                R.layout.news_list,
                container,
                false
            )

        binding.newsListViewModel = newsListViewModel

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            newsList.adapter = NewsListAdapter(newsListClickListener)
        }

        return binding.root
    }
}

val NewsListFragment.newsListClickListener: NewsListAdapter.OnClickListener
    get() = NewsListAdapter.OnClickListener {
        toast("news item clicked")
//        val action = NewsListFragmentDirections.actionNewsListFragmentToNewsFragment(it.id)
//        findNavController().navigate(action)
    }