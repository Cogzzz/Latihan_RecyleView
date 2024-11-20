package c14220127.paba_b.latihan_recyleview

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddTaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.form_task)

        val etTaskName: EditText = findViewById(R.id.etTaskName)
        val etDate: EditText = findViewById(R.id.etDate)
        val etCategory: EditText = findViewById(R.id.etCategory)
        val etDescription: EditText = findViewById(R.id.etDescription)
        val btnSave: Button = findViewById(R.id.btnSave)

        btnSave.setOnClickListener {
            val name = etTaskName.text.toString()
            val date = etDate.text.toString()
            val category = etCategory.text.toString()
            val description = etDescription.text.toString()

            if (name.isNotEmpty() && date.isNotEmpty() && category.isNotEmpty() && description.isNotEmpty()) {
                val task = Task(name, date, category, description)

                // Kirim data kembali ke MainActivity
                val intent = Intent()
                intent.putExtra("EXTRA_TASK", task)
                setResult(Activity.RESULT_OK, intent)
                finish()
            } else {
                Toast.makeText(this, "Harap isi semua bidang!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}