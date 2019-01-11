package com.aston.memoroid.common

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.orhanobut.hawk.Hawk

class MemoroidApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        //save
        Hawk.init(this).build()
        //image
        Fresco.initialize(this)
    }
}
