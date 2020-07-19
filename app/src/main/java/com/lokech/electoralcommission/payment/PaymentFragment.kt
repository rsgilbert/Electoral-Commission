package com.lokech.electoralcommission.payment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.lokech.electoralcommission.R
import com.lokech.electoralcommission.databinding.DialogEditBinding
import com.lokech.electoralcommission.databinding.FragmentPaymentBinding
import org.jetbrains.anko.support.v4.toast


class PaymentFragment : Fragment() {
    val paymentViewModel: PaymentViewModel by viewModels()

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


        binding.paymentViewModel = paymentViewModel
        binding.apply {
            lifecycleOwner = viewLifecycleOwner

            positionSection.setOnClickListener { startPositionDialog() }
            typeSection.setOnClickListener { startTypeDialog() }
            networkSection.setOnClickListener { startNetworkDialog() }
            numberSection.setOnClickListener { startNumberDialog() }




            btnSubmit.setOnClickListener {
                toast("Submitted")
            }
        }


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

fun PaymentFragment.startPositionDialog() {
    val positions = arrayOf("President", "Member of Parliament", "LC5 Chairman", "Counsellor")
    AlertDialog.Builder(requireContext())
        .setTitle("Title")
        .setItems(positions) { _, which ->
            paymentViewModel.paymentLiveData.value =
                paymentViewModel.paymentLiveData.value!!.copy(position = positions[which])
        }
        .show()
}

fun PaymentFragment.startTypeDialog() {
    val positions = arrayOf("Nomination Fees", "Form Fees")
    AlertDialog.Builder(requireContext())
        .setTitle("Type")
        .setItems(positions) { _, which ->
            paymentViewModel.paymentLiveData.value =
                paymentViewModel.paymentLiveData.value!!.copy(type = positions[which])
        }
        .show()
}

fun PaymentFragment.startNetworkDialog() {
    val positions = arrayOf("Airtel Money", "MTN Mobile Money")
    AlertDialog.Builder(requireContext())
        .setTitle("Network")
        .setItems(positions) { _, which ->
            paymentViewModel.paymentLiveData.value =
                paymentViewModel.paymentLiveData.value!!.copy(network = positions[which])
        }
        .show()
}

fun PaymentFragment.startNumberDialog() {
    val binding = DialogEditBinding.inflate(LayoutInflater.from(context))

    binding.apply {

    }



    AlertDialog.Builder(requireContext())
        .setTitle("Phone Number")
        .setView(binding.root)
        .setPositiveButton("Save") { _, _ ->
            paymentViewModel.paymentLiveData.value =
                paymentViewModel.paymentLiveData.value!!.copy(number = binding.editText.text.toString())
        }
        .show()
}