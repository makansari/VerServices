package com.example.verservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var h = Handler()

        var th = Thread(){
           kotlin.run {
               for(i in 1..5){
                   Thread.sleep(1000)
                   h.post {
                       textViewSplash.setText("" + i)
                   }
               }

           }
            var i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }
        th.start()


    }
}