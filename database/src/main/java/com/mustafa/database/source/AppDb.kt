package com.mustafa.database.source

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mustafa.database.dao.SampleDao
import com.mustafa.database.model.SampleEntity
import java.lang.Exception

@Database(entities = [SampleEntity::class], version = 1)
abstract class AppDb: RoomDatabase() {

    abstract fun getSampleDao(): SampleDao

    companion object{

        private var db: AppDb? = null

        fun initDb(context: Context){

            db = Room.databaseBuilder(
                context,
                AppDb::class.java,
                "app_db"
            ).build()
        }

        fun getDb(): AppDb{
            return db?: throw Exception("Database is not initialized yet")
        }
    }

}