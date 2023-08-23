package com.daniel.evaluacion04.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.daniel.evaluacion04.model.Player

@Dao
interface PlayerDao {
    @Query("select * from player")
    fun getFavorites(): List<Player>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFavorite(player: Player)
}