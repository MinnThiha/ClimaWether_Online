package com.moiveapp.com.clamixweather.network

import com.moiveapp.com.clamixweather.model.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService{
    @GET("data/2.5/weather")
    fun getWeather(@Query("q")city:String,@Query("appid")Key:String):Call<WeatherResponse>
}