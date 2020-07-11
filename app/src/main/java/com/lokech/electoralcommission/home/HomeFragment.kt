package com.lokech.electoralcommission.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.lokech.electoralcommission.R
import com.lokech.electoralcommission.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    val homeViewModel: HomeViewModel by viewModels()
    val covidVisualizerUrl = "https://www.covidvisualizer.com"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        val binding =
            DataBindingUtil.inflate<FragmentHomeBinding>(
                inflater,
                R.layout.fragment_home,
                container,
                false
            )

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            webView.apply {
                settings.javaScriptEnabled = true
                webViewClient = WebViewClient()
                loadUrl(covidVisualizerUrl)

            }

        }

        return binding.root
    }
}

val HomeFragment.pictureListAdapter
    get() = PictureListAdapter.OnClickListener {

    }