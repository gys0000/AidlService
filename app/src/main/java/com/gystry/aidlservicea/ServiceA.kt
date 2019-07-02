package com.gystry.aidlservicea

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class ServiceA : Service() {

    override fun onCreate() {
        super.onCreate()
        Log.e("ServiceA", "onCreate")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("ServiceA", "onDestroy")
    }

    override fun onBind(intent: Intent?): IBinder {
        return MyBind()
    }

    class MyBind : Binder() {
        fun getString() {

        }
    }
}