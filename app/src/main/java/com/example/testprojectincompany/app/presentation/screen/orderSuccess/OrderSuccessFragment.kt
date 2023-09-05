package com.example.testprojectincompany.app.presentation.screen.orderSuccess

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.testprojectincompany.R
import com.example.testprojectincompany.databinding.FragmentOrderSuccessBinding

class OrderSuccessFragment : Fragment() {
    private lateinit var binding: FragmentOrderSuccessBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentOrderSuccessBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            tvConfirmation.text =
                requireContext().getString(
                    R.string.order_confirmation,
                    (100000..1000000).random().toString(),
                )

            btnBack.setOnClickListener {
                findNavController().navigate(R.id.action_orderSuccessFragment_to_bookingFragment)
            }

            btnMakeOrder.setOnClickListener {
                findNavController().navigate(R.id.action_orderSuccessFragment_to_hotelFragment)
            }
        }
    }
}
