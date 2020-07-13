package com.govi.pokemon.app

import androidx.multidex.MultiDexApplication
import com.govi.pokemon.BuildConfig.DEBUG
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class CleanArchModular : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        if (DEBUG) Timber.plant(Timber.DebugTree())
    }

}