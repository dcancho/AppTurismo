package com.appturismo.persistence.local.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "packages")
class PackageEntity (
    @PrimaryKey
    val id: Int
)