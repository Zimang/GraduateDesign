package top.zimang.lifemodel.model.db

import android.util.Log
import org.jsoup.Jsoup
import top.zimang.lifemodel.model.ExpanseItem
import top.zimang.lifemodel.model.Location
import top.zimang.lifemodel.network.NumbeoClient
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.security.KeyStore.LoadStoreParameter

open class NumbeoDataSource {
    /**
     * 返回一个城市的开支列表
     *
     * @param location 城市
     * @return
     */
    open fun getExpanseItemListFromNumbeoByCity(location: Location):List<ExpanseItem>?{
        val doc = Jsoup.connect(location.url).get()
        //.data_wide_table
        val table=doc.select(NumbeoClient.NUMBEO_TABLE_QUERY)[0].select("tr:gt(0)")
        val expanseItemList=table.select(NumbeoClient.NUMBEO_EXPANSEITEM_QUERY).map {
            //        (it.child(0).text()
            val expanseItemName=it.child(0).text()
            val cost= it.child(1).text().substringBefore(" ").replace("[,|]".toRegex(),"")
            val expanseItem= ExpanseItem(expanseItemName,null,null, cost.toDouble(),null,null,null)
            expanseItem
        }

        return expanseItemList
    }

    /**
     * 获取Numberbeo可以提供数据的国家列表
     *
     * @return List<Location>
     */
    open fun getCountryListFromNumbeo():List<Location>?{
        val doc = Jsoup.connect(NumbeoClient.NUMBEO_BASE_URL).get()
        //.data_wide_table
        val countryList=doc.select(NumbeoClient.COUNTRY_QUREY_ID)
            .select(NumbeoClient.COUNTRYLIST_QUREY_ID)
            .map {
                val name=it.text()
                val url=NumbeoClient.NUMBEO_BASE_URL_COUNTRY+URLEncoder.encode(name, StandardCharsets.UTF_8.toString())
                Location(name,false,url, mutableListOf())
            }
        return countryList
    }

    /**
     * 返回一个国家的城市列表
     *
     * @param countryName
     * @return
     */
    open fun getCountryWitCities(countryName:String):Location{

        val location=Location(countryName,false,NumbeoClient.NUMBEO_BASE_URL_COUNTRY+URLEncoder.encode(countryName, StandardCharsets.UTF_8.toString()),null)
        val doc = Jsoup.connect(location.url).get()
        //.data_wide_table
        val cityList=doc.select(NumbeoClient.CITY_QUREY_ID)
            .select(NumbeoClient.CITYLIST_QUREY_ID)
            .map {
                val name=it.text()
                val url= NumbeoClient.NUMBEO_BASE_URL_CITY+URLEncoder.encode(name, StandardCharsets.UTF_8.toString())
                Location(name,true,url,null)
            }
        location.locationList=cityList
        return location
    }
    /**
     * 返回一个国家的城市列表
     *
     * @param countryName
     * @return
     */
    open fun getCountryWitCities(location: Location):Location?{

        val doc = location.url?.let { Jsoup.connect(it).get() }
        //.data_wide_table
        val cityList=doc?.select(NumbeoClient.CITY_QUREY_ID)
            ?.select(NumbeoClient.CITYLIST_QUREY_ID)
            ?.map {
                val name=it.text()
                val url= NumbeoClient.NUMBEO_BASE_URL_CITY+URLEncoder.encode(name, StandardCharsets.UTF_8.toString())
                Location(name,true,url,null)
            }
        location.locationList=cityList
        return location
    }


}