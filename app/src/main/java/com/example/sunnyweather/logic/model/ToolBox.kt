package com.example.sunnyweather.logic.model

import android.widget.Toast
import com.example.sunnyweather.SunnyWeatherApplication

fun String.showToast(time: Int = Toast.LENGTH_SHORT){
    Toast.makeText(SunnyWeatherApplication.context,this,time).show()
}