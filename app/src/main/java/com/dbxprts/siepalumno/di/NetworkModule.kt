package com.dbxprts.siepalumno.di

import androidx.annotation.NonNull
import com.dbxprts.siepalumno.api.HomeworkService
import com.dbxprts.siepalumno.api.LoginService
import com.dbxprts.siepalumno.api.StudentService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .readTimeout(1, TimeUnit.MINUTES)
            .connectTimeout(1, TimeUnit.MINUTES)
            .build()

        return Retrofit.Builder()
            .client(client)
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideLoginService(@NonNull retrofit: Retrofit): LoginService {
        return retrofit.create(LoginService::class.java)
    }

    @Provides
    @Singleton
    fun provideStudentService(@NonNull retrofit: Retrofit): StudentService{
        return retrofit.create(StudentService::class.java)
    }

    @Provides
    @Singleton
    fun provideHomeworkService(@NonNull retrofit: Retrofit): HomeworkService{
        return retrofit.create(HomeworkService::class.java)
    }
}
