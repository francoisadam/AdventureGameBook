package com.github.francoisadam.adventuregamebook.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.github.francoisadam.adventuregamebook.R
import com.github.francoisadam.adventuregamebook.activity.HomeActivity
import kotlinx.android.synthetic.main.fragment_load.*

class LoadFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_load, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        start.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_loadFragment_to_homeActivity)
            activity?.finish()
        }
    }

    override fun onResume() {
        super.onResume()
        activity?.takeIf { act -> act is HomeActivity }?.let { act ->
            (act as HomeActivity).setupBackButton()
        }
    }
}