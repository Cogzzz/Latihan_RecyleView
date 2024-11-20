package c14220127.paba_b.latihan_recyleview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Task(
    val name: String,
    val date: String,
    val category: String,
    val description: String
) : Parcelable
