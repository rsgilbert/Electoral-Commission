package com.lokech.electoralcommission.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.lokech.electoralcommission.R
import com.lokech.electoralcommission.databinding.VisionTabBinding

class VisionFragment : Fragment() {
    private val infoViewModel: InfoViewModel by viewModels({ requireParentFragment() })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<VisionTabBinding>(
            inflater,
            R.layout.vision_tab,
            container,
            false
        )

        binding.infoViewModel = infoViewModel
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
        }

        return binding.root
    }
}