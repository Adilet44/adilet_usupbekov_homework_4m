package com.example.adilet_usupbekov_homework_4m.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.adilet_usupbekov_homework_4m.data.local.Pref
import com.example.adilet_usupbekov_homework_4m.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private lateinit var pref:Pref

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref=Pref(requireContext())
        binding.etAny.setText(pref.getAnyText())
        binding.btnSave.setOnClickListener{
        pref.saveAnyText(binding.etAny.text.toString())
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}