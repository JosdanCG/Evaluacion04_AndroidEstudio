package com.daniel.evaluacion04.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daniel.evaluacion04.R
import com.daniel.evaluacion04.databinding.FragmentListBinding
import com.daniel.evaluacion04.view.RVPlayerListAdapter

class ListFragment : Fragment() {

    private  lateinit var  binding: FragmentListBinding;
    private lateinit var  viewModel: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel= ViewModelProvider(requireActivity()).get(ListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentListBinding.inflate(inflater, container, false)
        return  binding.root
    }
//1.57:14
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter=RVPlayerListAdapter(listOf()){player ->

            val playerDetailDirection= ListFragmentDirections.actionListFragment2ToDetalleFragment(player)
            findNavController().navigate(playerDetailDirection)
        }
        binding.rvPlayerList.adapter= adapter
        binding.rvPlayerList.layoutManager= GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false )

        viewModel.playerList.observe(requireActivity()){
            adapter.players=it
            adapter.notifyDataSetChanged()
        }
        viewModel.getPlayersFromService()
    }

}