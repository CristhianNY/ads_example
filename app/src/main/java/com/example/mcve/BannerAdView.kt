package com.example.mcve

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.view.doOnLayout
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.admanager.AdManagerAdView

@SuppressLint("VisibleForTests")
@Composable
fun BannerAdView(
    isTest: Boolean = false
) {
    val unitId = "/2/androidphone.us.wsj.app/markets"

    AndroidView(
        factory = { context ->
            AdManagerAdView(context).apply {
                setAdSizes(
                    AdSize(AdType.CUBE.width, AdType.CUBE.height),
                    AdSize(AdType.BIG_CUBE.width, AdType.BIG_CUBE.height)
                )

                adListener = object : AdListener() {
                    override fun onAdLoaded() {
                        // Este método se llama cuando un anuncio es recibido correctamente.
                        Log.d("AdListener", "El anuncio ha sido cargado correctamente.")
                        this@apply.resume()
                    }

                    override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                        // Este método se llama cuando un anuncio no se puede cargar.
                        Log.d("AdListener", "El anuncio falló al cargarse: ${loadAdError.message}")
                    }

                    override fun onAdOpened() {
                        // Este método se llama cuando el anuncio es clickeado y se abre el anuncio.
                        Log.d("AdListener", "El anuncio ha sido abierto.")
                    }

                    override fun onAdClicked() {
                        // Este método se llama cuando el anuncio es clickeado.
                        Log.d("AdListener", "El anuncio ha sido clickeado.")
                    }

                    override fun onAdClosed() {
                        // Este método se llama cuando el anuncio se cierra.
                        Log.d("AdListener", "El anuncio ha sido cerrado.")
                    }
                }
            }
        },
        update = { adManagerView ->
            adManagerView.adUnitId = unitId
            adManagerView.doOnLayout {
                // Realiza la carga del anuncio después de la pasada de diseño.
                adManagerView.loadAd(AdRequest.Builder().build())
            }
        }

    )
}
