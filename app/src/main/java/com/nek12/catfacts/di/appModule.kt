@file:OptIn(ExperimentalSerializationApi::class)

package com.nek12.catfacts.di

import android.content.Context
import androidx.room.Room
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.nek12.catfacts.BuildConfig
import com.nek12.catfacts.data.api.CatApi
import com.nek12.catfacts.data.db.CatDatabase
import com.nek12.catfacts.data.repo.CatRepo
import com.nek12.catfacts.ui.screens.cat_fact.CatFactViewModel
import com.nek12.catfacts.ui.screens.history.HistoryViewModel
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create


val appModule = module {
    single { provideJson() }
    single { provideOkHttp() }
    single { provideRetrofit(get(), get()) }
    single { get<Retrofit>().create<CatApi>() }

    single { provideDatabase(get()) }
    single { get<CatDatabase>().catDao() }
    single { CatRepo(get(), get()) }


    viewModel { CatFactViewModel(get()) }
    viewModel { HistoryViewModel(get()) }
}


private fun provideJson() = Json {
    explicitNulls = false
    isLenient = true
    ignoreUnknownKeys = true
}

private fun provideDatabase(context: Context): CatDatabase {
    val builder = Room.databaseBuilder(context, CatDatabase::class.java, CatDatabase.DATABASE_NAME)
    if (BuildConfig.DEBUG) {
        builder.fallbackToDestructiveMigration()
    }
    return builder.build()
}

private fun provideOkHttp() = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor()).build()

private fun provideRetrofit(json: Json, okHttp: OkHttpClient) =
    Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl("https://catfact.ninja/") //! Using another API because suggested api https://cat-fact.herokuapp.com/ is broken
        .client(okHttp)
        .build()
