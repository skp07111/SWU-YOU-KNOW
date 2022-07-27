package com.example.guruapp_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_science2.*

class Science2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_science2)
        registerForContextMenu(sci2_button1)
        registerForContextMenu(sci2_button2)
        registerForContextMenu(sci2_button3)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        when (v?.id) {
            R.id.sci2_button1 -> {
                menu?.setHeaderTitle("2층 로비 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_sci2_1, menu)
            }
            R.id.sci2_button2 -> {
                menu?.setHeaderTitle("1층 로비 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_sci2_2, menu)
            }
            R.id.sci2_button3 -> {
                menu?.setHeaderTitle("B1층 로비 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_sci2_3, menu)
            }
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.select1_sci2_1 -> sci2_button1.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_sci2_1 -> sci2_button1.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_sci2_1 -> sci2_button1.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_sci2_2 -> sci2_button2.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_sci2_2 -> sci2_button2.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_sci2_2 -> sci2_button2.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_sci2_3 -> sci2_button3.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_sci2_3 -> sci2_button3.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_sci2_3 -> sci2_button3.setBackgroundResource(R.drawable.button_background3)
        }
        return super.onContextItemSelected(item)
    }
}


