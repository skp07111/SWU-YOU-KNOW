package com.example.guruapp_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_librarycafe.*

class LibraryCafeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_librarycafe)
        registerForContextMenu(libcafe_button1)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        when (v?.id) {
            R.id.libcafe_button1 -> {
                menu?.setHeaderTitle("북카페 그라찌에 혼잡도")
                menuInflater.inflate(R.menu.popup_menu_libcafe, menu)
            }
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.select1_libcafe -> libcafe_button1.setBackgroundResource(R.drawable.button_background1)
            R.id.select2_libcafe -> libcafe_button1.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_libcafe -> libcafe_button1.setBackgroundResource(R.drawable.button_background3)
        }
        return super.onContextItemSelected(item)
    }
}




