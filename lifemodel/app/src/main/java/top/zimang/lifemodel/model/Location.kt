package top.zimang.lifemodel.model

data class Location(
    var locationType:String?,
    var isCity:Boolean?,
    var isCountry:Boolean?,
    var locationName:String?,
    //url suffix
    //https://www.numbeo.com/cost-of-living/country_result.jsp?country=Afghanistan
    var suffix:String?,
    var cityList:List<Location>?
) {
}
