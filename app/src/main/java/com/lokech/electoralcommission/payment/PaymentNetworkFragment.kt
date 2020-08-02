package com.lokech.electoralcommission.payment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.lokech.electoralcommission.R
import com.lokech.electoralcommission.databinding.PaymentNetworkBinding


class PaymentNetworkFragment : Fragment() {
    private val paymentViewModel: PaymentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        val binding =
            DataBindingUtil.inflate<PaymentNetworkBinding>(
                inflater,
                R.layout.payment_network,
                container,
                false
            )


        binding.paymentViewModel = paymentViewModel
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            airtel.setOnClickListener {
                paymentViewModel!!.networkLiveData.value = 0
            }
            mtn.setOnClickListener {
                paymentViewModel!!.networkLiveData.value = 1
            }

            africel.setOnClickListener {
                paymentViewModel!!.networkLiveData.value = 2
            }
        }


        return binding.root
    }
}


