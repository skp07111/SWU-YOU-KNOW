package com.example.guruapp_1

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_librarycafe.*
import org.w3c.dom.Text
import java.util.*

class LibraryCafeActivity : AppCompatActivity() {

    lateinit var grazieMenu: Button

    var grazie: String = "grazie"
    var gNum: Int = 3
    lateinit var myHelper: myDBHelper
    lateinit var sqlDB: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_librarycafe)

        grazieMenu = findViewById<Button>(R.id.libcafe_button1)

        myHelper = myDBHelper(this)

        grazieMenu.setOnClickListener() {
            sqlDB = myHelper.writableDatabase
            sqlDB.execSQL("DELETE FROM guruTBL WHERE gName = '" + grazie + "';")
            Toast.makeText(applicationContext, "삭제됨", Toast.LENGTH_SHORT).show()
            sqlDB.execSQL("INSERT INTO guruTBL VALUES ( '" + grazie + "' , " + gNum + ");")
            Toast.makeText(applicationContext, "입력됨", Toast.LENGTH_SHORT).show()
//            var intent = Intent(this, GrazieActivity::class.java)
//            startActivity(intent)
        }

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
            R.id.select1_libcafe -> {
                libcafe_button1.setBackgroundResource(R.drawable.button_background1)
                sqlDB.execSQL("UPDATE guruTBL SET gNumber = " + 1 + " WHERE gName = '" + grazie + "';")
                Toast.makeText(applicationContext, "수정됨", Toast.LENGTH_SHORT).show()
            }
            R.id.select2_libcafe -> libcafe_button1.setBackgroundResource(R.drawable.button_background2)
            R.id.select3_libcafe -> libcafe_button1.setBackgroundResource(R.drawable.button_background3)
        }
        return super.onContextItemSelected(item)
    }

    inner class myDBHelper(context: Context) : SQLiteOpenHelper(context, "guruDB", null, 1) {
        override fun onCreate(db: SQLiteDatabase?) {
            db!!.execSQL("CREATE TABLE guruTBL (gName CHAR(50) PRIMARY KEY, gNumber INTEGER);")
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            db!!.execSQL("DROP TABLE IF EXISTS guruTBL")
            onCreate(db)
        }
    }
}




