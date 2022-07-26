package com.example.guruapp_1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView


class QnaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus_qna)

        val email = findViewById<View>(R.id.btnemail) as TextView
        val call = findViewById<View>(R.id.btncall) as TextView

        email.setOnClickListener {
            val email = Intent(Intent.ACTION_SEND)
            email.type = "plain/text"
            val address = arrayOf("juwon_0715@naver.com")
            email.putExtra(Intent.EXTRA_EMAIL, address)
            email.putExtra(Intent.EXTRA_SUBJECT, "제목을 입력하세요.")
            email.putExtra(Intent.EXTRA_TEXT, "내용을 입력하세요.")
            startActivity(email)
        }

        call.setOnClickListener {
            val call = Intent(Intent.ACTION_DIAL)
            call.data = Uri.parse("tel:01039218051")
            if(intent.resolveActivity(packageManager) != null) {
                startActivity(call)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.bus_menu_qna, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId) {
            R.id.action_home -> {
                val intent = Intent(this, ShuttleBusMainActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_vacation -> {
                val intent = Intent(this, VacationActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}