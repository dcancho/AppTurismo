package com.appturismo.persistence.local.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PackageDao {
    @Insert
    fun insert(item: Package)

    @Delete
    fun delete(item: Package)

    @Query("SELECT * FROM packages where id=:id")
    fun getPackage(id: Int): Package?

}