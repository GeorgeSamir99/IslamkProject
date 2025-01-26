package com.example.islamk.home.model


import kotlinx.parcelize.Parcelize
import android.os.Parcelable
@Parcelize
data class Chapter(
    val titleEn : String? = null,
    val titleAr : String? = null ,
    val lengthVerses:String? = null,
    val order : Int? = null
) :Parcelable
