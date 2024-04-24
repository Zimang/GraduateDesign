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
    private val locationModelDao:LocationModelDao
    private val numbeoDataSource:NumbeoDataSource
    private val tagDao:TagDao
    private var countryList: MutableList<Location>?=null


    init {
        val db = LifeModelDatabase.getInstance(application)
        numbeoDataSource= NumbeoDataSource()
        expanseItemDao = db.expanseItemDao()
        locationModelDao = db.locationModelDao()
        lifeModelDao = db.lifeModelDao()
        livingModelDao = db.livingModelDao()
        tagDao = db.tagDao()
        livingLifeDao = db.livingLifeDao()
    }

    //CountryList
    fun updateCountryList(){
//        withContext(Dispatchers.IO){
            countryList=numbeoDataSource.getCountryListFromNumbeo() as MutableList<Location>
//            for (country in countryList!!){
//                numbeoDataSource.getCountryWitCities(location = country)
//            }
//        }
    }

    fun updateWithCitiesToCountry(country: Location?): Location? {
        if (country != null) {
            numbeoDataSource.getCountryWitCities(country)
        }
        return country
    }
    fun getCountryList():MutableList<Location>?{
        if (countryList==null|| countryList!!.size==0){
            countryList=locationModelDao.all as MutableList<Location>
        }
        return countryList
    }
    fun saveCountryList(countries: MutableList<Location?>?){
        countries?.forEach{
            it?.let { it1 -> locationModelDao.insert(it1) }
        }
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
    suspend fun allLifeModels(): List<LifeModel> {
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

    //locationModelDao
    fun insert(location: Location) {
        thread {
            locationModelDao.insert(location)
        }
    }

    fun getCountries():MutableList<Location?>{
       return  locationModelDao.getCountries as MutableList<Location?>
    }
    fun delete(location: Location) {
        thread {
            locationModelDao.delete(location.locationName)
        }
    }

    fun update(location: Location) {
        thread {
            locationModelDao.update(location)
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