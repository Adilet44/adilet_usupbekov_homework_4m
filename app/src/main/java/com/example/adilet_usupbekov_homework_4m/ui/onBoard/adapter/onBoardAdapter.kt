package com.example.adilet_usupbekov_homework_4m.ui.onBoard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.adilet_usupbekov_homework_4m.databinding.ItemOnboardingBinding
import com.example.adilet_usupbekov_homework_4m.model.onBoard
import com.example.adilet_usupbekov_homework_4m.ulif.loadImage

class onBoardAdapter(private val onClick: () -> Unit) :
    Adapter<onBoardAdapter.onBoardViewHolder>() {

    private val data = arrayListOf<onBoard>(
        onBoard(
            "https://www.cflowapps.com/wp-content/uploads/2021/12/diffnce_job_task_process.jpeg",
            "Task Manager1", "Task Manager description1"
        ),
        onBoard(
            "https://merriam-webster.com/assets/mw/images/article/art-wap-article-main/can-task-be-a-verb-5813-7075c71d8cf734c3c83e9edf76bc66fb@1x.jpg",
            "Task Manager2", "Task Manager description2"
        ),
        onBoard(
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR6kcS4NLkJI0C4npOcIooYDxM9snr6zPn4wA&usqp=CAU",
            "Task Manager3", "Task Manager description3"
        ),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): onBoardViewHolder {
        return onBoardViewHolder(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: onBoardViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class onBoardViewHolder(private val binding: ItemOnboardingBinding) :
        ViewHolder(binding.root) {

        fun bind(onBoard: onBoard) {
            binding.tvTitle.text = onBoard.title
            binding.tvDescription.text = onBoard.description
            binding.imgOnboard.loadImage(onBoard.image)
            binding.tvSkip.isVisible = adapterPosition != 2
            binding.start.isVisible = adapterPosition == 2
            binding.tvSkip.setOnClickListener {
                onClick()
            }
            binding.start.setOnClickListener {
                onClick()
            }
        }

    }

}