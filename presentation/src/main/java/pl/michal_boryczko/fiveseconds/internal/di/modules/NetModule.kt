package pl.michal_boryczko.fiveseconds.internal.di.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pl.michal_boryczko.data.network.NetworkService
import pl.michal_boryczko.fiveseconds.BuildConfig
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton
import pl.michal_boryczko.fiveseconds.internal.AndroidApplication
import pl.michal_boryczko.fiveseconds.internal.DaggerNames


import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


private const val CACHE_SIZE = 36 * 1024 * 1024L
private const val CACHE_TIME = 0 //minuta

@Module
class NetModule(private val application: AndroidApplication) {

    @Provides
    @Singleton
    internal fun provideGson2(): Gson = GsonBuilder()
            .create()

    @Provides
    @Singleton
    @Named(DaggerNames.DESERIALIZER_GSON)
    internal fun provideDeserializerGson(): Gson = GsonBuilder()
            .create()

    @Provides
    @Singleton
    @Named(DaggerNames.RETROFIT_GSON)
    internal fun provideGson(@Named(DaggerNames.DESERIALIZER_GSON) gson: Gson): Gson = GsonBuilder()
            .create()

    @Provides
    @Singleton
    internal fun provideInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }




    @Provides
    @Singleton
    internal fun provideOkHttpClient(interceptor: Interceptor): OkHttpClient {

        return OkHttpClient().newBuilder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                //.cookieJar(JavaNetCookieJar(cookieManager))
                //.addInterceptor(interceptor)
                .addInterceptor(interceptor)
                .build()


    }

    @Provides
    @Singleton
    internal fun provideRetrofit(@Named(DaggerNames.RETROFIT_GSON) gson: Gson, okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.API_ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()


    @Provides
    @Singleton
    internal fun provideService(retrofit: Retrofit): NetworkService = retrofit.create(NetworkService::class.java)





}
