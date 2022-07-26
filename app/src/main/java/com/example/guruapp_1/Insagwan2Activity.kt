package com.example.guruapp_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_insagwan.*

class Insagwan2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insagwan)
        registerForContextMenu(insa_button1)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        when (v?.id) {
            R.id.insa_button1 -> {
                menu?.setHeaderTitle("GS25 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_gs, menu)
            }
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.select1_gs -> insa_button1.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_gs -> insa_button1.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_gs -> insa_button1.setBackgroundResource(R.drawable.button_background3)
        }
        return super.onContextItemSelected(item)
    }
}


