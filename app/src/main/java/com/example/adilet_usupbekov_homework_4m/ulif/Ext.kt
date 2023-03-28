package com.example.adilet_usupbekov_homework_4m.ulif

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun  ImageView.loadImage (url: String?){
 Picasso.get().load(url).into(this)
}