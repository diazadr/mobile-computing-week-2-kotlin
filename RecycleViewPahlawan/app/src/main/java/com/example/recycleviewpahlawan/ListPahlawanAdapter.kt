package com.example.recycleviewpahlawan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListPahlawanAdapter(
    // Buat variabel list
    private val listPahlawan:
    ArrayList<Pahlawan>
) :

// Deklarasiin Recycler nya ke Class ListPahlawanAdapter
    RecyclerView.Adapter<ListPahlawanAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback
    fun setOnItemClickCallback(
        onItemClickCallback:
        OnItemClickCallback
    ) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun getItemCount(): Int = listPahlawan.size

    //Buat class ListViewHolder ini tuh buat jadi Layout View Holder
    class ListViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView =
            itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView =
            itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView =
            itemView.findViewById(R.id.tv_item_description)
    }

    // Disini kita ngebuat layout nya dan ditampilin diitem_row_pahlawan
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row_pahlawan, parent, false
            )
        return ListViewHolder(view)
    }

    // Disini kita isi layout yang tadi dibuat yang diisi dari listPahlawan
    override fun onBindViewHolder(
        holder: ListViewHolder, position:
        Int
    ) {
        val (name, description, photo) = listPahlawan[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(
                listPahlawan[holder.adapterPosition]
            )
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Pahlawan)
    }
}