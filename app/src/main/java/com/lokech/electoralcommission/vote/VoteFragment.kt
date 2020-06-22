package com.lokech.electoralcommission.vote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.lokech.electoralcommission.R
import com.lokech.electoralcommission.databinding.FragmentVoteBinding

class VoteFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        val binding: FragmentVoteBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_vote, container, false
        )

        return binding.root
    }

}