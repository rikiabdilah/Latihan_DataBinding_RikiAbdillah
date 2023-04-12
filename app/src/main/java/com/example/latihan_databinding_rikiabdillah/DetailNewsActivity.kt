package com.example.latihan_databinding_rikiabdillah

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.latihan_databinding_rikiabdillah.databinding.ActivityDetailNewsBinding

class DetailNewsActivity : AppCompatActivity() {

    lateinit var binding:ActivityDetailNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //mengambil data menggunakan serializable dengan keyName detailNews
        val getDetail = intent.getSerializableExtra("detailNews") as ListNews

        //set nilai  img pada component ImgView yang sudah dibuat
        binding.setImg.setImageResource(getDetail.img)

        //set nilai judul pada component TextView yang sudah dibuat
        binding.setTxJudul.text=(getDetail.judul)
        binding.setTxDeskripsi.text=(getDetail.detail)
    }
}