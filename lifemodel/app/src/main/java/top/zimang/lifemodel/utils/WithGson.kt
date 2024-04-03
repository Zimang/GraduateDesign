package top.zimang.lifemodel.utils

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.reflect.TypeToken
import top.zimang.lifemodel.model.LifeModel

object WithGson {
    val gson=Gson()
    fun toJson(lifeModel: LifeModel):String{
        return gson.toJson(lifeModel)
    }
    inline fun <reified T>fromJson(json:String):T{
        return gson.fromJson(json,object : TypeToken<T>(){}.type)
    }
}