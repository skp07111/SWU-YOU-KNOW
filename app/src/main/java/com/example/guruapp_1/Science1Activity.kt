package com.example.guruapp_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_anniversary50th.*
import kotlinx.android.synthetic.main.activity_science1.*

class Science1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_science1)
        registerForContextMenu(sci1_button1)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        when (v?.id) {
            R.id.sci1_button1 -> {
                menu?.setHeaderTitle("1층 로비 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_sci1_1, menu)
            }
        }
    }

    private fun saveData(){
        var pref = this.getPreferences(0)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.select1_sci1_1 -> sci1_button1.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_sci1_1 -> sci1_button1.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_sci1_1 -> sci1_button1.setBackgroundResource(R.drawable.button_background3)
        }
        return super.onContextItemSelected(item)
    }
}


