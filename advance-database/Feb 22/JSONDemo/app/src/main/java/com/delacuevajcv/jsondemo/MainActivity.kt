package com.delacuevajcv.jsondemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(imgAvatar)

        downloadJSON()
    }

    fun downloadJSON() {
        val apiInterface = Client.retrofit.create(ApiInterface::class.java)
        val call = apiInterface.getData("https://randomuser.me/api/?results=1")
        call.enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                val errorMessage = t.localizedMessage
                Toast.makeText(this@MainActivity, errorMessage, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    val responseString = response.body()?.string()
                    if (responseString != null) {
                        val json = JSONObject(responseString)
                        val jsonArray = json.getJSONArray("results")
                        val item = jsonArray.getJSONObject(0)
                        val gender = item.getString("gender")
                        tvGender.text = gender

                        val info = json.getJSONObject("info")
                        val page = info.getInt("page")
                        Toast.makeText(this@MainActivity, "$page", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }
}
