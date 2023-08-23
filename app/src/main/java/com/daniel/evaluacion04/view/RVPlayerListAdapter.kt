package com.daniel.evaluacion04.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.daniel.evaluacion04.R
import com.daniel.evaluacion04.databinding.ItemPlayerBinding
import com.daniel.evaluacion04.model.Player

class RVPlayerListAdapter(var  players: List<Player>, val onClick: (Player) -> Unit): RecyclerView.Adapter<PlayerVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerVH {
        val binding=ItemPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  PlayerVH(binding, onClick)
    }

    override fun getItemCount(): Int= players.size

    override fun onBindViewHolder(holder: PlayerVH, position: Int) {
        holder.bind(players[position])
    }
}

class PlayerVH(private val binding: ItemPlayerBinding, val onClick: (Player) -> Unit): RecyclerView.ViewHolder(binding.root){
    fun bind(player: Player) {
        binding.imageView.setImageResource(R.drawable.cr7chuiquito)
        binding.txtName.text ="Nombres: ${player.firstname}"
        binding.txtApellidos.text ="Apellidos: ${player.lastname}"
        binding.txtFechanac.text= player.date_of_birth
        binding.root.setOnClickListener{
            onClick(player)
        }
    }

}