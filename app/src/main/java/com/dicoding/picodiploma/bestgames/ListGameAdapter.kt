package com.dicoding.picodiploma.bestgames

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ListGameAdapter(private val listGame: ArrayList<Game>) : RecyclerView.Adapter<ListGameAdapter.ListViewHolder>() {


    override fun getItemCount(): Int = listGame.size


    //fungsi untuk inisiasi variabel untuk memuat data dari layout_list
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_games_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_games_description)
        val tvRating: TextView = itemView.findViewById(R.id.tv_games_rating)
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    //fungsi untuk memberi tempat untuk data dari layout list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.layout_list, parent, false)
        return ListViewHolder(view)
    }


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        val (name, description, rating, photo) = listGame[position]
        //berurutan sesuai dengan Arraylist<Game>. artinya inisialisasi variabel diatas tidak sembarangan. inisialisasi wajib mengikuti urutan dari arraylist
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.tvRating.text = rating
        holder.imgPhoto.setImageResource(photo)


        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("key_game", listGame[holder.adapterPosition])
//            intentDetail.putExtra("key_game", listGame[holder.adapterPosition].name)
            holder.itemView.context.startActivity(intentDetail)
        }


    }


}
