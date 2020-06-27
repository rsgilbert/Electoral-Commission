package com.lokech.electoralcommission.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.lokech.electoralcommission.R
import com.lokech.electoralcommission.databinding.PictureListBinding
import org.jetbrains.anko.support.v4.toast

class PictureListFragment : Fragment() {
    private val galleryViewModel: GalleryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding =
            DataBindingUtil.inflate<PictureListBinding>(
                inflater,
                R.layout.picture_list,
                container,
                false
            )

        binding.galleryViewModel = galleryViewModel

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            pictureList.adapter = PictureListAdapter(pictureListClickListener)
        }

        return binding.root
    }
}

val PictureListFragment.pictureListClickListener: PictureListAdapter.OnClickListener
    get() = PictureListAdapter.OnClickListener {
        toast(it.pictureUrl)
    }