package com.example.lesson6_

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.URLUtil
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.lesson6_.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var list = mutableListOf<String>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fillList()
        initListener()
    }

    private fun initListener() {
        with(binding) {
            btnSubmit.setOnClickListener {
                if(URLUtil.isValidUrl(etInput.text.toString()) && etInput.text.isNotEmpty()) {
                    list.add(etInput.text.toString())
                    etInput.text.clear()
                }else{
                    Toast.makeText(this@MainActivity,"You should input URL",Toast.LENGTH_SHORT).show()
                }
            }

            btnRandom.setOnClickListener {
                Glide.with(this@MainActivity).load(list.random()).into(ivImage)
            }
        }
    }

    private fun fillList() {
        list.add("https://pixabay.com/ru/photos/%d0%b7%d0%b8%d0%bc%d0%b0-%d1%81%d0%be%d1%81%d0%bd%d0%b0-%d1%81%d0%bd%d0%b5%d0%b3-%d1%85%d0%b2%d0%be%d0%b9%d0%bd%d0%be%d0%b5-%d0%b4%d0%b5%d1%80%d0%b5%d0%b2%d0%be-7626888/")
        list.add("https://cdn.pixabay.com/photo/2022/11/09/21/12/candle-7581472_960_720.jpg")
        list.add("https://cdn.pixabay.com/photo/2022/01/06/16/49/bench-6919896_960_720.jpg")
        list.add("https://cdn.pixabay.com/photo/2021/12/17/09/34/christmas-drink-6876097_960_720.jpg")
        list.add("https://cdn.pixabay.com/photo/2022/11/21/14/28/church-7607172_960_720.jpg")
    }
}