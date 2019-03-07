package com.example.estudosapp.lista

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.example.estudosapp.R

class ListaMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_main)

        setListView()
    }

    private fun setListView() {
        var listAdapter = getListAdapter()

        var viewList = findViewById<ListView>(R.id.lista_view)
        viewList.adapter = MyListAdapter(this, listAdapter)
        viewList.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, "Selected Item is = "+ listAdapter.get(position).nome, Toast.LENGTH_SHORT).show()
        }
    }

    private fun getListAdapter() : ArrayList<ItemList> {
        var result = ArrayList<ItemList>()

        var emp: ItemList = ItemList()
        emp.icone = R.drawable.item1
        emp.nome = "John Clington"
        emp.descricao = "CEO"
        result.add(emp)

        emp = ItemList()
        emp.icone = R.drawable.item2
        emp.nome = "Grey Jonathan"
        emp.descricao = "Senior Developer"
        result.add(emp)

        emp = ItemList()
        emp.icone = R.drawable.item3
        emp.nome = "Barbara Young"
        emp.descricao = "Senior Developer"
        result.add(emp)

        return result
    }

}
