package com.example.daftarmahasiswa

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class MahasiswaAdapter(
    private val context: Context,
    private val mahasiswaList: List<Mahasiswa>

) : ArrayAdapter<Mahasiswa>(context, 0, mahasiswaList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val mahasiswa = getItem(position)
        val listItemView = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.list_item_mahasiswa, parent, false)

        val nimTextView = listItemView.findViewById<TextView>(R.id.nimTextView)
        nimTextView.text = mahasiswa?.nim
        val namaTextView = listItemView.findViewById<TextView>(R.id.namaTextView)
        namaTextView.text = mahasiswa?.nama

        return listItemView
    }
}