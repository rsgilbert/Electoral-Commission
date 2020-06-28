package com.lokech.electoralcommission.parties


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lokech.electoralcommission.data.Party
import com.lokech.electoralcommission.databinding.PartyItemBinding

class PartyListAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<Party, PartyListAdapter.ViewHolder>(ItemDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val party: Party = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(party)
        }
        holder.bind(party)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder.from(parent)

    class ViewHolder private constructor(private val binding: PartyItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(party: Party) {
            binding.party = party
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = PartyItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class OnClickListener(val clickListener: (party: Party) -> Unit) {
        fun onClick(party: Party) = clickListener(party)
    }
}

class ItemDiffCallback : DiffUtil.ItemCallback<Party>() {
    override fun areItemsTheSame(
        oldParty: Party, newParty
        : Party
    ) =
        oldParty.id == newParty.id

    override fun areContentsTheSame(
        oldParty: Party, newParty
        : Party
    ) =
        oldParty == newParty
}
