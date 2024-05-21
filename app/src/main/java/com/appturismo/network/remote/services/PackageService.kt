package com.appturismo.network.remote.services

import com.appturismo.domain.models.Package
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PackageService {
    @GET("productossitiotipo.php")
    fun getPackages(@Query("sitio") site: String, @Query("tipo") type: Int): Call<List<Package>>
}