package com.example.adilet_usupbekov_homework_4m.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.adilet_usupbekov_homework_4m.App
import com.example.adilet_usupbekov_homework_4m.R
import com.example.adilet_usupbekov_homework_4m.databinding.FragmentTaskBinding
import com.example.adilet_usupbekov_homework_4m.model.Task

class TaskFragment : Fragment() {
  private lateinit var binding: FragmentTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding=FragmentTaskBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            if (binding.etTitle.text.isNotEmpty()){
                save()
            }else binding.etTitle.error = "Это поле обязательна для заполнения "

        }
    }

    private fun save() {
        val data = Task(title = binding.etTitle.text.toString(),
            description = binding.etDescription.text.toString())
        App.db.taskDao().insert(data)
        findNavController().navigateUp()
    }


}


