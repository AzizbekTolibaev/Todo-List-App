package com.example.todolistapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistapp.data.CompletedTaskData
import com.example.todolistapp.data.TaskData
import com.example.todolistapp.databinding.ItemCompletedTaskBinding
import com.example.todolistapp.databinding.ItemTaskBinding

class CompletedTaskAdapter: ListAdapter<CompletedTaskData, CompletedTaskAdapter.CompletedTaskViewHolder>(myDiffUtil) {

    private var onDeleteClickListener: ((CompletedTaskData) -> Unit)? = null

    fun setOnDeleteClickListener(block: (CompletedTaskData) -> Unit) {
        onDeleteClickListener = block
    }

    inner class CompletedTaskViewHolder(private val binding: ItemCompletedTaskBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            with(binding) {
                val d = getItem(position)
                tvTitle.text = d.title
                tvDetail.text = d.detail

                btnDelete.setOnClickListener {
                    onDeleteClickListener?.invoke(d)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompletedTaskViewHolder {
        return CompletedTaskViewHolder(
            ItemCompletedTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CompletedTaskViewHolder, position: Int) {
        holder.bind(position)
    }

    private object myDiffUtil: DiffUtil.ItemCallback<CompletedTaskData>() {
        override fun areItemsTheSame(oldItem: CompletedTaskData, newItem: CompletedTaskData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CompletedTaskData, newItem: CompletedTaskData): Boolean {
            return oldItem.id == newItem.id
        }
    }
}