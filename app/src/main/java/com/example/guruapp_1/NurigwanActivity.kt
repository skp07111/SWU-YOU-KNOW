package com.example.guruapp_1

import android.app.ProgressDialog.show
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.nurigwan.*

class NurigwanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nurigwan)

        var button1 = findViewById<Button>(R.id.button1)

        button1.setOnClickListener {
            var popupMenu = PopupMenu(applicationContext, it)

            menuInflater?.inflate(R.menu.popup_menu, popupMenu.menu)
            popupMenu.show()
            popupMenu.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.select1 -> {
                        return@setOnMenuItemClickListener true
                    }
                    R.id.select2 -> {
                        return@setOnMenuItemClickListener true
                    }
                    R.id.select3 -> {
                        return@setOnMenuItemClickListener true
                    } else -> {
                        return@setOnMenuItemClickListener false
                    }
                }
            }
        }
    }
}