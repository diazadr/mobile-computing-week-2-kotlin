package com.example.listview

import android.os.Bundle
import android.widget.AdapterView
import android.widget.AdapterView.OnItemLongClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var adapterMatakuliah: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val listMahasiswa = findViewById<ListView>(R.id.listMahasiswa)
        val mahasiswa = listOf(
            "Andi",
            "Budi",
            "Citra",
            "Dina",
            "Diaz",
            "Ahmad",
            "Andre",
            "Azka",
            "Bagas",
            "Bayu"
        )

        val listMatakuliah = findViewById<ListView>(R.id.listMatakuliah)
        val matakuliah = mutableListOf(
            "Pemrograman",
            "Basis Data",
            "Jaringan Komputer",
            "Mobile App",
            "Komputasi Bergerak",
            "Sistem Operasi",
            "Sistem Tertanam",
            "IIoT",
            "Matematika Distrik",
            "Sistem Inteligen"
        )

        val listDosen = findViewById<ListView>(R.id.listDosen)
        val dosen = mutableListOf(
            "Pak Adi",
            "Bu Rini",
            "Pak Rudi",
            "Bu Tika",
            "Mas Harry",
            "Bu Siti",
            "Mas Ega",
            "Mas Bagas",
            "Mas Adit",
            "Mas Ruminto",
            "Mas Sarosa"
        )

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mahasiswa)
        listMahasiswa.adapter = adapter

        adapterMatakuliah = ArrayAdapter(this, android.R.layout.simple_list_item_1, matakuliah)
        listMatakuliah.adapter = adapterMatakuliah

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dosen)
        listDosen.adapter = adapter


        listMahasiswa.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "Anda memilih: ${mahasiswa[position]}", Toast.LENGTH_SHORT).show()
        }

        listMatakuliah.setOnItemLongClickListener { parent, view, position, id ->
            val item = matakuliah[position]
            matakuliah.removeAt(position)
            adapterMatakuliah.notifyDataSetChanged()
            Toast.makeText(this, "Anda menghapus: $item", Toast.LENGTH_SHORT).show()
            true
        }

//      lv_languages.choiceMode = ListView.CHOICE_MODE_MULTIPLE
//      val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, languages)
//      lv_languages.adapter = adapter
//
//      lv_languages.choiceMode = ListView.CHOICE_MODE_SINGLE
//      val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, languages)
//      lv_languages.adapter = adapter

    }
}