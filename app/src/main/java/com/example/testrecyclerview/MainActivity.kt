package com.example.testrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testrecyclerview.adapter.PersonAdapter
import com.example.testrecyclerview.model.Person
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), PersonAdapter.ClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_person)


        var personList = ArrayList<Person>()

        personList.add(Person(R.drawable.img1, "GrandFather Cat"))
        personList.add(Person(R.drawable.img2, "GrandMother Cat"))
        personList.add(Person(R.drawable.img3, "Father Cat"))
        personList.add(Person(R.drawable.img1, "Mother Cat"))
        personList.add(Person(R.drawable.img2, "Older Brother Cat"))
        personList.add(Person(R.drawable.img2, "Older Sister Cat"))
        personList.add(Person(R.drawable.img3, "My Cat"))
        personList.add(Person(R.drawable.img1, "Younger Sister Cat"))
        personList.add(Person(R.drawable.img1, "Younger Brother Cat"))

        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)


        var personAdapter = PersonAdapter(personList)
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        // recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = personAdapter


        /* recyclerView.apply {
             layoutManager = GridLayoutManager(context,3)
             adapter = PersonAdapter(personList)

         }*/


    }

    override fun click(person: Person) {
        Toast.makeText(this, person.name, Toast.LENGTH_LONG).show()
    }

}