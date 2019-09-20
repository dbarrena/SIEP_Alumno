package com.dbxprts.siepalumno.adapters.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dbxprts.siepalumno.R
import com.dbxprts.siepalumno.model.DashboardItem
import kotlinx.android.synthetic.main.list_item_dashboard.view.*

class DashboardRecyclerViewAdapter(
    val context: Context,
    private val items: ArrayList<DashboardItem>
) : RecyclerView.Adapter<DashboardRecyclerViewAdapter.ViewHolder>() {
    var listener: ItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_dashboard, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dashboardItem = items[position]
        holder.bind(dashboardItem)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.title
        val subtitle: TextView = view.subtitle

        fun bind(item: DashboardItem) {
            title.text = item.title
            subtitle.text = item.subtitle
        }
    }

    interface ItemClickListener {
        fun onItemClick(dashboardItem: DashboardItem)
    }
}