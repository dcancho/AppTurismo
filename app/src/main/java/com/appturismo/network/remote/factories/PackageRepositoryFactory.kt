package com.appturismo.network.remote.factories

import com.appturismo.network.remote.services.PackageService
import com.appturismo.repositories.PackageRepository

class PackageRepositoryFactory private constructor() {

    companion object {
        private var packageRepository: PackageRepository? = null

        fun getPackageRepository(): PackageRepository {
            if (packageRepository == null) {
                packageRepository = PackageRepository()
            }
            return packageRepository as PackageRepository
        }
    }
}