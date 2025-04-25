package com.example.daftarmahasiswa

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mahasiswaList = listOf(
            Mahasiswa("223443073", "Achmad", "achmad@gmail.com", "08123456789", "Automation Engineering", "4", "2023"),
            Mahasiswa("223443074", "Andre", "andre@gmail.com", "08123456788", "Automation Engineering", "4", "2023"),
            Mahasiswa("223443082", "Azka", "azka@gmail.com", "08123456723", "Automation Engineering", "4", "2023"),
            Mahasiswa("223443075", "Bagas", "bagas@gmail.com", "08123423798", "Automation Engineering", "4", "2023"),
            Mahasiswa("223443076", "Bayu", "bayu@gmail.com", "08123423789", "Automation Engineering", "4", "2023"),
            Mahasiswa("223443077", "Diaz", "diaz@gmail.com", "08123452389", "Automation Engineering", "4", "2023"),
            Mahasiswa("223443078", "Fahd", "fahd@gmail.com", "08123452389", "Automation Engineering", "4", "2023"),
            Mahasiswa("223443079", "Ghilman", "ghilman@gmail.com", "08123236789", "Automation Engineering", "4", "2023"),
            Mahasiswa("223443080", "Ihsan", "ihsan@gmail.com", "08123236789", "Automation Engineering", "4", "2023"),
            Mahasiswa("223443081", "Mahendra", "mahendra@gmail.com", "0812342389", "Automation Engineering", "4", "2023"),
        )

        val adapter = MahasiswaAdapter(this, mahasiswaList)
        val listView: ListView = findViewById(R.id.listMahasiswa)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val mahasiswa = mahasiswaList[position]
            val intent = Intent(this, DetailMahasiswaActivity::class.java).apply {
                putExtra("nim", mahasiswa.nim)
                putExtra("nama", mahasiswa.nama)
                putExtra("email", mahasiswa.email)
                putExtra("nomorTelepon", mahasiswa.nomorTelepon)
                putExtra("jurusan", mahasiswa.jurusan)
                putExtra("semester", mahasiswa.semester)
                putExtra("tahunAngkatan", mahasiswa.tahunAngkatan)
            }
            startActivity(intent)
        }
    }
}