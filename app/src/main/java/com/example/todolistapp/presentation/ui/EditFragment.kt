package com.example.todolistapp.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.todolistapp.R
import com.example.todolistapp.data.TaskData
import com.example.todolistapp.databinding.FragmentEditBinding
import com.example.todolistapp.presentation.viewModel.UpdateTaskViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class EditFragment: Fragment(R.layout.fragment_edit) {
    private lateinit var binding: FragmentEditBinding
    private val args by navArgs<EditFragmentArgs>()
    private val viewModel by viewModel<UpdateTaskViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEditBinding.bind(view)

        setupData()
        setupListeners()
    }

    private fun setupListeners() {
        with(binding) {
            btnUpdate.setOnClickListener {
                val title = etTitle.text.toString().trim()
                val detail = etDetail.text.toString().trim()

                lifecycleScope.launch {
                    viewModel.updateTask(TaskData(args.id, title, detail))
                }
                findNavController().popBackStack()
            }

            btnBack.setOnClickListener {
                findNavController().popBackStack()
            }

            btnCancel.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun setupData() {
        with(binding) {
            etTitle.setText(args.title)
            etDetail.setText(args.detail)
        }
    }
}
