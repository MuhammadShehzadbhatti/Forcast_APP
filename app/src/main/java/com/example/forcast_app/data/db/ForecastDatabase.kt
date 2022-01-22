package com.example.forcast_app.data.db

import android.content.Context
import androidx.room.*
import com.example.forcast_app.data.db.entity.CurrentWeatherEntry
import com.example.forcast_app.data.db.entity.converter.Converters

@Database(
    entities = [CurrentWeatherEntry::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class ForecastDatabase : RoomDatabase() {
    abstract fun currentWeatherDao() : CurrentWeatherDao

    // companion object is a singleton because multiple instances of a database doesn't make much sense
    companion object{
        @Volatile private var instance : ForecastDatabase? = null // volatile: all the threads have the access to this property this is what volatile is doing
        private val LOCK = Any() // Because we're using thread and doesn't matter what type of it just ensures that no more than one thread would do the same job in db.

        // following: checks if the instance is not null then return instance otherwise
        // call synchronized block of code
        operator fun invoke(context:Context) = instance?: synchronized(LOCK){
            // check if instance is already initialized or not
            // if already initialized return the instance otherwise
            // initialize it
            instance ?: buildDatabase(context).also { instance = it }
        }
        //following function will initialize the database
        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
            ForecastDatabase::class.java, "forecaset_db")
                .build()
        // "forecaset_db" is the db name
    }
}