package com.example.sampleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class ServiceActivity : AppCompatActivity() {

    var startServiceBtn : Button ?= null
    var stopServiceBtn : Button ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        startServiceBtn = findViewById(R.id.startBtn)
        stopServiceBtn = findViewById(R.id.stopBtn)

        startServiceBtn!!.setOnClickListener {
            startService(Intent(this, MyService::class.java))
        }

        stopServiceBtn!!.setOnClickListener {
           // Toast.makeText(this , "stop click" , Toast.LENGTH_SHORT).show()
            stopService(Intent(this, MyService::class.java))

        }
    }
}