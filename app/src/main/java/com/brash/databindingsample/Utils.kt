package com.brash.databindingsample

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("image")
fun ImageView.setImageUrl(url: String?) {
  Picasso.get().load(url).into(this)
}
