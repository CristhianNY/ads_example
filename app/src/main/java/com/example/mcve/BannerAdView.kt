package com.example.mcve

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.view.doOnLayout
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.admanager.AdManagerAdView

@SuppressLint("VisibleForTests")
@Composable
fun BannerAdView(
    isTest: Boolean = false
) {
    val unitId = "/2/androidphone.us.wsj.app/collection"

    AndroidView(
        factory = { context ->
            AdManagerAdView(context).apply {
                setAdSizes(
                    AdSize(AdType.CUBE.width, AdType.CUBE.height),
                    AdSize(AdType.BIG_CUBE.width, AdType.BIG_CUBE.height)
                )
            }
        },
        update = {adManagerView ->
            adManagerView.adUnitId = unitId
            adManagerView.doOnLayout {
                adManagerView.loadAd(AdRequest.Builder().build())
            }
        }
    )
}