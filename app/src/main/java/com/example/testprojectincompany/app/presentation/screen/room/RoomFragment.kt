package com.example.testprojectincompany.app.presentation.screen.room

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.testprojectincompany.R
import com.example.testprojectincompany.app.di.DaggerAppComponent
import com.example.testprojectincompany.app.presentation.dialog.ErrorDialog
import com.example.testprojectincompany.databinding.FragmentRoomBinding
import javax.inject.Inject

class RoomFragment : Fragment() {
    private lateinit var binding: FragmentRoomBinding

    @Inject
    lateinit var viewModelFactory: RoomViewModelFactory
    private lateinit var viewModel: RoomViewModel

    private val nameOfHotel by lazy {
        arguments?.getString("nameOfHotel")
    }
    private val roomsRecyclerViewAdapter by lazy {
        RoomsRecyclerViewAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val component =
            DaggerAppComponent.builder().context(requireContext().applicationContext)
                .build()
        component.inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(RoomViewModel::class.java)

        binding = FragmentRoomBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBack.setOnClickListener {
            this.findNavController().navigate(R.id.action_roomFragment_to_hotelFragment)
        }
        binding.tvHotelName.text = nameOfHotel
        binding.rvRooms.adapter = roomsRecyclerViewAdapter

        viewModel.roomLiveData.observe(viewLifecycleOwner) { response ->
            binding.progressBar.visibility = View.GONE

            if (response.code() == 200) {
                roomsRecyclerViewAdapter.submitList(response?.body()?.rooms)
            } else {
                ErrorDialog(
                    "Error ${response.code()}",
                    response.message(),
                ).show(requireActivity().supportFragmentManager, "ErrorDialog")
            }
        }

        viewModel.errorLiveData.observe(viewLifecycleOwner) { error ->
            binding.progressBar.visibility = View.GONE
            ErrorDialog(
                "Some error",
                error,
            ).show(requireActivity().supportFragmentManager, "ErrorDialog")
        }

        getRoomsData()
    }

    private fun getRoomsData() {
        binding.progressBar.visibility = View.VISIBLE
        viewModel.getRoomsData()
    }
}
