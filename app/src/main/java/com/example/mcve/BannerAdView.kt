package com.example.mcve

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.admanager.AdManagerAdView

@SuppressLint("VisibleForTests")
@Composable
fun BannerAdView(
    isTest: Boolean = false
) {
    val unitId = "ca-app-pub-3940256099942544/6300978111"

    AndroidView(
        factory = { context ->
            AdManagerAdView(context).apply {
                setAdSizes(
                    AdSize(AdType.CUBE.width, AdType.CUBE.height),
                    AdSize(AdType.BIG_CUBE.width, AdType.BIG_CUBE.height)
                )
                adUnitId = unitId
                loadAd(AdRequest.Builder().build())
            }
        }
    )
}