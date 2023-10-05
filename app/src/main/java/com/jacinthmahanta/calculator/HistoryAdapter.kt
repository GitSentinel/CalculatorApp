package com.jacinthmahanta.calculator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HistoryAdapter(
    private val listHistory: ArrayList<String>
): RecyclerView.Adapter<HistoryAdapter.ListViewHolder>() {

    class ListViewHolder(outcomeView: View): RecyclerView.ViewHolder(outcomeView) {
        val tvHistory: TextView = itemView.findViewById(R.id.tv_history)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.row_history,
                    parent,
                    false
                )
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listHistory.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val history = listHistory[position]

        holder.tvHistory.text = history
    }
}