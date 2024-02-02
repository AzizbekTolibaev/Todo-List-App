package com.example.todolistapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.todolistapp.data.TaskData
import com.example.todolistapp.databinding.ItemTaskBinding

class TaskAdapter: ListAdapter<TaskData, TaskAdapter.TaskViewHolder>(myDiffUtil) {

    private var onEditClickListener: ((TaskData) -> Unit)? = null
    private var onDeleteClickListener: ((TaskData) -> Unit)? = null
    private var onCompletedClickListener: ((TaskData) -> Unit)? = null

    fun setOnEditClickListener(block: (TaskData) -> Unit) {
        onEditClickListener = block
    }

    fun setOnDeleteClickListener(block: (TaskData) -> Unit) {
        onDeleteClickListener = block
    }

    fun setOnCompletedClickListener(block: (TaskData) -> Unit) {
        onCompletedClickListener = block
    }

    inner class TaskViewHolder(private val binding: ItemTaskBinding): ViewHolder(binding.root) {
        fun bind(position: Int) {
            with(binding) {
                val d = getItem(position)
                tvTitle.text = d.title
                tvDetail.text = d.detail

                btnEdit.setOnClickListener {
                    onEditClickListener?.invoke(d)
                }

                btnDelete.setOnClickListener {
                    onDeleteClickListener?.invoke(d)
                }

                btnCompleted.setOnClickListener {
                    onCompletedClickListener?.invoke(d)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(position)
    }

    private object myDiffUtil: DiffUtil.ItemCallback<TaskData>() {
        override fun areItemsTheSame(oldItem: TaskData, newItem: TaskData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: TaskData, newItem: TaskData): Boolean {
            return oldItem.id == newItem.id
        }
    }
}
