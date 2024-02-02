package com.example.todolistapp.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.todolistapp.R
import com.example.todolistapp.data.CompletedTaskData
import com.example.todolistapp.data.TaskData
import com.example.todolistapp.databinding.FragmentHomeBinding
import com.example.todolistapp.presentation.adapter.TaskAdapter
import com.example.todolistapp.presentation.viewModel.AddCompletedTaskViewModel
import com.example.todolistapp.presentation.viewModel.AllTasksViewModel
import com.example.todolistapp.presentation.viewModel.DeleteTaskViewModel
import com.example.todolistapp.utils.snackBar
import com.example.todolistapp.utils.toastMessage
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment: Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
    private val adapter = TaskAdapter()
    private val allTasksViewModel by viewModel<AllTasksViewModel>()
    private val deleteTaskViewModel by viewModel<DeleteTaskViewModel>()
    private val addCompletedTaskViewModel by viewModel<AddCompletedTaskViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)


        setupData()
        setupListeners()
        setupObservers()

    }

    private fun setupListeners() {
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addFragment)
        }

        binding.btnCompleted.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_completedFragment)
        }

        adapter.setOnEditClickListener {

            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToEditFragment(it.id, it.title, it.detail))
        }

        adapter.setOnDeleteClickListener {
            lifecycleScope.launch {
                deleteTaskViewModel.deleteTask(it)
                allTasksViewModel.getAllTasks()
            }
        }

        adapter.setOnCompletedClickListener {
            lifecycleScope.launch {
                addCompletedTaskViewModel.addCompletedTask(CompletedTaskData(0, it.title, it.detail))
                deleteTaskViewModel.deleteTask(it)
                allTasksViewModel.getAllTasks()
            }
        }
    }

    private fun setupData() {
        binding.recyclerView.adapter = adapter

        lifecycleScope.launch {
            allTasksViewModel.getAllTasks()
        }
    }

    private fun setupObservers() {
        allTasksViewModel.getAllTasksLiveData.observe(requireActivity()) {
            with(binding) {
                if (it.toMutableList().isNotEmpty()) {
                    recyclerView.visibility = View.VISIBLE
                    tvNoTasks.visibility = View.GONE
                    adapter.submitList(it)
                } else {
                    recyclerView.visibility = View.GONE
                    tvNoTasks.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            allTasksViewModel.getAllTasks()
        }
    }
}
