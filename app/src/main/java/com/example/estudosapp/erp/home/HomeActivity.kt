package com.example.estudosapp.erp.home

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.example.estudosapp.R
import com.example.estudosapp.erp.MainActivity
import com.example.estudosapp.erp.carregarImagens.CarregarImagensActivity
import com.example.estudosapp.erp.contadorPessoas.ContadorPessoasActivity
import com.example.estudosapp.erp.lista.ListaActivity
import com.example.estudosapp.erp.calculadora.CalculadoraActivity
import com.example.estudosapp.erp.usandoSharedPreferences.UsandoSharedPreferencesActivity
import com.example.estudosapp.erp.usandoSqLite.UsandoSqLiteActivity

class HomeActivity : MainActivity() {

    private var listItemMenu = listOf(
        mapOf("key" to  "contador_pessoas", "value" to "Contador de Pessoas"),
        mapOf("key" to "lista", "value" to "Lista"),
        mapOf("key" to "usando_shared_preferences", "value" to "Usando SharedPreferences"),
        mapOf("key" to "usando_sq_lite", "value" to "Usando SQLite"),
        mapOf("key" to "carregar_imagens", "value" to "Carregando Imagens de URLs"),
        mapOf("key" to "calculadora", "value" to "Calculadora")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setMenuList()
    }

    private fun openItemMenu( itemMenu: HomeListItem ){
        currentPage = itemMenu

        var app = when (itemMenu.key) {
            "lista"                     -> ListaActivity()
            "contador_pessoas"          -> ContadorPessoasActivity()
            "usando_shared_preferences" -> UsandoSharedPreferencesActivity()
            "usando_sq_lite"            -> UsandoSqLiteActivity()
            "carregar_imagens"          -> CarregarImagensActivity()
            "calculadora"               -> CalculadoraActivity()
            else -> null
        }

        // Start the new activity.contarHomens
        startActivity(Intent(this, app!!::class.java))
    }

    private fun setMenuList() {
        val listAdapter = getListAdapter()

        val viewList = findViewById<ListView>(R.id.menu_view)
        viewList.adapter = HomeListAdapter(this, listAdapter)
        viewList.setOnItemClickListener { _, _, position, _ ->
            val itemMenu = listAdapter[position]

            openItemMenu(itemMenu)

            Toast.makeText(this, "Selected Item is = "+ itemMenu.label, Toast.LENGTH_SHORT).show()
        }
    }

    private fun getListAdapter() : ArrayList<HomeListItem> {
        val result = ArrayList<HomeListItem>()

        var emp: HomeListItem
        for (i in 0 until listItemMenu.size) {
            val item = listItemMenu[i]

            emp = HomeListItem()
            emp.key = item["key"]
            emp.label = item["value"]
            result.add(emp)
        }

        return result
    }
}
