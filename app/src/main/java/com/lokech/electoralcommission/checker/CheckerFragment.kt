package com.lokech.electoralcommission.checker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.lokech.electoralcommission.R
import com.lokech.electoralcommission.databinding.FragmentCheckerBinding
import org.jetbrains.anko.support.v4.toast


class CheckerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        val binding =
            DataBindingUtil.inflate<FragmentCheckerBinding>(
                inflater,
                R.layout.fragment_checker,
                container,
                false
            )

        binding.btnChecker.setOnClickListener {
            toast("Checking has not yet been implemented")
        }

        return binding.root
    }
}