package com.sandyara.aula18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen)

        val viewpager = findViewById<ViewPager>(R.id.viewpager1)
        viewpager.adapter = Adapter2(supportFragmentManager)
        val tablayout = findViewById<TabLayout>(R.id.tablayout1)
        tablayout.setupWithViewPager(viewpager)
    }
}