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
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private var drawerLayout: DrawerLayout? = null
    private var toolbarView: Toolbar? = null
    private var navigationView: NavigationView? = null
    private var recyclerView: RecyclerView? = null
    private var buttonAddStory: FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = intent.getStringExtra("email")

        connectView()

        setSupportActionBar(toolbarView)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setUpDrawer()
        try {
            updateEmailHeader(email!!)
        }catch (e:NullPointerException){}
        drawerClicks()
        openAddStoryActivity()
        displayStories()
    }

    private fun updateEmailHeader(email: String) {
        val headerView = navigationView?.getHeaderView(0)
        val textViewEmail = headerView?.findViewById<TextView>(R.id.tvEmaili)
        textViewEmail?.text = email
    }

    private fun connectView() {
        drawerLayout = findViewById(R.id.drawerlayouti)
        toolbarView = findViewById(R.id.toolbari)
        navigationView = findViewById(R.id.navigationi)
        recyclerView = findViewById(R.id.RecyclerViewi)
        buttonAddStory = findViewById(R.id.FloatingActionButtonAddStoryi)
    }

    private fun setUpDrawer() {
        val toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout?.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                drawerLayout?.openDrawer(GravityCompat.START)
                true
            }
            else -> true
        }
    }

    private fun drawerClicks() {
        navigationView?.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.homei -> {
                    drawerLayout?.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.logout -> {
                    finish()
                    val i = Intent(this, LoginActtivity::class.java)
                    startActivity(i)
                    true
                }
                else -> true
            }

        }
    }

    private fun openAddStoryActivity() {
        buttonAddStory?.setOnClickListener {
            val i =Intent(this, AddStoryActivity::class.java)
            startActivity(i)  }
                                         }
    private fun displayStories(){
        val storiesArray = ArrayList<Story>()
        storiesArray . add(Story(getString(R.string.story1_title),getString(R.string.story1_subtitle),getString(R.string.story1_desc)))
        storiesArray . add(Story("T i m s Story","t i subtitle" ,"w t m s i w s y h i l2"))
        storiesArray . add(Story("T i m t Story","t i subtitle" ,"w t m s i w s y h i l3"))

        val customAdapter = CustomAdapter(storiesArray,this)
        recyclerView?.adapter = customAdapter

        if (intent.getStringExtra("title") != null){
            val title = intent.getStringExtra("title")
            val subTitle = intent.getStringExtra("subtitle")
            val desc = intent.getStringExtra("desc")
            val newStory = Story(title!!,subTitle!!,desc!!)
            storiesArray.add(newStory)
        customAdapter.notifyDataSetChanged()}
    }
}