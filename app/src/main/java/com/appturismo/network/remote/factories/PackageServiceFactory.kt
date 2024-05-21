package com.appturismo.network.remote.factories

import com.appturismo.network.RetrofitFactory
import com.appturismo.network.remote.services.PackageService

class PackageServiceFactory private constructor() {
    companion object {
        private var packageService: PackageService? = null

        fun getPackageService(): PackageService {
            if (packageService == null) {
                packageService = RetrofitFactory.getRetrofit().create(PackageService::class.java)
            }
            return packageService as PackageService
        }
    }
}