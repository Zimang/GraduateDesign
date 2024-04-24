package top.zimang.lifemodel.model.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import top.zimang.lifemodel.model.*

class ExpanseItemListTypeConverter {
    @TypeConverter
    fun stringToExpanseItemList(data: String?): MutableList<ExpanseItem> {

        val gson = Gson()

        if (data == null || data.isEmpty() || data.equals("null")) {
            return mutableListOf<ExpanseItem>()
        }

        val listType = object : TypeToken<List<ExpanseItem>>() {
        }.type

        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun expanseItemToString(someObjects: List<ExpanseItem>?): String {
        val gson = Gson()

        return gson.toJson(someObjects)
    }

}