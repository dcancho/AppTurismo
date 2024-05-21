package com.appturismo.repositories

import android.util.Log
import com.appturismo.domain.models.Package
import com.appturismo.network.remote.factories.PackageServiceFactory
import com.appturismo.network.remote.services.PackageService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PackageRepository {
    private val packageService: PackageService = PackageServiceFactory.getPackageService()

    fun getPackages(callback: (List<Package>) -> Unit, site: String, type: Int) {
        val getPackages = packageService.getPackages(site, type)

        getPackages.enqueue(object : Callback<List<Package>> {
            override fun onResponse(
                call: Call<List<Package>>,
                response: Response<List<Package>>
            ) {
                if (response.isSuccessful) {
                    val packages = response.body() ?: emptyList()
                    callback(packages)
                }
            }

            override fun onFailure(call: Call<List<Package>>, t: Throwable) {
                t.message?.let {
                    Log.d("RestaurantRepository", it)
                }
            }
        })
    }
}