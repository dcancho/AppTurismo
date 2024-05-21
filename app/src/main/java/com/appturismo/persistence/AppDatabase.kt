package com.appturismo.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.appturismo.persistence.local.data.PackageDao
import com.appturismo.persistence.local.data.PackageEntity

/*@Database(entities = [PackageEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getPackageDao(): PackageDao

    companion object {
        private var appDatabase: AppDatabase? = null

        fun getAppDatabase(context: Context): AppDatabase {
            if (appDatabase == null) {
                appDatabase = Room.databaseBuilder(context, AppDatabase::class.java, "db")
                    .allowMainThreadQueries().build()
            }
            return appDatabase as AppDatabase
        }
    }

}*/