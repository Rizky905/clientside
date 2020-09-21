package com.example.clientside.datasource.repository

import com.example.clientside.datasource.service.LoginService
import javax.inject.Inject

class LoginRepository @Inject constructor(private val network: LoginService){
    suspend fun PostLoginUser() = network.PostLoginUser()
}