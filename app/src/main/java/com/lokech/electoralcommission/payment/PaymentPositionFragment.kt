package com.lokech.electoralcommission.payment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.lokech.electoralcommission.R
import com.lokech.electoralcommission.databinding.PaymentPositionBinding


class PaymentPositionFragment : Fragment() {
    private val paymentViewModel: PaymentViewModel by viewModels({ requireParentFragment() })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        val binding =
            DataBindingUtil.inflate<PaymentPositionBinding>(
                inflater,
                R.layout.payment_position,
                container,
                false
            )


        binding.apply {
            president.setOnClickListener {
                goToType()
            }
            mp.setOnClickListener {
                goToType()
            }
            lc5.setOnClickListener {
                goToType()
            }
            counsellor.setOnClickListener {
                goToType()
            }
        }


        return binding.root
    }
}

fun PaymentPositionFragment.goToType() {
    val action =
        PaymentPositionFragmentDirections.actionPaymentPositionFragmentToPaymentTypeFragment()
    findNavController().navigate(action)
}