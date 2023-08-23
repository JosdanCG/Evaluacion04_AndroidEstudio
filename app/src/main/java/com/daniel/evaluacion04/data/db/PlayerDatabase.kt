package com.daniel.evaluacion04.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.daniel.evaluacion04.model.Player

@Database (entities = [Player::class], version = 1)
abstract class PlayerDatabase: RoomDatabase() {
    abstract fun playerDao(): PlayerDao

    companion object {
        @Volatile
        private var instance: PlayerDatabase?= null
        fun getDatabase(context: Context): PlayerDatabase{
            if (instance==null){
                synchronized(this){
                    instance=builDatabase(context)
                }
            }
            return instance!!
        }

        private fun builDatabase(context: Context): PlayerDatabase? {
            return Room.databaseBuilder(
                context.applicationContext,
                PlayerDatabase::class.java,
                "player_database"
            ).build()
        }
    }
}