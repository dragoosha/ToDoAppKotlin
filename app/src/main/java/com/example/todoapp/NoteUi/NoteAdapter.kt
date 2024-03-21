package com.example.todoapp.NoteUi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.databinding.ItemNoteBinding
import com.example.todoapp.db.ToDoDatabase.TodoInfoTuple

class NoteDiffUtil (
    private val oldList: List<TodoInfoTuple>,
    private val newList: List<TodoInfoTuple>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {return oldList.size}

    override fun getNewListSize(): Int {return newList.size}

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]

        return oldItem.id == newItem.id    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]

        return oldItem == newItem    }
}

interface NoteListener {
    fun removeNote(id : Long)
}

class NoteAdapter (private val noteListener: NoteListener) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>(), View.OnClickListener{

    var data : List<TodoInfoTuple> = emptyList()
        set(newValue) {
            val diffUtil = NoteDiffUtil(field, newValue)
            val diffUtilResult = DiffUtil.calculateDiff(diffUtil)
            field = newValue
            diffUtilResult.dispatchUpdatesTo(this@NoteAdapter)
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNoteBinding.inflate(inflater, parent, false)
        binding.deleteIcon.setOnClickListener(this)

        return NoteViewHolder(binding)
    }


    override fun getItemCount(): Int {return data.size}

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = data[position]

        with(holder.binding) {
            deleteIcon.tag = note

            NoteTextView.text = note.textNote

            if (note.statusNote == true)
                image.imageTintList = ContextCompat.getColorStateList(root.context, R.color.green)
        }
    }


    override fun onClick(view: View?) {
        val note = view?.tag as TodoInfoTuple

        noteListener.removeNote(note.id)
    }


    class NoteViewHolder(val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
}