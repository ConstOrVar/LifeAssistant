package ru.komar.lifeassistant

import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.os.StrictMode.VmPolicy
import leakcanary.LeakCanary

internal open class DebugApp : App() {

    override fun onCreate() {
        setupStrictMode()

        super.onCreate()

        LeakCanary.config = LeakCanary.config.copy(requestWriteExternalStoragePermission = true)
    }

    private fun setupStrictMode() {
        StrictMode.setThreadPolicy(
            ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build()
        )
        StrictMode.setVmPolicy(
            VmPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build()
        )
    }
}
