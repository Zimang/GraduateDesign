package top.zimang.lifemodel.model.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import top.zimang.lifemodel.model.Location

class LocationListTypeConverter {
    @TypeConverter
    fun stringToLocationList(data:String?):MutableList<Location>{
        val gson = Gson()

        if (data.isNullOrEmpty() || data == "null") {
            return mutableListOf()
        }

        val listType = object : TypeToken<List<Location>>() {
        }.type

        return gson.fromJson(data, listType)
    }
    @TypeConverter
    fun locationToString(someObjects: List<Location>?): String {
        val gson = Gson()

        return gson.toJson(someObjects)
    }

}