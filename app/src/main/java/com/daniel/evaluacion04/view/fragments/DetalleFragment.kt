package com.daniel.evaluacion04.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.daniel.evaluacion04.R
import com.daniel.evaluacion04.databinding.FragmentDetalleBinding
import com.daniel.evaluacion04.model.Player

class DetalleFragment : Fragment() {
    private lateinit var binding: FragmentDetalleBinding
    val  args: DetalleFragmentArgs by navArgs()

    private lateinit var player: Player

    private lateinit var viewModel: DetalleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        player=args.player

        viewModel= ViewModelProvider(requireActivity()).get(DetalleViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentDetalleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imgPlayer.setImageResource(R.drawable.cr7chuiquito)
        binding.txtName.text ="Nombres      : ${player.firstname}"
        binding.txtApellidos.text ="Apellidos    : ${player.lastname}"
        binding.txtFechanac.text= player.date_of_birth
        binding.txtEstatura.text ="Estatura     : ${player.height} cm"
        binding.txtPeso.text ="Peso         : ${player.weight} kg"

        binding.btnAddFavorite.setOnClickListener{
            viewModel.addFavorite(player)
        }
    }

}