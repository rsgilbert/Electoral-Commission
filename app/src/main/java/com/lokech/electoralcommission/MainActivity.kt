package com.lokech.electoralcommission

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.navigation.NavigationView
import com.lokech.electoralcommission.databinding.ActivityMainBinding
import com.lokech.electoralcommission.util.openBrowserApp
import com.lokech.electoralcommission.util.openDialerApp
import com.lokech.electoralcommission.util.openEmailApp
import com.lokech.electoralcommission.util.withInfo

class MainActivity : AppCompatActivity() {
    lateinit var drawerLayout: DrawerLayout

    // appBarConfiguration contains top level destinations
    lateinit var appBarConfiguration: AppBarConfiguration

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        setSupportActionBar(binding.toolbar)
        drawerLayout = binding.drawerLayout
        appBarConfiguration =
            AppBarConfiguration(
                setOf(
                    R.id.roadmapFragment,
                    R.id.infoFragment,
                    R.id.pictureListFragment,
                    R.id.partyListFragment
                ),
                drawerLayout
            )
        navController = findNavController(R.id.myNavHostFragment)



        setupActionBar()
        connectDrawerToController(binding.navView)
        setupNavHeader(binding.navView)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.email -> withInfo { openEmailApp(it.email) }
            R.id.website -> withInfo { openBrowserApp(it.website) }
            R.id.facebook -> withInfo { openBrowserApp(it.facebook) }
            R.id.twitter -> withInfo { openBrowserApp(it.twitter) }
            R.id.youtube -> withInfo { openBrowserApp(it.youtube) }
            R.id.telephone -> withInfo { openDialerApp(it.telephone) }
            R.id.tollfree -> withInfo { openDialerApp(it.tollfree) }
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }

    // Allow navigation to previous fragments using up arrow in actionbar
    // AppbarConfiguration provides top level destinations
    override fun onSupportNavigateUp() =
        navController.navigateUp(appBarConfiguration)

}

// Have NavigationUI decide what label to show in the action bar
// It will also determine whether to show up arrow or drawer menu icon
private fun MainActivity.setupActionBar() =
    setupActionBarWithNavController(navController, appBarConfiguration)

// connect navigation drawer to navigation controller
private fun MainActivity.connectDrawerToController(navView: NavigationView) =
    NavigationUI.setupWithNavController(navView, navController)

private fun MainActivity.setupNavHeader(navView: NavigationView) {
    val headerView: View = navView.getHeaderView(0)
    headerView.setOnClickListener {
        navController.navigate(R.id.infoFragment)
        drawerLayout.closeDrawer(GravityCompat.START)
    }
}