package com.github.francoisadam.adventuregamebook.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.francoisadam.adventuregamebook.R
import kotlinx.android.synthetic.main.activity_auth.*

class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        toolbar?.let { setSupportActionBar(it) }
    }

}