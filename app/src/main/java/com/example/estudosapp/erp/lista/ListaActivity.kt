package com.example.estudosapp.erp.lista

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.example.estudosapp.R
import com.example.estudosapp.erp.MainActivity

class ListaActivity : MainActivity() {

    private var list = listOf(
        mapOf("icone" to  R.drawable.item1, "nome" to "John Clington", "descricao" to "CEO"),
        mapOf("icone" to  R.drawable.item3, "nome" to "Grey Jonathan", "descricao" to "Senior Developer"),
        mapOf("icone" to  R.drawable.item3, "nome" to "Barbara Young", "descricao" to "Senior Developer"),
        mapOf("icone" to  R.drawable.item4, "nome" to "Young", "descricao" to "Senior Developer"),
        mapOf("icone" to  R.drawable.item5, "nome" to "Super Abrobrinha", "descricao" to "Super"),
        mapOf("icone" to  R.drawable.item6, "nome" to "Jaja", "descricao" to "dfasdf"),
        mapOf("icone" to  R.drawable.item7, "nome" to "Kaeuddd", "descricao" to "324234"),
        mapOf("icone" to  R.drawable.item8, "nome" to "afasfasdf", "descricao" to "vcvcv"),
        mapOf("icone" to  R.drawable.item9, "nome" to "cccc", "descricao" to "aaxxvc"),
        mapOf("icone" to  R.drawable.item10, "nome" to "dsssss", "descricao" to "vdvdvd"),
        mapOf("icone" to  R.drawable.item11, "nome" to "vvcccc", "descricao" to "absdg"),
        mapOf("icone" to  R.drawable.item12, "nome" to "aaaaa", "descricao" to "bbfxfg")
    )

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

        var emp: ItemList?
        for (i in 0 until list.size){
            val item = list[i]

            emp = ItemList()
            emp.icone =  item["icone"] as Int
            emp.nome = item["nome"] as String
            emp.descricao = item["descricao"] as String
            result.add(emp)
        }

        return result
    }

}
