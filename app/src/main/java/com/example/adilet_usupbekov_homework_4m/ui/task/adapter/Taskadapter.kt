package com.example.adilet_usupbekov_homework_4m.ui.task.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.adilet_usupbekov_homework_4m.databinding.ItemTeskBinding
import com.example.adilet_usupbekov_homework_4m.model.Task

class Taskadapter(private val onLongClick: (Task) -> Unit): Adapter<Taskadapter.TaskViewHolder>() {
    private val data: ArrayList<Task> = arrayListOf()


    fun addTask(task: Task) {
        data.add(0, task)
        notifyItemChanged(10)
    }
    fun addTask(task:List<Task>) {
     data.clear()
        data.addAll(task)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTeskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(data[position])
    }


    inner class TaskViewHolder(private val binding: ItemTeskBinding) : ViewHolder(binding.root) {
        fun bind(task: Task) {
            binding.tvTitle.text = task.title
            binding.tvDescription.text = task.description
             itemView.setOnLongClickListener(){
                 onLongClick(task)
                 false
             }
        }

    }
}