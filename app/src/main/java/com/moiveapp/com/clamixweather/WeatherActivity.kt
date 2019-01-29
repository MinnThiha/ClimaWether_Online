package com.moiveapp.com.clamixweather
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.moiveapp.com.clamixweather.Utils.BASE_URL
import com.moiveapp.com.clamixweather.Utils.KEY
import com.moiveapp.com.clamixweather.model.WeatherResponse
import com.moiveapp.com.clamixweather.network.ApiService
import kotlinx.android.synthetic.main.weather_activity.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.weather_activity)

        var retrofit=Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        var api=retrofit.create(ApiService::class.java)

        var i=intent
        var bd=i.extras
        var city:String=bd.getString("Key")

        api.getWeather(city, KEY).enqueue(object:Callback<WeatherResponse>{
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
               Toast.makeText(this@WeatherActivity,t.message,Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                if(response.isSuccessful){
                    var wr=response.body()
                    tvCity.text=city
                    tvWind.text=wr!!.wind!!.speed
                    tvPressure.text=wr.main!!.pressure
                    tvTemp.text= wr.main!!.temp
                }
                else{
                    Toast.makeText(this@WeatherActivity,response.message(),Toast.LENGTH_SHORT).show()
                }


            }

        })



    }
}