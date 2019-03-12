package com.example.estudosapp.erp.quizz

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.estudosapp.R

class QuizzResultadoAdapter(private var activity: Activity, private var items: ArrayList<QuizzResultado>) : BaseAdapter() {

    private class ViewHolder(row: View?) {
        var position: TextView? = null
        var nome: TextView? = null
        var pontuacao: TextView? = null

        init {
            this.position = row?.findViewById(R.id.quizzHomeResultadoPosicao)
            this.nome = row?.findViewById(R.id.quizzHomeResultadoNome)
            this.pontuacao = row?.findViewById(R.id.quizzHomeResultadoPontuacao)
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup) : View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            val inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.quizz_home_resultado_item, null)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var obj = getItem(position)
        if (obj.emptyItem) {
            viewHolder.position?.text = "-"
            viewHolder.nome?.text = obj.name
            viewHolder.pontuacao?.text = "-"
        } else {
            viewHolder.position?.text = (position + 1).toString()
            viewHolder.nome?.text = obj.name
            viewHolder.pontuacao?.text = obj.pontuacao.toString()
        }

        return view
    }

    override fun getItem(i: Int): QuizzResultado {
        return items[i]
    }
    override fun getItemId(i: Int): Long {
        return i.toLong()
    }
    override fun getCount(): Int {
        return items.size
    }

}