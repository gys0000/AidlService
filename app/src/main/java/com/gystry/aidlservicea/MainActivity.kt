package com.gystry.aidlservicea

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var myBind: ServiceA.MyBind? = null

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            myBind = service as ServiceA.MyBind
            myBind?.getString()
        }

        override fun onServiceDisconnected(name: ComponentName) {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_name.text = "hahahah"
        //绑定服务
//        bindService(Intent(this, ServiceA::class.java), connection, Context.BIND_AUTO_CREATE)
//        myBind?.getString()
        //解绑服务
//        unbindService(connection)
    }
}
