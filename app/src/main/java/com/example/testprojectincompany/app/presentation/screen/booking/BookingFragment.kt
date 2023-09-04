package com.example.testprojectincompany.app.presentation.screen.booking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.testprojectincompany.app.di.DaggerAppComponent
import com.example.testprojectincompany.app.presentation.dialog.ErrorDialog
import com.example.testprojectincompany.databinding.FragmentBookingBinding
import javax.inject.Inject

class BookingFragment : Fragment() {
    private lateinit var binding: FragmentBookingBinding

    @Inject
    lateinit var viewModelFactory: BookingViewModelFactory
    private lateinit var viewModel: BookingViewModel
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
            .get(BookingViewModel::class.java)

        binding = FragmentBookingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.bookingLiveData.observe(viewLifecycleOwner) { response ->
            binding.progressBar.visibility = View.GONE

            if (response.code() == 200) {

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

        getBookingData()
    }

    private fun getBookingData() {
        binding.progressBar.visibility = View.VISIBLE
        viewModel.getBookingData()
    }
}
