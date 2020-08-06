package com.example.testrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.testrecyclerview.R
import com.example.testrecyclerview.model.Person
import kotlinx.android.synthetic.main.item_person.view.*
import java.sql.RowId


class PersonAdapter(var personList: ArrayList<Person>) :
    RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    var clickListener: ClickListener? = null

    fun setOnClickListener(clickListener: ClickListener) {
        this.clickListener = clickListener

    }

    inner class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        lateinit var person: Person

        fun bindPerson(person: Person) {
            itemView.cart1.setImageResource(person.image)

            itemView.text1.text = person.name

        }

        override fun onClick(p0: View?) {
            clickListener?.click(person)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_person, parent, false)
        return PersonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        return holder.bindPerson(personList[position])
    }

    interface ClickListener {
        fun click(person: Person)
    }
}



