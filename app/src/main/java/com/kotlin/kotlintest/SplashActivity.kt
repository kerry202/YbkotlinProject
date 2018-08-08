package com.kotlin.kotlintest

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.splash_layout.*

/**
 * Created by yangbo on 2018/8/3.
 */
class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_layout)
        val inent = Intent()

        splash_tv.setOnClickListener(View.OnClickListener {
            inent.setClass(this, MainActivity::class.java)
            startActivity(inent)

        })
    }

}