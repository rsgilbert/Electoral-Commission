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
import com.lokech.electoralcommission.databinding.PaymentTypeBinding


class PaymentTypeFragment : Fragment() {
    private val paymentViewModel: PaymentViewModel by viewModels({ requireParentFragment() })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        val binding =
            DataBindingUtil.inflate<PaymentTypeBinding>(
                inflater,
                R.layout.payment_type,
                container,
                false
            )


        binding.apply {
            fees.setOnClickListener {
                goToNetwork()
            }
            forms.setOnClickListener {
                goToNetwork()
            }
        }


        return binding.root
    }
}

fun PaymentTypeFragment.goToNetwork() {
    val action = PaymentTypeFragmentDirections.actionPaymentTypeFragmentToPaymentNetworkFragment()
    findNavController().navigate(action)
}