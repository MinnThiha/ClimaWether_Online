package com.moiveapp.com.clamixweather.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.moiveapp.com.clamixweather.R
import com.moiveapp.com.clamixweather.WeatherActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnSearch.setOnClickListener {
            var city:String=etCity.text.toString()
            var intent=Intent(this@MainActivity,WeatherActivity::class.java)
            var b=Bundle()
            b.putString("Key",city)
            intent.putExtras(b)
            startActivity(intent)
        }
    }
}
