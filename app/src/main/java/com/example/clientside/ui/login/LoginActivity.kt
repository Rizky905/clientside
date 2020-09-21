package com.example.clientside.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.clientside.R
import com.example.clientside.databinding.ActivityLoginBinding
import com.example.clientside.ui.home.HomeActivity
import com.example.clientside.utils.NetworkState
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var homeViewModel: LoginViewModel
    private lateinit var homeDataBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        homeDataBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)

        homeViewModel.postLoginUser().observe(this, Observer {
            when(it){
                is NetworkState.Success -> {
                    Toast.makeText(this,"success",Toast.LENGTH_SHORT).show()
                }
                is NetworkState.Error -> {
                    Toast.makeText(this,"failed",Toast.LENGTH_SHORT).show()
                }
            }
        })

        homeDataBinding.BtnLogin.setOnClickListener {
            val email = homeDataBinding.emailtext.text.toString().trim()
            val password = homeDataBinding.passwordtext.text.toString().trim()
            homeViewModel.postLoginUser()
//            val intent = Intent(this@LoginActivity, HomeActivity::class.java)
//            startActivity(intent)
        }
    }

}