package com.example.verservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerForContextMenu(imageViewCM)

        buttonStart.setOnClickListener {
            var i = Intent(this,MyService::class.java)
            startService(i)
        }

        buttonStop.setOnClickListener {
            var i = Intent(this, MyService::class.java)
            stopService(i)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.mymenu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        var myId = item.itemId

        if(R.id.mytoast == myId){
            Toast.makeText(this,"Toast item selected",Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {

        menuInflater.inflate(R.menu.mymenu,menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }
}