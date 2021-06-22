package com.example.rateappandroid

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    private val pacoteNome = "com.odete.credicard"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.btn_rate_rapp)

        button.setOnClickListener {
            try {
                val uri = Uri.parse("market://details?id=$pacoteNome")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                val uri2 = Uri.parse("http://play.google.com/store/apps/details?id=$pacoteNome")
                val intent2 = Intent(Intent.ACTION_VIEW, uri2)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent2)
            }
        }
    }
}