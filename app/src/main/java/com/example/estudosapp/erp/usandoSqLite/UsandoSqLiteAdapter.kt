package com.example.estudosapp.erp.usandoSqLite

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.estudosapp.R

class UsandoSqLiteAdapter(private var activity: Activity, private var items: ArrayList<UsandoSqlLite>) : BaseAdapter() {

    private class ViewHolder(row: View) {
        var nome: TextView? = null
        var idade: TextView? = null

        init {
            this.nome  = row.findViewById(R.id.usandoSqLiteNome)
            this.idade = row.findViewById(R.id.usandoSqLiteIdade)
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup) : View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            val inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.usando_sq_lite_item_view, null)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var emp = getItem(position)
        viewHolder.nome?.text = emp.name
        viewHolder.idade?.text = emp.age.toString()

        return view
    }

    override fun getItem(i: Int): UsandoSqlLite {
        return items[i]
    }
    override fun getItemId(i: Int): Long {
        return i.toLong()
    }
    override fun getCount(): Int {
        return items.size
    }
}
