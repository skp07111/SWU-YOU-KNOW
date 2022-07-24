package com.example.guruapp_1

import android.app.ProgressDialog.show
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.nurigwan.*

class NurigwanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nurigwan)
        registerForContextMenu(button1)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        when (v?.id) {
            R.id.button1 -> {
                menu?.setHeaderTitle("혼잡도")
                menuInflater.inflate(R.menu.popup_menu, menu)
            }
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.select1 -> button1.setBackgroundResource(R.drawable.button_background1)
            R.id.select2 -> button1.setBackgroundResource(R.drawable.button_background2)
            R.id.select3 -> button1.setBackgroundResource(R.drawable.button_background3)
        }
        return super.onContextItemSelected(item)
    }
}