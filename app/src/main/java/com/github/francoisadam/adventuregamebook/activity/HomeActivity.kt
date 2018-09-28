package com.github.francoisadam.adventuregamebook.activity

import android.os.Bundle
import android.support.annotation.NonNull
import android.support.design.widget.NavigationView
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.github.francoisadam.adventuregamebook.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var navController: NavController? = null
    var isBackModeEnabled: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        nav_view?.setNavigationItemSelectedListener(this)

        toolbar?.let { setSupportActionBar(it) }
        toolbar.setNavigationOnClickListener {
            if (isBackModeEnabled) {
                onBackPressed()
            } else {
                home_drawer?.openDrawer(Gravity.START)
            }
        }
    }

    override fun onNavigationItemSelected(@NonNull item: MenuItem): Boolean {
        home_drawer?.closeDrawers()
        when (item.itemId) {
            R.id.menu_character -> {
                navigateWithAction(R.id.action_homeFragment_to_characterSheetFragment)
                return true
            }
            R.id.menu_perks -> {
                navigateWithAction(R.id.action_homeFragment_to_perksFragment)
                return true
            }
            R.id.menu_equipment -> {
                navigateWithAction(R.id.action_homeFragment_to_equipmentFragment)
                return true
            }
            R.id.menu_documents -> {
                navigateWithAction(R.id.action_homeFragment_to_documentFragment)
                return true
            }
            R.id.menu_load -> {
                navigateWithAction(R.id.action_homeFragment_to_authActivity)
                return true
            }
            R.id.menu_help -> {
                navigateWithAction(R.id.action_homeFragment_to_helpFragment)
                return true
            }
            R.id.menu_settings -> {
                navigateWithAction(R.id.action_homeFragment_to_settingsFragment)
                return true
            }
            R.id.menu_about -> {
                navigateWithAction(R.id.action_homeFragment_to_aboutFragment)
                return true
            }
        }
        return false
    }

    private fun navigateWithAction(actionId: Int) {
        navController?.navigate(actionId)
    }

    fun setupBackButton() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back)
        supportActionBar?.setHomeButtonEnabled(true)
        isBackModeEnabled = true
    }

    fun setupHomeButton() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
        supportActionBar?.setHomeButtonEnabled(true)
        isBackModeEnabled = false
    }
}