package com.example.estudosapp.erp

import android.support.v7.app.AppCompatActivity
import android.widget.FrameLayout
import com.example.estudosapp.R

open class MainActivity : AppCompatActivity() {

    override fun setContentView(layoutResId: Int) {
        val baseLayout = layoutInflater.inflate(R.layout.activity_main, null)
        val view = layoutInflater.inflate(layoutResId, null)

        super.setContentView(baseLayout)

        val activityContainer = baseLayout.findViewById<FrameLayout>(R.id.activity_content)
        activityContainer.addView(view)

        setToolBar(layoutResId)
    }

    private fun setToolBar(layoutResId: Int) {
        val view = layoutInflater.inflate(layoutResId, null)

        val toolbar = findViewById<android.support.v7.widget.Toolbar>(R.id.main_toolbar)
        val displayUpButton =  R.layout.activity_home != layoutResId

        if (view.background == null) {
            toolbar.setBackgroundDrawable(resources.getDrawable(R.color.topBarBgColor))
        } else {
            toolbar.setBackgroundDrawable( view.background )
        }

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(displayUpButton)
    }

}
