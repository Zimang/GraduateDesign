package com.example.moviesearchmvc.model

import com.example.moviesearchmvc.model.tv.TV
import org.junit.Assert
import org.junit.Test

class TVTest {
    @Test
    fun testGetReleaseYearFromStringFormmattedDate() {
        //1
        val tv = TV(name = "Finding Nemo", firstAirDate = "2003-05-30")
        Assert.assertEquals("2003", tv.getFirstAirYearFromDate())
    }

    @Test
    fun testGetReleaseYearFromYear() {
        //2
        val tv = TV(name = "FindingNemo", firstAirDate = "2003")
        Assert.assertEquals("2003", tv.getFirstAirYearFromDate())
    }

    @Test
    fun testGetReleaseYearFromDateEdgeCaseEmpty() {
        //3
        val tv = TV(name = "FindingNemo", firstAirDate = "")
        Assert.assertEquals("", tv.getFirstAirYearFromDate())
    }

    @Test
    fun testGetReleaseYearFromDateEdgeCaseNull() {
        //4
        val tv = TV(name = "FindingNemo")
        Assert.assertEquals("", tv.getFirstAirYearFromDate())
    }
}