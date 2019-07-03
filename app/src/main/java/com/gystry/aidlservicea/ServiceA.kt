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

    class MyBind : MyAidlService.Stub() {
        override fun basicTypes(
            anInt: Int,
            aLong: Long,
            aBoolean: Boolean,
            aFloat: Float,
            aDouble: Double,
            aString: String?
        ) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getString(): String? {
            Log.e("ServiceA.MyBind", "getString")
            return "这是服务器的aidl给你的字符串"
        }
    }
//    class MyBind : Binder() {
//        fun getString():String {
//            Log.e("ServiceA", "getString")
//            return "服务中返回的字符串"
//        }
//    }
}