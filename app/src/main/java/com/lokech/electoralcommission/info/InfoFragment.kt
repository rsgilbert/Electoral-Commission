package com.lokech.electoralcommission.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.lokech.electoralcommission.R
import com.lokech.electoralcommission.databinding.ViewPagerBinding

class InfoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<ViewPagerBinding>(
            inflater, R.layout.view_pager, container, false
        )

        binding.pager.adapter = InfoAdapter(this)

        TabLayoutMediator(binding.tabLayout, binding.pager, tabConfiguration).attach()

        return binding.root

    }
}

private val InfoFragment.tabConfiguration: TabLayoutMediator.TabConfigurationStrategy
    get() = TabLayoutMediator.TabConfigurationStrategy { tab, position ->
        when (position) {
            0 -> tab.text = getString(R.string.mission)
            1 -> tab.text = getString(R.string.vision)
            else -> tab.text = getString(R.string.goal)
        }
    }
