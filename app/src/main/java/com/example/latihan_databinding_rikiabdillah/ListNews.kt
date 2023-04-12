package com.example.latihan_databinding_rikiabdillah

//data class di extend ke serializable
data class ListNews(var judul:String,
               var tanggalRelease:String,
               var penulis:String,
               var detail:String,
               var img:Int): java.io.Serializable {
}