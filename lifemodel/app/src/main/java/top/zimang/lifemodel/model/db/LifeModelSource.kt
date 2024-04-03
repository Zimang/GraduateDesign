package top.zimang.lifemodel.model.db

import android.app.Application
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import top.zimang.lifemodel.model.*
import top.zimang.lifemodel.model.dao.*
import kotlin.concurrent.thread

open class LifeModelSource(application: Application) {
    private val expanseItemDao:ExpanseItemDao
    private val lifeModelDao:LifeModelDao
    private val livingLifeDao: LivingLifeDao
    private val livingModelDao:LivingModelDao
    private val tagDao:TagDao


    init {
        val db = LifeModelDatabase.getInstance(application)
        expanseItemDao = db.expanseItemDao()
        lifeModelDao = db.lifeModelDao()
        livingModelDao = db.livingModelDao()
        tagDao = db.tagDao()
        livingLifeDao = db.livingLifeDao()
    }

// expanseItemDao
    fun insert(expanseItem: ExpanseItem) {
        thread {
            expanseItemDao.insert(expanseItem)
        }
    }

    fun delete(expanseItem: ExpanseItem) {
        thread {
            expanseItemDao.delete(expanseItem.expanseItemId)
        }
    }

    fun update(expanseItem: ExpanseItem) {
        thread {
            expanseItemDao.update(expanseItem)
        }
    }

//lifeModelDao
    suspend fun allLifeModels():List<LifeModel>{
        return withContext(Dispatchers.IO){
            lifeModelDao.all
        }
    }

    fun insert(lifeModel: LifeModel) {
        thread {
            lifeModelDao.insert(lifeModel)
        }
    }

    fun delete(lifeModel: LifeModel) {
        thread {
            lifeModelDao.delete(lifeModel.lifeModelId)
        }
    }

    fun update(lifeModel: LifeModel) {
        thread {
            lifeModelDao.update(lifeModel)
        }
    }


//livingLifeDao
//    fun insert(livingLife: LivingLife) {
//        thread {
//            livingLifeDao.insert(livingLifeDao)
//        }
//    }


    //livingModelDao
    fun insert(livingModel: LivingModel) {
        thread {
            livingModelDao.insert(livingModel)
        }
    }

    fun delete(livingModel: LivingModel) {
        thread {
            livingModelDao.delete(livingModel.livingModelId)
        }
    }

    fun update(livingModel: LivingModel) {
        thread {
            livingModelDao.update(livingModel)
        }
    }

    //tagDao
    fun insert(tag: Tag) {
        thread {
            tagDao.insert(tag)
        }
    }

    fun delete(tag: Tag) {
        thread {
            tagDao.delete(tag.tagId)
        }
    }

    fun update(tag: Tag) {
        thread {
            tagDao.update(tag)
        }
    }

}