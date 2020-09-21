package com.example.clientside.datasource.service

import com.example.clientside.data.response.Loginresponse
import retrofit2.Call
import retrofit2.http.POST



interface LoginService {
    @POST("api/login")
    suspend fun PostLoginUser () : Loginresponse
}