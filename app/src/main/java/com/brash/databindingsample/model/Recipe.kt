package com.brash.databindingsample.model

import com.google.gson.annotations.SerializedName

data class Recipe (val title: String, @SerializedName("thumbnail") val image: String, val ingredients: String)