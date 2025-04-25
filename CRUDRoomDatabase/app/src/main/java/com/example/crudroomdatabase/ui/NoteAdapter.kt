package com.example.crudroomdatabase.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.crudroomdatabase.R
import com.example.crudroomdatabase.data.Note

class NoteAdapter(
    private var notes: List<Note>,
    private val onActionClick: (Note, ActionType) -> Unit) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    enum class ActionType {
        EDIT, DELETE
    }

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        private val tvContent: TextView = itemView.findViewById(R.id.tvContent)
        private val btnEdit: ImageButton = itemView.findViewById(R.id.btnEdit)
        private val btnDelete: ImageButton = itemView.findViewById(R.id.btnDelete)

        fun bind(note: Note) {
            tvTitle.text = note.title
            tvContent.text = note.content

            btnEdit.setOnClickListener {
                onActionClick(note, ActionType.EDIT)
            }

            btnDelete.setOnClickListener {
                onActionClick(note, ActionType.DELETE)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_note, parent, false)

        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(notes[position])
    }

    override fun getItemCount(): Int = notes.size

    fun updateNotes(newNotes: List<Note>) {
        notes = newNotes
        notifyDataSetChanged()
    }
}