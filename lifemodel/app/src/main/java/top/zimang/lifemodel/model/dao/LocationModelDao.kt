package top.zimang.lifemodel.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import top.zimang.lifemodel.model.ExpanseItem
import top.zimang.lifemodel.model.Location

@Dao
interface LocationModelDao {
    @get:Query("SELECT * FROM location_table")
    val all: List<Location>

    @get:Query("SELECT * FROM location_table where is_city = 0")
    val getCountries: List<Location>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(location: Location)

    @Query("DELETE FROM location_table WHERE location_name = :locationName")
    fun delete(locationName: String?)

    @Query("DELETE FROM location_table")
    fun deleteAll()

    @Update
    fun update(location: Location)
}