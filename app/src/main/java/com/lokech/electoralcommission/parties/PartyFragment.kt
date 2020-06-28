package com.lokech.electoralcommission.parties

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.lokech.electoralcommission.R
import com.lokech.electoralcommission.databinding.FragmentPartyBinding
import com.lokech.electoralcommission.util.openDialerApp

class PartyFragment : Fragment() {
    private val partyViewModel: PartyViewModel by viewModels {
        PartyViewModelFactory(partyId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        val binding =
            DataBindingUtil.inflate<FragmentPartyBinding>(
                inflater,
                R.layout.fragment_party,
                container,
                false
            )

        binding.partyViewModel = partyViewModel

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.party_options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.tel1 -> openDialerApp(partyViewModel.partyLiveData.value!!.tel1)
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }
}

val PartyFragment.partyId: String
    get() = PartyFragmentArgs.fromBundle(arguments!!).partyId