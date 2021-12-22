package ru.komar.lifeassistant

import leakcanary.LeakCanary

internal open class DebugApp : App() {

    override fun onCreate() {
        super.onCreate()

        LeakCanary.config = LeakCanary.config.copy(requestWriteExternalStoragePermission = true)
    }
}
