package com.example.todolistapp.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.todolistapp.R
import com.example.todolistapp.data.TaskData
import com.example.todolistapp.databinding.FragmentAddBinding
import com.example.todolistapp.presentation.viewModel.AddTaskViewModel
import com.example.todolistapp.utils.toastMessage
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddFragment: Fragment(R.layout.fragment_add) {
    private lateinit var binding: FragmentAddBinding
    private val viewModel by viewModel<AddTaskViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAddBinding.bind(view)


        setupListeners()

    }

    private fun setupListeners() {
        with(binding) {
            btnBack.setOnClickListener {
                findNavController().popBackStack()
            }

            btnAdd.setOnClickListener {
                val title = etTitle.text.toString().trim()
                val detail = etDetail.text.toString().trim()

                if (title.isNotEmpty() && detail.isNotEmpty()) {
                    lifecycleScope.launch {
                        viewModel.addTask(TaskData(0, title, detail))
                    }
                    findNavController().popBackStack()
                } else {
                    toastMessage("Enter the information")
                }
            }
        }
    }
}
