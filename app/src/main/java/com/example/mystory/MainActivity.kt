package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private var drawerLayout : DrawerLayout? = null
    private var toolbarView : Toolbar? = null
    private var navigationView:NavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val  email = intent.getStringExtra("email")

        connectView()

        setSupportActionBar(toolbarView)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setUpDrawer()
        updateEmailHeader(email!!)
        drawerClicks()
    }

    private fun updateEmailHeader(email:String){
        val headerView = navigationView?.getHeaderView(0)
        val textViewEmail = headerView?.findViewById<TextView>(R.id.tvEmaili)
        textViewEmail?.text = email
    }
    private fun connectView(){
        drawerLayout = findViewById(R.id.drawerlayouti)
        toolbarView = findViewById(R.id.toolbari)
        navigationView = findViewById(R.id.navigationi)
    }
    private fun setUpDrawer(){
        val toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout?.addDrawerListener(toggle)
        toggle.syncState()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){android.R.id.home -> {drawerLayout?.openDrawer(GravityCompat.START)
                                                  true}
                    else -> true
                                }
    }
    private fun drawerClicks(){
        navigationView?.setNavigationItemSelectedListener {
            when(it.itemId){R.id.homei ->{
                drawerLayout?.closeDrawer(GravityCompat.START)
                true
            }
                R.id.logout ->{
                    finish()
                    val  i = Intent(this,LoginActtivity::class.java)
                            startActivity(i)
                    true
                }
                else -> true
        }

        }
    }

}