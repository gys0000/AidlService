package com.gystry.aidlservicea

import android.content.ComponentName
import android.content.ServiceConnection
import android.os.IBinder

class Demo {
    private var myBind: ServiceA.MyBind? = null
    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            myBind = service as ServiceA.MyBind
        }

        override fun onServiceDisconnected(name: ComponentName) {

        }
    }
}
