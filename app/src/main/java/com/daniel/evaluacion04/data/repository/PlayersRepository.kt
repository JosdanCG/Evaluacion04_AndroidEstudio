package com.daniel.evaluacion04.data.repository

import com.daniel.evaluacion04.data.RetrofitInstance
import com.daniel.evaluacion04.data.db.PlayerDao
import com.daniel.evaluacion04.data.response.PlayerListResponse
import com.daniel.evaluacion04.model.ApisResponse
import com.daniel.evaluacion04.model.Player
import java.lang.Exception

class PlayersRepository(val playerDao: PlayerDao? = null) {
    suspend fun  getPlayers():ApisResponse<PlayerListResponse>{
        return try{
            val response=RetrofitInstance.getPlayerService().getPlayers()
            ApisResponse.Success(response)
        } catch (e:Exception){
            ApisResponse.Error(e)
        }
    }

    suspend fun  addFavorito(player: Player){
        playerDao?.let {
            it.addFavorite(player)
        }
    }

    fun getFavoritos(): List<Player>{
        playerDao?.let {
            return it.getFavorites()
        }?: kotlin.run {
            return listOf()
        }
    }
}