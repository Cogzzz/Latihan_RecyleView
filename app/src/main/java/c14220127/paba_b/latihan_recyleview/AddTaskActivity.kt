package c14220127.paba_b.latihan_recyleview

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class AddTaskActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.form_task)

        val etTaskName: EditText = findViewById(R.id.etTaskName)
        val etDate: EditText = findViewById(R.id.etDate)
        val etCategory: EditText = findViewById(R.id.etCategory)
        val etDescription: EditText = findViewById(R.id.etDescription)
        val btnSave: Button = findViewById(R.id.btnSave)

        btnSave.setOnClickListener {
            val intent = Intent().apply {
                putExtra("taskName", etTaskName.text.toString())
                putExtra("taskDate", etDate.text.toString())
                putExtra("taskCategory", etCategory.text.toString())
                putExtra("taskDescription", etDescription.text.toString())
            }
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}