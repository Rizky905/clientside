package com.example.clientside.di


import com.example.clientside.BuildConfig
import com.example.clientside.datasource.service.LoginService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    private fun ProvideHttpClient(): OkHttpClient{
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor {
                val req =
                    it.request().newBuilder()
                        .addHeader("user","application/json").build()
                return@addInterceptor it.proceed(req)
            }
//            .addInterceptor {
//                val req =
//                    it.request().newBuilder().url(it.request().url.newBuilder().addQueryParameter("API_KEY",BuildConfig.))
//            }
            .build()
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.API_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(ProvideHttpClient())
        .build()

    @Provides
    @Singleton
    fun provideUserService(): LoginService{
        return retrofit.create(LoginService::class.java)
    }
}