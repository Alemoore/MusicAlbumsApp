package com.example.musicalbumsapp.data

import com.example.musicalbumsapp.data.api.AlbumsAPIService
import com.example.musicalbumsapp.data.api.TracksAPIService
import com.example.musicalbumsapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Provides
    @Singleton
    fun provideAlbumsApiService(retrofit: Retrofit): AlbumsAPIService = retrofit.create(AlbumsAPIService::class.java)

    @Provides
    @Singleton
    fun provideTracksApiService(retrofit: Retrofit): TracksAPIService = retrofit.create(TracksAPIService::class.java)

    @Provides
    @Singleton
    fun provideRetrofit(
            okHttpClient: OkHttpClient,
            moshiConverterFactory: MoshiConverterFactory): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(moshiConverterFactory)
                .client(okHttpClient)
                .build()
    }

    @Provides
    @Singleton
    fun provideMoshiConverterFactory(): MoshiConverterFactory = MoshiConverterFactory.create()

    @Provides
    @Singleton
    fun provideHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
            OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build()

    @Provides
    @Singleton
    fun provideLogInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }


}