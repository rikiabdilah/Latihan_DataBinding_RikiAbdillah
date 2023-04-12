package com.example.latihan_databinding_rikiabdillah

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.latihan_databinding_rikiabdillah.databinding.ActivityDetailNewsBinding
import com.example.latihan_databinding_rikiabdillah.databinding.ItemNewsBinding

class NewsAdapter(var listNews: ArrayList<ListNews>):
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    //method onClick berfungsi saat cardView di klik pindah halaman ke detail
    var onClick:((ListNews)->Unit)? = null

    class ViewHolder(val binding: ItemNewsBinding):RecyclerView.ViewHolder(binding.root) {

        fun bindProduct(itemData:ListNews){
            binding.news = itemData
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        var view = ItemNewsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        var dataNews = listNews[position]
        holder.bindProduct(listNews[position])

        //memberi event setOnClick pada cardView
        holder.binding.cardView.setOnClickListener {
            onClick?.invoke(listNews[position])
        }
    }

    override fun getItemCount(): Int {
        return listNews.size
    }
}