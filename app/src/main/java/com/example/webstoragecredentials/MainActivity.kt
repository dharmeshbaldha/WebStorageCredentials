package com.example.webstoragecredentials

import android.app.ProgressDialog
import android.content.Context
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.webstoragecredentials.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.webView?.settings?.javaScriptEnabled = true
        binding?.webView?.settings?.loadsImagesAutomatically = true
        binding?.webView?.settings?.useWideViewPort = true
        binding?.webView?.settings?.loadWithOverviewMode = true
        binding?.webView?.settings?.setSupportZoom(true);
        binding?.webView?.settings?.builtInZoomControls = true; // allow pinch to zooom
        binding?.webView?.settings?.displayZoomControls = false
        binding?.webView?.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY

        binding?.webView?.webViewClient = (object : WebViewClient() {
            val progressDialog: ProgressDialog? = ProgressDialog(this@MainActivity)
            override fun onPageStarted(view: WebView, url: String, favicon: Bitmap) {
                super.onPageStarted(view, url, favicon)
                progressDialog?.show()
            }



            override fun onPageCommitVisible(
                view: WebView,
                url: String
            ) {
                super.onPageCommitVisible(view, url)
                progressDialog?.dismiss()
            }
        })
        binding?.webView?.loadUrl("https://transaction.maxbupa.com/pages/login.aspx")


    }
}