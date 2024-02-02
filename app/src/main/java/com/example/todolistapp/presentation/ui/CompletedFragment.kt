package com.example.todolistapp.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.todolistapp.R
import com.example.todolistapp.data.TaskData
import com.example.todolistapp.databinding.FragmentCompletedBinding
import com.example.todolistapp.presentation.adapter.CompletedTaskAdapter
import com.example.todolistapp.presentation.adapter.TaskAdapter
import com.example.todolistapp.presentation.viewModel.AllCompletedTaskViewModel
import com.example.todolistapp.presentation.viewModel.DeleteCompletedTaskViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CompletedFragment: Fragment(R.layout.fragment_completed) {
    private lateinit var binding: FragmentCompletedBinding
    private val adapter = CompletedTaskAdapter()
    private val allCompletedTasksViewModel by viewModel<AllCompletedTaskViewModel>()
    private val deleteCompletedTaskViewModel by viewModel<DeleteCompletedTaskViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCompletedBinding.bind(view)

        setupData()
        setupObservers()
        setupListeners()

    }

    private fun setupObservers() {
        allCompletedTasksViewModel.getAllCompletedTasksLivedata.observe(requireActivity()) {
            with(binding) {
                if (it.toMutableList().isNotEmpty()) {
                    recyclerView.visibility = View.VISIBLE
                    tvNoCompletedTasks.visibility = View.GONE
                    adapter.submitList(it)
                } else {
                    recyclerView.visibility = View.GONE
                    tvNoCompletedTasks.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun setupListeners() {
        with(binding) {

            btnBack.setOnClickListener {
                findNavController().popBackStack()
            }

            adapter.setOnDeleteClickListener {
                lifecycleScope.launch {
                    deleteCompletedTaskViewModel.deleteCompletedTask(it)
                    allCompletedTasksViewModel.getAllCompletedTasks()
                }
            }
        }
    }

    private fun setupData() {
        binding.recyclerView.adapter = adapter

        lifecycleScope.launch {
            allCompletedTasksViewModel.getAllCompletedTasks()
        }
    }
}
