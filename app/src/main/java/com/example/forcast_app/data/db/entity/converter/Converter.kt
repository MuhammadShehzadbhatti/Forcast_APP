package com.example.forcast_app.data.db.entity.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.StringBuilder
import java.lang.reflect.Type
import java.util.*
import kotlin.collections.ArrayList

class Converters {

    @TypeConverter
    fun listDescriptionToString(value: List<String>?): String? {
        val gson = Gson()
        return gson.toJson(value)
    }

    @TypeConverter
    fun fromString(value: String?): ArrayList<String?>? {
        val listType: Type = object : TypeToken<ArrayList<String?>?>() {}.getType()
        return Gson().fromJson(value, listType)
    }
/*
    @TypeConverter
    fun listIconToString(value: List<String>?): String? {
        val gson = Gson()
        return gson.toJson(value)
    }*/
}