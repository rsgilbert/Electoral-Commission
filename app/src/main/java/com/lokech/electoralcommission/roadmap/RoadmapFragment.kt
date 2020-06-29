package com.lokech.electoralcommission.roadmap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.lokech.electoralcommission.R
import com.lokech.electoralcommission.databinding.FragmentRoadmapBinding

class RoadmapFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        val binding =
            DataBindingUtil.inflate<FragmentRoadmapBinding>(
                inflater,
                R.layout.fragment_roadmap,
                container,
                false
            )

        return binding.root
    }
}