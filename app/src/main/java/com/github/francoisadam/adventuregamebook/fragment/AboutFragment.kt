package com.github.francoisadam.adventuregamebook.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.francoisadam.adventuregamebook.R
import com.github.francoisadam.adventuregamebook.activity.HomeActivity

class AboutFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onResume() {
        super.onResume()
        activity?.takeIf { act -> act is HomeActivity }?.let { act ->
            (act as HomeActivity).setupBackButton()
        }
    }
}