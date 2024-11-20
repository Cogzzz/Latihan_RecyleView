package c14220127.paba_b.latihan_recyleview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var taskAdapter: TaskAdapter
    private val tasks = mutableListOf<Task>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        recyclerView = findViewById(R.id.recyclerView)
        taskAdapter = TaskAdapter(tasks)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = taskAdapter

        val fabAddTask = findViewById<FloatingActionButton>(R.id.fabAddTask)
        fabAddTask.setOnClickListener {
            val intent = Intent(this, AddTaskActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_ADD_TASK) // Menggunakan startActivityForResult
        }
    }

    // Menangani hasil dari AddTaskActivity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_ADD_TASK && resultCode == RESULT_OK) {
            // Ambil data dari intent yang dikembalikan
            val taskName = data?.getStringExtra("taskName") ?: ""
            val taskDate = data?.getStringExtra("taskDate") ?: ""
            val taskCategory = data?.getStringExtra("taskCategory") ?: ""
            val taskDescription = data?.getStringExtra("taskDescription") ?: ""

            // Menambahkan data baru ke dalam list
            val newTask = Task(taskName, taskDate, taskCategory, taskDescription)
            tasks.add(newTask)

            // Memberitahukan adapter bahwa data baru telah ditambahkan
            taskAdapter.notifyItemInserted(tasks.size - 1)
        }
    }

    companion object {
        private const val REQUEST_CODE_ADD_TASK = 1
    }
}




