package com.lokech.electoralcommission.payment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.lokech.electoralcommission.R
import com.lokech.electoralcommission.databinding.FragmentPaymentBinding
import org.jetbrains.anko.support.v4.toast


class PaymentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        val binding =
            DataBindingUtil.inflate<FragmentPaymentBinding>(
                inflater,
                R.layout.fragment_payment,
                container,
                false
            )

        binding.mp.setOnClickListener {
            startConfirmationDialog("MP")
        }
        binding.president.setOnClickListener { startConfirmationDialog("Presidential") }
        binding.councillor.setOnClickListener {
            startConfirmationDialog("Councillor")
        }
        binding.chairman.setOnClickListener { startConfirmationDialog("LC5 Chairman") }



        return binding.root
    }
}

fun PaymentFragment.startConfirmationDialog(nominationType: String) {
    AlertDialog.Builder(requireContext())
        .setTitle("Pay for Nomination")
        .setMessage("Do you want to pay for $nominationType nomination")
        .setIcon(android.R.drawable.ic_dialog_alert)
        .setPositiveButton("Yes") { _, _ ->
            toast("Thank you for paying")
        }
        .setNegativeButton("No", null).show()
}