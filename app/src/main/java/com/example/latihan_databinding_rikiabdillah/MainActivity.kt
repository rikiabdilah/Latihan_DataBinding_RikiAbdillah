package com.example.latihan_databinding_rikiabdillah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihan_databinding_rikiabdillah.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listNewsData = arrayListOf(
            ListNews("Pelaku Sabotase QRIS Kotak Amal Masjid Diduga Punya Mobil Xpander",
                    "Selasa, 11 Apr 2023 17:56 WIB","Septian Farhan Nurhada - detikOto",
            "Jakarta - Sejak beberapa hari terakhir, publik digegerkan aksi pria berinisial IM yang mengganti\n" +
                    " QRIS kotak amal Masjid Nurul Iman, Blok M Square, Jakarta Selatan dengan QRIS miliknya sendiri. Belakangan beredar kabar, IM merupakan pengguna mobil Mitsubishi Xpander.\n" +
                    "Diketahui, selain masjid di Blok M Square, IM juga menyabotase QRIS kotak amal di sejumlah masjid lain, seperti Istiqlal dan\n" +
                    " Pondok Indah. Di setiap aksinya, dia selalu menampilkan gelagat yang sama, yakni melirik sana-sini sebelum kemudian mengeluarkan stiker QRIS dari kantong bajunya."
                    ,R.drawable.img),

            ListNews("PT DKI Batalkan Putusan PN Jakpus Soal Penundaan Pemilu",
                    "Kompas.com-11/04/2023, 14:27 WIB","Irfan Kamil",
            "JAKARTA, KOMPAS.com - Pengadilan Tinggi (PT) DKI Jakarta membatalkan putusan perkara perdata Partai\n" +
                    " Rakyat Adil Makmur (Prima) terhadap Komisi Pemilihan Umum (KPU) terkait tahapan pemilihan umum (Pemilu)\n" +
                    " 2024. Diketahui, KPU mengajukan banding ke PT DKI Jakarta atas putusan Pengadilan Negeri (PN) Jakarta Pusat\n" +
                    " nomor perkara 757/Pdt.G/2022/PT.Jkt.Pst yang menghukum KPU untuk menunda tahapan pemilu.\n",
                    R.drawable.img_1),

            ListNews("Pengamat: Anas Urbaningrum Mulai Menabuh Genderang Perang",
                    "Selasa 11 Apr 2023 16:47 WIB","Rizky Suryarandika, M Fauzi Ridwan",
            "REPUBLIKA.CO.ID, JAKARTA -- Direktur Rumah Politik Indonesia, Fernando Ernesto Maraden Sitorus merespons sindiran\n" +
                    " mantan ketua umum Partai Demokrat Anas Urbaningrum soal menggunakan pihak lain untuk menggebuk atau nabok nyilih\n" +
                    " tangan. Hal itu disampaikan Anas usai keluar dari Lapas Sukamiskin, Kota Bandung pada Selasa (11/4/2023)."
            ,R.drawable.img_2),

            ListNews("Korupsi Pembangunan Tol MBZ, Tiga Pejabat Waskita dan Jasa Marga Diperiksa",
                    "Selasa 11 Apr 2023 05:11 WIB","Bambang Noroyono",
            "REPUBLIKA.CO.ID, JAKARTA -- Kejaksaan Agung (Kejagung) memeriksa tiga pejabat dan karyawan PT Waskita\n" +
                    " Karya dan PT Jasa Marga terkait penyidikan korupsi pembangunan jalan Tol Jakarta-Cikampek (Japek) II Elevated.\n" +
                    " Tiga yorang ang diperiksa tersebut adalah UMA, HA, dan BI.",
            R.drawable.img_3),

            ListNews("Ratusan Guru P3K Demo Pemkot Bekasi Pendapatan Dikurangi Jadi Rp 1,5 Juta",
                    "Selasa 11 Apr 2023 04:13 WIB","Ali Yusufa",
            "REPUBLIKA.CO.ID, BEKASI -- Ratusan guru Pegawai Pemerintah dengan Perjanjian Kerja (P3K) Kota\n" +
                    " Bekasi turun ke jalan sebagai bentuk protes tunjangan pendapatan penghasilan (TPP) sekitar 75\n" +
                    " persen dipotong Pemerintah Kota (Pemkot) Bekasi. Mereka meminta hak TPP disamakan dengan golongan\n" +
                    " pegawai negeri sipil (PNS) yang tidak dipotong.",
            R.drawable.img_4)
        )
        val adapterNews = NewsAdapter(listNewsData)
        val lm = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        //rvNews dari component recyclerView pada activity_main_xml
        binding.rvNews.layoutManager = lm
        binding.rvNews.adapter = adapterNews

        //adapterNews menggunakan method onClick
        adapterNews.onClick={
            var pindah = Intent(this,DetailNewsActivity::class.java)
            //mengambil data pada MainActivity dan di passing ke DetailNewsActivity, dan disimpan pada keyName detailNews
            pindah.putExtra("detailNews",it)
            startActivity(pindah)
        }
    }
}