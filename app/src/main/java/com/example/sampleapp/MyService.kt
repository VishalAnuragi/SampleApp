package com.example.sampleapp

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.os.Message
import android.util.Log
import android.R
import android.media.MediaPlayer.OnCompletionListener
import android.provider.Settings
import android.widget.Toast
import java.lang.Exception
import kotlin.concurrent.thread


class MyService : Service() {

    val TAG = "MyService"
    private lateinit var player:MediaPlayer

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        ShowLog("onCreate")
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        ShowLog("onStartCommand")


        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
        player!!.setLooping(true)
        player.start()


        return START_STICKY
    }

    override fun onDestroy() {
        ShowLog("onDestroy")
        super.onDestroy()
        player.stop()

    }

    fun ShowLog(message: String){
        Log.i(TAG , message)
    }
}