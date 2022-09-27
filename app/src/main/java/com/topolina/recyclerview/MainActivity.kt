package com.topolina.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.topolina.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var b: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        val view = b.root
        setContentView(view)

        var todoItems = mutableListOf<Todo>(
            Todo("be shit", true),
            Todo("something", false),
            Todo("something else", false),
            Todo("something else x2", false),
            Todo("something else x3", false),
        )

        val adapter = TodoAdapter(todoItems)
        b.rvTodos.adapter = adapter
        b.rvTodos.layoutManager = LinearLayoutManager(this)

        b.btnApply.setOnClickListener {
            val title   = b.tvTodo.text.toString()
            val newTodo = Todo(title, false)
            b.tvTodo.text = null
            todoItems.add(newTodo)
            adapter.notifyItemInserted(todoItems.size - 1)
        }

    }
}