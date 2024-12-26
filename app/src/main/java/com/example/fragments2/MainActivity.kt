package com.example.fragments2

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentTransaction


val notes: MutableList<Note> = mutableListOf()
var count: Int = 1

class MainActivity : AppCompatActivity(), OnFragmentDataListener {

    private lateinit var toolbarMain: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbarMain = findViewById(R.id.toolbarMain)

        setSupportActionBar(toolbarMain)
        title = "Мои заметки"


        val notePadFragment = FirstFragment()
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.containerID, notePadFragment)
                .commit()
        }
    }

    override fun onData(data: String?, position: Int) {
        val bundle = Bundle()
        bundle.putString("text", data)
        bundle.putInt("position", position)
        val transaction = this.supportFragmentManager.beginTransaction()
        val editNoteFragment = EditNoteFragment()
        editNoteFragment.arguments = bundle

        transaction.replace(R.id.containerID, editNoteFragment)
        transaction.addToBackStack(null)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_exit, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_exit -> finishAffinity()
        }
        return super.onOptionsItemSelected(item)
    }
}