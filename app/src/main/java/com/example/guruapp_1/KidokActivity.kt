package com.example.guruapp_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_kidok.*

class KidokActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kidok)
        registerForContextMenu(kidok_button1)
        registerForContextMenu(kidok_button2)
        registerForContextMenu(kidok_button3)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        when (v?.id) {
            R.id.kidok_button1 -> {
                menu?.setHeaderTitle("3층 로비 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_kidok_1, menu)
            }
            R.id.kidok_button2 -> {
                menu?.setHeaderTitle("2층 로비 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_kidok_2, menu)
            }
            R.id.kidok_button3 -> {
                menu?.setHeaderTitle("커뮤니티라운지 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_kidok_3, menu)
            }
        }
    }

    private fun saveData(){
        var pref = this.getPreferences(0)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.select1_kidok_1 -> kidok_button1.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_kidok_1 -> kidok_button1.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_kidok_1 -> kidok_button1.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_kidok_2 -> kidok_button2.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_kidok_2 -> kidok_button2.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_kidok_2 -> kidok_button2.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_kidok_3 -> kidok_button3.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_kidok_3 -> kidok_button3.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_kidok_3 -> kidok_button3.setBackgroundResource(R.drawable.button_background3)
        }
        return super.onContextItemSelected(item)
    }
}


