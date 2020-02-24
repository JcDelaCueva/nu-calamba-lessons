package com.delacuevajcv.jsondemo

import retrofit2.Retrofit

object Client {

    val retrofit = Retrofit.Builder().baseUrl("https://randomuser.me/api/").build()

}