package com.example.adilet_usupbekov_homework_4m.ui.profile

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult
import androidx.core.widget.addTextChangedListener
import com.example.adilet_usupbekov_homework_4m.R
import com.example.adilet_usupbekov_homework_4m.data.local.Pref
import com.example.adilet_usupbekov_homework_4m.databinding.FragmentProfileBinding
import com.example.adilet_usupbekov_homework_4m.ulif.loadImage


class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var pref: Pref


    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK && it.data != null) {
                val uri: Uri? = it.data?.data
                pref.setImage(uri.toString())
                binding.ivProfile.loadImage(uri.toString())
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = Pref(requireContext())
        saveName()
        saveImage()
    }

    private fun saveImage() {
        binding.ivProfile.loadImage(pref.getImage())
        binding.ivProfile.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            launcher.launch(intent)
        }
    }
    private fun saveName() {
        binding.etName.setText(pref.getUser())
        binding.etName.addTextChangedListener {
            pref.setUser(binding.etName.text.toString())
        }
    }
}