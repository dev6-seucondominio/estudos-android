package com.example.estudosapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView

class ListaMainActivity : AppCompatActivity() {

    private var listNames = arrayOf( "Tito", "Android", "Mickey", "Homer", "Mirago", "Jack" )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_main)

        setListView()
    }

    private fun setListView() {
        var viewList = findViewById<ListView>(R.id.lista_view)

        var adapterList = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            listNames
        )

        viewList.adapter = adapterList
        viewList.setOnItemClickListener { parent, view, position, id ->
            Log.d("tsete", "Clicked item :"+" "+position)
        }
    }
}
