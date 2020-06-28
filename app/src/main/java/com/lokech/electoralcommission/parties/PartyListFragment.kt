package com.lokech.electoralcommission.parties

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.lokech.electoralcommission.R
import com.lokech.electoralcommission.databinding.PartyListBinding


class PartyListFragment : Fragment() {
    private val partyListViewModel: PartyListViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding =
            DataBindingUtil.inflate<PartyListBinding>(
                inflater,
                R.layout.party_list,
                container,
                false
            )

        binding.partyListViewModel = partyListViewModel

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            partyList.adapter = PartyListAdapter(partyListClickListener)
        }

        return binding.root
    }
}

val PartyListFragment.partyListClickListener: PartyListAdapter.OnClickListener
    get() = PartyListAdapter.OnClickListener {
        val action = PartyListFragmentDirections.actionPartyListFragmentToPartyFragment(it.id)
        findNavController().navigate(action)
    }