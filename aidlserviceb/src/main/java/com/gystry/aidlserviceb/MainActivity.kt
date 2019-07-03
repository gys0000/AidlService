package com.gystry.aidlserviceb

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.Button
import com.gystry.aidlservicea.MyAidlService
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    var myBinder: MyAidlService? = null
    val connect: ServiceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {

        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            Log.e("btn_connect", "onServiceConnected")
            myBinder = MyAidlService.Stub.asInterface(service)
            tv_content.text = myBinder?.string
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_connect.setOnClickListener {
            Log.e("btn_connect", "setOnClickListener")
            val intent = Intent()
            intent.action = "com.gystry.aidlservicea.ServiceA"
            intent.setPackage("com.gystry.aidlservicea")
            bindService(intent, connect, Context.BIND_AUTO_CREATE)
        }
    }
}

