package com.example.recycleviewpahlawan

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Pahlawan(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable