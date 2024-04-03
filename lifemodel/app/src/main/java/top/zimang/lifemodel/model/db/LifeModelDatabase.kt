package top.zimang.lifemodel.model.db

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import top.zimang.lifemodel.model.*
import top.zimang.lifemodel.model.dao.*

@Database(entities = [(ExpanseItem::class), (LifeModel::class), (Tag::class), (LivingModel::class)],version =1)
@TypeConverters(
    IntegerListTypeConverter::class,
    ExpanseItemListTypeConvert::class)
abstract class LifeModelDatabase :RoomDatabase(){
    abstract fun tagDao(): TagDao
    abstract fun expanseItemDao():ExpanseItemDao
    abstract fun livingModelDao():LivingModelDao
    abstract fun lifeModelDao():LifeModelDao
    abstract fun livingLifeDao():LivingLifeDao

    companion object {

        private const val DB_NAME = "life_model_database"

        @Volatile
        private var INSTANCE: LifeModelDatabase? = null

        fun getInstance(context: Context): LifeModelDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LifeModelDatabase::class.java,
                    DB_NAME
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}