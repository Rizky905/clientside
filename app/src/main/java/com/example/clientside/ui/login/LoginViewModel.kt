package com.example.clientside.ui.login

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clientside.data.response.Loginresponse
import com.example.clientside.datasource.repository.LoginRepository
import com.example.clientside.utils.NetworkState
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.annotation.Resource

class LoginViewModel @ViewModelInject constructor(private val loginRepository: LoginRepository): ViewModel(){

    fun postLoginUser(): MutableLiveData<NetworkState>{
        val networkState = MutableLiveData(NetworkState.loading(true))
        viewModelScope.launch {
            try {
                val result = loginRepository.PostLoginUser()
                networkState.value = NetworkState.success(result)
            }catch (e: Exception){
                networkState.value = NetworkState.error(e)
            }

        }
        return networkState
    }
}