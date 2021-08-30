package com.github.psm.jethouse

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.decode.SvgDecoder

class JetHouseApplication: Application(), ImageLoaderFactory {
    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(applicationContext)
            .componentRegistry {
                add(SvgDecoder(applicationContext))
            }
            .build()
    }
}