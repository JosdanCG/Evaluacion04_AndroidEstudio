package com.daniel.evaluacion04.view.fragments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.daniel.evaluacion04.data.db.PlayerDatabase
import com.daniel.evaluacion04.data.repository.PlayersRepository
import com.daniel.evaluacion04.model.Player

class FavoritosViewModel(application: Application): AndroidViewModel(application) {

    private val repository: PlayersRepository
    private val _favoritos: MutableLiveData<List<Player>> = MutableLiveData()

    val favoritos: LiveData<List<Player>> = _favoritos
    init {
        val db= PlayerDatabase.getDatabase(application)
        repository = PlayersRepository(db.playerDao())
    }

    fun getFavoritos(){
        val data=repository.getFavoritos()
        _favoritos.value=data
    }
}