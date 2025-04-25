package com.example.recycleviewpahlawan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvPahlawan: RecyclerView
    private val list = ArrayList<Pahlawan>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvPahlawan = findViewById(R.id.rv_pahlawan)
        rvPahlawan.setHasFixedSize(true)
        list.addAll(getListPahlawan())
        showRecyclerList()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // ini buat layout manager
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvPahlawan.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvPahlawan.layoutManager = GridLayoutManager(this, 2)
            }
        }
        return super.onOptionsItemSelected(item)
    }


    private fun getListPahlawan(): ArrayList<Pahlawan> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription =
            resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listPahlawan = ArrayList<Pahlawan>()
        for (i in dataName.indices) {
            val pahlawan = Pahlawan(dataName[i], dataDescription[i],
                dataPhoto.getResourceId(i, -1))
            listPahlawan.add(pahlawan)
        }
        return listPahlawan
    }


    private fun showRecyclerList() {
        rvPahlawan.layoutManager = LinearLayoutManager(this)
        val listPahlawanAdapter = ListPahlawanAdapter(list)
        rvPahlawan.adapter = listPahlawanAdapter
        listPahlawanAdapter.setOnItemClickCallback(object :
            ListPahlawanAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Pahlawan) {
                showSelectedPahlawan(data)
            }
        })
    }

    // ini mah buat notif toast
    private fun showSelectedPahlawan(pahlawan: Pahlawan) {
        Toast.makeText(this, "Kamu memilih " + pahlawan.name,
            Toast.LENGTH_SHORT).show()
    }
}