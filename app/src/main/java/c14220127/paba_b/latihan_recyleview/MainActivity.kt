package c14220127.paba_b.latihan_recyleview

import android.app.Activity
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

        val fabAddTask = findViewById<FloatingActionButton>(R.id.fabAddTask)
        fabAddTask.setOnClickListener {
            val intent = Intent(this, AddTaskActivity::class.java)
            startActivity(intent)
        }

        recyclerView = findViewById(R.id.recyclerView)
        taskAdapter = TaskAdapter(tasks)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = taskAdapter

    }
}


