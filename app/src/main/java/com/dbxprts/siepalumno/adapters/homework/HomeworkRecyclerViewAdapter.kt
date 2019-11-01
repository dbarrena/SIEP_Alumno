package com.dbxprts.siepalumno.adapters.homework

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.dbxprts.siepalumno.R
import com.dbxprts.siepalumno.model.Homework
import kotlinx.android.synthetic.main.list_item_homework.view.*

class HomeworkRecyclerViewAdapter(
    val context: Context,
    private val items: ArrayList<Homework>
) : RecyclerView.Adapter<HomeworkRecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_homework, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val truckService = items[position]
        holder.bind(truckService)
    }

    fun addItem(item: Homework) {
        items.add(item)
        notifyItemInserted(items.size - 1)
        notifyDataSetChanged()
    }

    fun addAllItems(newItems: ArrayList<Homework>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    fun removeAt(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, items.size)
    }

    fun clearAll() {
        items.clear()
    }

    fun getAllItems(): ArrayList<Homework> {
        return items
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val content: ConstraintLayout = view.content
        val decorator: View = view.decorator
        val schoolSubject: TextView = view.schoolSubject
        val deliverDate: TextView = view.deliverDate
        val homeworkDescription: TextView = view.homework

        fun bind(homework: Homework) {
            schoolSubject.text = homework.schoolSubject.name
            deliverDate.text = homework.deliverDate.toString()
            homeworkDescription.text = homework.homework
        }
    }
}