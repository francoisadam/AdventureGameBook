package com.github.francoisadam.adventuregamebook.activity

import android.os.Bundle
import android.support.annotation.NonNull
import android.support.design.widget.NavigationView
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.MenuItem
import com.github.francoisadam.adventuregamebook.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        nav_view?.setNavigationItemSelectedListener(this)

        toolbar?.let { setSupportActionBar(it) }
        toolbar.setNavigationOnClickListener {
            home_drawer?.openDrawer(Gravity.START)
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
        supportActionBar?.setHomeButtonEnabled(true)
    }

    override fun onNavigationItemSelected(@NonNull item: MenuItem): Boolean {
        /*when (item.itemId) {
            R.id.menu_settings -> {
                drawerLayout.closeDrawers()
                this.goToSettingsActivity()
                return true
            }
            R.id.menu_attache -> {
                goToFragment(PassportFragment(), true)
                return true
            }
            R.id.menu_demo -> {
                goToFragment(DemoFragment(), true)
                return true
            }
            R.id.menu_tuto ->
                //goToFragment(new TutoFragment(), true);
                return true
        }
        return false*/
        return true
    }
}