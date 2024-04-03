package top.zimang.lifemodel.model.db

import android.util.Log
import org.jsoup.Jsoup
import top.zimang.lifemodel.model.ExpanseItem
import top.zimang.lifemodel.model.Location
import top.zimang.lifemodel.network.NumbeoClient
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

open class NumbeoDataSource {
    open fun getExpanseItemListFromNumbeo(location: Location):List<ExpanseItem>?{
        val doc = Jsoup.connect(NumbeoClient.NUMBEO_BASE_URL_CITY+ NumbeoClient.DEFAULT_CITY).get()
        val title = doc.title()
        //.data_wide_table
        val table=doc.select(NumbeoClient.NUMBEO_TABLE_QUERY)[0].select("tr:gt(0)")
        val expanseItemList=table.select(NumbeoClient.NUMBEO_EXPANSEITEM_QUERY).map {
            //        (it.child(0).text()
            val expanseItemName=it.child(0)?.text()
            val cost= it.child(1)?.text()?.substringBefore(" ")?.replace("[,|]".toRegex(),"")
            val expanseItem= ExpanseItem(expanseItemName,null,null, cost?.toDouble(),null,null,null)
            expanseItem
        }
        val categoryList=table.select("div.category_title").map { it.text() }

        return expanseItemList
    }
    open fun getCountryListFromNumbeo():List<Location>?{
        val doc = Jsoup.connect(NumbeoClient.NUMBEO_BASE_URL).get()
        //.data_wide_table
        val countryList=doc.select(NumbeoClient.COUNTRY_QUREY_ID)
            .select(NumbeoClient.COUNTRYLIST_QUREY_ID)
            .map {
                val name=it.text()
                val suffix= URLEncoder.encode(name, StandardCharsets.UTF_8.toString())
                Location("COUNTRY",false,true,name,suffix,null)
            }
        return countryList
    }
    open fun getCityListFromNumbeo(suffix:String):List<Location>?{
        val url:String=NumbeoClient.NUMBEO_BASE_URL_COUNTRY+suffix
        val doc = Jsoup.connect(url).get()
        //.data_wide_table
        val cityList=doc.select(NumbeoClient.CITY_QUREY_ID)
            .select(NumbeoClient.CITYLIST_QUREY_ID)
            .map {
                val name=it.text()
                val suffix= URLEncoder.encode(name, StandardCharsets.UTF_8.toString())
                Location("CITY",true,false,name,suffix,null)
            }
        return cityList
    }
    open fun enlargeCityListFromNumbeo(location: Location):Location?{
        val doc = Jsoup.connect(NumbeoClient.NUMBEO_BASE_URL_CITY+location.suffix).get()
        //.data_wide_table
        val cityList=doc.select(NumbeoClient.CITY_QUREY_ID)
            .select(NumbeoClient.CITYLIST_QUREY_ID)
            .map {
                val name=it.text()
                val suffix= URLEncoder.encode(name, StandardCharsets.UTF_8.toString())
                Location("CITY",true,false,name,suffix,null)
            }
        location.cityList=cityList
        return location
    }

}