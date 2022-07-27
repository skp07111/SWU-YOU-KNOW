package com.example.guruapp_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_auditorium.*

class AuditoriumActivity : AppCompatActivity() {

    lateinit var pandorothyMenu: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auditorium)

        pandorothyMenu = findViewById<Button>(R.id.aud_button2)

        pandorothyMenu.setOnClickListener() {
            var intent = Intent(this, PandorothyActivity::class.java)
            startActivity(intent)
        }

        registerForContextMenu(aud_button1)
        registerForContextMenu(aud_button2)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        when (v?.id) {
            R.id.aud_button1 -> {
                menu?.setHeaderTitle("교내서점 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_bookstore, menu)
            }
            R.id.aud_button2 -> {
                menu?.setHeaderTitle("팬도로시 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_pandorothy, menu)
            }
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.select1_bookstore -> aud_button1.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_bookstore -> aud_button1.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_bookstore -> aud_button1.setBackgroundResource(R.drawable.button_background3)
            R.id.select1_pandorothy -> aud_button2.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_pandorothy -> aud_button2.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_pandorothy -> aud_button2.setBackgroundResource(R.drawable.button_background3)
        }
        return super.onContextItemSelected(item)
    }
}


