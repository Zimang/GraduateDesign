package com.example.moviesearchmvc.model

import com.example.moviesearchmvc.model.movie.Movie
import org.junit.Assert.assertEquals
import org.junit.Test

class MovieTest: BaseTest() {
    @Test
    fun testGetReleaseYearFromStringFormmattedDate() {
        //1
        val movie = Movie(title = "Finding Nemo", releaseDate = "2003-05-30")
        assertEquals("2003", movie.getReleaseYearFromDate())
    }

    @Test
    fun testGetReleaseYearFromYear() {
        //2
        val movie = Movie(title = "FindingNemo", releaseDate = "2003")
        assertEquals("2003", movie.getReleaseYearFromDate())
    }

    @Test
    fun testGetReleaseYearFromDateEdgeCaseEmpty() {
        //3
        val movie = Movie(title = "FindingNemo", releaseDate = "")
        assertEquals("", movie.getReleaseYearFromDate())
    }

    @Test
    fun testGetReleaseYearFromDateEdgeCaseNull() {
        //4
        val movie = Movie(title = "FindingNemo")
        assertEquals("", movie.getReleaseYearFromDate())
    }
}