package com.daniel.evaluacion04.view.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daniel.evaluacion04.data.repository.PlayersRepository
import com.daniel.evaluacion04.model.ApisResponse
import com.daniel.evaluacion04.model.Player
import com.daniel.evaluacion04.model.getData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel: ViewModel() {
    val repository= PlayersRepository()
    val  playerList: MutableLiveData<List<Player>> = MutableLiveData<List<Player>>()

    fun getPlayerList(){
        val data= getData()
        playerList.value=data
    }

    fun getPlayersFromService(){
        viewModelScope.launch ( Dispatchers.IO ){
            val response= repository.getPlayers()
            when(response){
                is ApisResponse.Error ->{
                    //colocar error
                }
                is ApisResponse.Success ->{
                    playerList.postValue(response.data.data)
                }
            }
        }
    }
}