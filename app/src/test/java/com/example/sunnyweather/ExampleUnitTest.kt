package com.example.sunnyweather

import com.example.sunnyweather.logic.Repository
import com.example.sunnyweather.logic.model.Place
import com.example.sunnyweather.logic.model.PlaceResponse
import com.example.sunnyweather.logic.network.PlaceService
import com.example.sunnyweather.logic.network.ServiceCreator
import com.example.sunnyweather.ui.place.PlaceViewModel
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun test(){
        runBlocking {
            val placeService = ServiceCreator.create<PlaceService>()
            placeService.searchPlaces("北京").enqueue(object : Callback<PlaceResponse>{
                override fun onResponse(call: Call<PlaceResponse>, response: Response<PlaceResponse>) {
                    val body = response.body()
                    if(body != null){
                        println(body.places.toString())
                    }else{
                        println("失败！")
                    }
                }
                override fun onFailure(call: Call<PlaceResponse>, t: Throwable) {

                }
            })
        }
    }

}