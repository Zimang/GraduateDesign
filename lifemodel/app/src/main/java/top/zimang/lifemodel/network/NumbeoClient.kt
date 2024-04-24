package top.zimang.lifemodel.network

object NumbeoClient {
    //    https://www.numbeo.com/cost-of-living/in/Shenzhen
    const val DEFAULT_CITY="Shenzhen"
    const val DEFAULT_COUNTRY="China"

    //https://www.numbeo.com/cost-of-living/
    const val NUMBEO_BASE_URL="https://www.numbeo.com/cost-of-living"
    const val NUMBEO_BASE_URL_CITY="https://www.numbeo.com/cost-of-living/in/"
    const val NUMBEO_BASE_URL_COUNTRY="https://www.numbeo.com/cost-of-living/country_result.jsp?country="

    const val NUMBEO_TABLE_QUERY="table.data_wide_table.new_bar_table"
    const val NUMBEO_EXPANSEITEM_QUERY="tr:has(:has(> *:eq(2)))"
    const val NUMBEO_TAG_QUERY="div.category_title"

    const val COUNTRY_QUREY_ID="#country"
    const val COUNTRYLIST_QUREY_ID="option:gt(0)"
    const val CITY_QUREY_ID="#city"
    const val CITYLIST_QUREY_ID="option:gt(0)"
//    https://www.numbeo.com/cost-of-living/country_result.jsp?country=Albania
//    https://www.numbeo.com/cost-of-living/in/Berat


}