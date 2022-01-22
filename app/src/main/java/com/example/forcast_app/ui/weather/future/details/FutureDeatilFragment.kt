package com.example.forcast_app.ui.weather.future.details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.forcast_app.R

class FutureDeatilFragment : Fragment() {

    companion object {
        fun newInstance() = FutureDeatilFragment()
    }

    private lateinit var viewModel: FutureDeatilViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.future_deatil_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FutureDeatilViewModel::class.java)
        // TODO: Use the ViewModel
    }

}