package com.example.daftarmahasiswa

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailMahasiswaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       
        setContentView(R.layout.activity_detail_mahasiswa)

        val nim = intent.getStringExtra("nim")
        val nama = intent.getStringExtra("nama")
        val email = intent.getStringExtra("email")
        val nomorTelepon = intent.getStringExtra("nomorTelepon")
        val jurusan = intent.getStringExtra("jurusan")
        val semester = intent.getStringExtra("semester")
        val tahunAngkatan = intent.getStringExtra("tahunAngkatan")

        findViewById<TextView>(R.id.nimDetailTextView).text = "NIM: ${nim}"
        findViewById<TextView>(R.id.namaDetailTextView).text = "Nama: ${nama}"
        findViewById<TextView>(R.id.emailDetailTextView).text = "Email: ${email}"
        findViewById<TextView>(R.id.nomorTeleponDetailTextView).text = "Nomor Telepon: ${nomorTelepon}"
        findViewById<TextView>(R.id  .jurusanDetailTextView).text = "Jurusan: ${jurusan}"
        findViewById<TextView>(R.id.semesterDetailTextView).text = "Semester: ${semester}"
        findViewById<TextView>(R.id.tahunAngkatanDetailTextView).text = "Tahun Angkatan: ${tahunAngkatan}"
    }
}