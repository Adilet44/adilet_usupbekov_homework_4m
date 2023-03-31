package com.example.adilet_usupbekov_homework_4m.ui.home

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.adilet_usupbekov_homework_4m.App
import com.example.adilet_usupbekov_homework_4m.R
import com.example.adilet_usupbekov_homework_4m.databinding.FragmentHomeBinding
import com.example.adilet_usupbekov_homework_4m.model.Task
import com.example.adilet_usupbekov_homework_4m.ui.task.adapter.Taskadapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var adapter : Taskadapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter= Taskadapter(this::onLongClick)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }
        setData()
        binding.recycleView.adapter = adapter
    }
    private fun setData(){
        val data = App.db.taskDao().getAll()
        adapter.addTask(data)
    }
    private fun onLongClick(task: Task){
        val alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.setTitle("Deleting the task")
        alertDialog.setMessage("Are you sure you want to delete this task")
        alertDialog.setNegativeButton("No"
        ) { dialog, which -> dialog?.cancel() }
        alertDialog.setPositiveButton("Yes"
        ) { dialog, which ->
            App.db.taskDao().delete(task)
            setData()
        }
        alertDialog.create().show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}