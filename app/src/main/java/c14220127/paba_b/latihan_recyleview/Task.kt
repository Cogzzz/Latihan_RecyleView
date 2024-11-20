package c14220127.paba_b.latihan_recyleview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Task(
    val name: String,
    val date: String,
    val category: String,
    val description: String,
    var isInProgress: Boolean = false, // false: belum dikerjakan, true: sedang dikerjakan
    var isCompleted: Boolean = false // false: belum selesai, true: sudah selesai
) : Parcelable
