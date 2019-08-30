package com.example.androidapisearchuserkotlinpractice.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidapisearchuserkotlinpractice.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.contentContainer, MainFragment.newInstance())
                .commit()
        }
    }
}
