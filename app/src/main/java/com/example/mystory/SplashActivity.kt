package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        moveToLginScreen()

    }
    private fun moveToLginScreen(){
              /*لعمل تاخيير للاكواد*/
        Handler(Looper.myLooper()!!).postDelayed({
            /* داله تستخدم لحذف الواجهة من الذاكرة*/
            finish()
            val i = Intent(this , LoginActtivity::class.java)

            startActivity(i)
        },3000)

    }

}