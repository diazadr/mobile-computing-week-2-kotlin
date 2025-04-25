package com.example.crudroomdatabase.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crudroomdatabase.R
import com.example.crudroomdatabase.data.Note

/**
 * MainActivity merupakan aktivitas utama yang menampilkan daftar catatan (notes).
 * Pengguna dapat menambah, mengedit, dan menghapus catatan melalui UI ini.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var noteViewModel: NoteViewModel
    private lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
        setupViewModel()
        setupAddButton()
    }

    /**
     * Menginisialisasi RecyclerView dan adapter untuk menampilkan daftar notes.
     */
    private fun setupRecyclerView() {
        val rvNotes: RecyclerView = findViewById(R.id.rvNotes)
        adapter = NoteAdapter(emptyList()) { note, action ->
            when (action) {
                NoteAdapter.ActionType.EDIT -> showNoteDialog(note)
                NoteAdapter.ActionType.DELETE -> noteViewModel.delete(note)
            }
        }
        rvNotes.adapter = adapter

        rvNotes.adapter = adapter
        rvNotes.layoutManager = LinearLayoutManager(this)
    }

    /**
     * Menginisialisasi ViewModel dan mengamati perubahan data pada daftar notes.
     */
    private fun setupViewModel() {
        noteViewModel = ViewModelProvider(this)[NoteViewModel::class.java]
        noteViewModel.allNotes.observe(this) { notes ->
            adapter.updateNotes(notes)
        }
    }

    /**
     * Menyiapkan tombol untuk menambah catatan baru.
     */
    private fun setupAddButton() {
        findViewById<Button>(R.id.btnAdd).setOnClickListener {
            showNoteDialog(null)
        }
    }

    /**
     * Menampilkan dialog untuk menambah atau mengedit catatan.
     * @param note Catatan yang akan diedit, null jika menambah baru.
     */
    private fun showNoteDialog(note: Note?) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_note, null)
        val etTitle: EditText = dialogView.findViewById(R.id.etTitle)
        val etContent: EditText = dialogView.findViewById(R.id.etContent)

        note?.let {
            etTitle.setText(it.title)
            etContent.setText(it.content)
        }

        AlertDialog.Builder(this)
            .setTitle(if (note == null) "Tambah Note" else "Edit Note")
            .setView(dialogView)
            .setPositiveButton("Simpan") { _, _ ->
                val title = etTitle.text.toString()
                val content = etContent.text.toString()
                if (note == null) {
                    noteViewModel.insert(Note(title = title, content = content))
                } else {
                    noteViewModel.update(note.copy(title = title, content = content))
                }
            }
            .setNegativeButton("Batal", null)
            .show()
    }
}