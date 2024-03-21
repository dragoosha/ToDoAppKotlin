package com.example.todoapp.NoteUi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.todoapp.Dependencies
import com.example.todoapp.R
import com.example.todoapp.ViewModelMain
import com.example.todoapp.databinding.ActivityMainBinding
import com.example.todoapp.databinding.FragmentNoteBinding


class NoteFragment : Fragment(), NoteListener {

    private lateinit var binding: FragmentNoteBinding
    private val viewModel by lazy { ViewModelNote(Dependencies.toDoRepository) }

    private val adapter by lazy { NoteAdapter(this) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteBinding.inflate(layoutInflater, null, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(), VERTICAL, false)
        viewModel.notes.observe(viewLifecycleOwner) {
            adapter.data = it

        }
    }


    override fun removeNote(id: Long) {
        viewModel.remoteData(id)
    }
}