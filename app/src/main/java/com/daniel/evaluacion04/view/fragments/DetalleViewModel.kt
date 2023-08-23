package com.daniel.evaluacion04.view.fragments

import android.app.Application
import androidx.lifecycle.*
import com.daniel.evaluacion04.data.db.PlayerDatabase
import com.daniel.evaluacion04.data.repository.PlayersRepository
import com.daniel.evaluacion04.model.Player
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetalleViewModel (application: Application): AndroidViewModel(application) {

    private val repository: PlayersRepository

    init {
        val db= PlayerDatabase.getDatabase(application)
        repository = PlayersRepository(db.playerDao())
    }

    fun addFavorite(player: Player){
        viewModelScope.launch ( Dispatchers.IO ){
            repository.addFavorito(player)
        }
    }
}