package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.todoapp.NoteUi.NoteFragment
import com.example.todoapp.R
import com.example.todoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by lazy { ViewModelMain(Dependencies.toDoRepository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        Dependencies.init(applicationContext)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
        binding.addIcon.setOnClickListener { addIconPressed() }

        if (savedInstanceState == null) {
            val fragment = NoteFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
        }
    }

    private fun addIconPressed() {
        if (binding.editTextId.text.toString().isNotBlank()) {
            viewModel.insertNewToDoNote(
                binding.editTextId.text.toString()
            )
            binding.editTextId.setText("")

            Toast.makeText(this, "Данные были успешно вставлены в таблицу!", Toast.LENGTH_SHORT)
                .show()
        }
        else Toast.makeText(this, "Ошибка внесения в таблицу", Toast.LENGTH_SHORT)
            .show()
    }
}
