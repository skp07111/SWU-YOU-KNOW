package com.example.guruapp_1

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TableRow
import java.util.*

class ShuttleBusMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus_main)

        highlight1()
        highlight2()
        highlight3()
        highlight4()
        highlight5()
        highlight6()
        highlight7()
        highlight8()
        highlight9()
        highlight10()
        highlight11()
        highlight12()
        highlight13()
        highlight14()
        highlight15()
        highlight16()
        highlight17()
        highlight18()
        highlight19()
        highlight20()
        highlight21()
        highlight22()
        highlight23()
        highlight24()
        highlight25()
        highlight26()
        highlight27()
        highlight28()
        highlight29()
        highlight30()
        highlight31()
        highlight32()
        highlight33()
        highlight34()
        highlight35()
        highlight36()
        highlight37()
        highlight38()
        highlight39()
        highlight40()
        highlight41()
        highlight42()
        highlight43()
        highlight44()
        highlight45()
        highlight46()
        highlight47()
        highlight48()
        highlight49()

    }

    private fun highlight1() { // ~ 9시 30분

        val table_column1: TableRow
        table_column1 = findViewById(R.id.table_column1)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 1)
        busTime.set(Calendar.MINUTE, 0)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column1.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.HOUR_OF_DAY, 9)
        busTime.set(Calendar.MINUTE, 30)
        busTime.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column1.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight2() { // 9시 40분

        val table_column2: TableRow
        table_column2 = findViewById(R.id.table_column2)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 9)
        busTime.set(Calendar.MINUTE, 30)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column2.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 40)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column2.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight3() { // 9시 50분

        val table_column3: TableRow
        table_column3 = findViewById(R.id.table_column3)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 9)
        busTime.set(Calendar.MINUTE, 40)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column3.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 50)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column3.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight4() { // 10시

        val table_column4: TableRow
        table_column4 = findViewById(R.id.table_column4)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 9)
        busTime.set(Calendar.MINUTE, 50)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column4.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.HOUR_OF_DAY, 10)
        busTime.set(Calendar.MINUTE, 0)
        busTime.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column4.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight5() { // 10시 10분

        val table_column5: TableRow
        table_column5 = findViewById(R.id.table_column5)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 10)
        busTime.set(Calendar.MINUTE, 0)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column5.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 10)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column5.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight6() { // 10시 20분

        val table_column6: TableRow
        table_column6 = findViewById(R.id.table_column6)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 10)
        busTime.set(Calendar.MINUTE, 10)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column6.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 20)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column6.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight7() { // 10시 30분

        val table_column7: TableRow
        table_column7 = findViewById(R.id.table_column7)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 10)
        busTime.set(Calendar.MINUTE, 20)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column7.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 30)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column7.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight8() { // 10시 40분

        val table_column8: TableRow
        table_column8 = findViewById(R.id.table_column8)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 10)
        busTime.set(Calendar.MINUTE, 30)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column8.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 40)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column8.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight9() { // 10시 50분

        val table_column9: TableRow
        table_column9 = findViewById(R.id.table_column9)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 10)
        busTime.set(Calendar.MINUTE, 40)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column9.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 50)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column9.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight10() { // 11시

        val table_column10: TableRow
        table_column10 = findViewById(R.id.table_column10)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 10)
        busTime.set(Calendar.MINUTE, 50)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column10.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.HOUR_OF_DAY, 11)
        busTime.set(Calendar.MINUTE, 0)
        busTime.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column10.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight11() { // 11시 15분

        val table_column11: TableRow
        table_column11 = findViewById(R.id.table_column11)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 11)
        busTime.set(Calendar.MINUTE, 0)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column11.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 15)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column11.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight12() { // 11시 30분

        val table_column12: TableRow
        table_column12 = findViewById(R.id.table_column12)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 11)
        busTime.set(Calendar.MINUTE, 15)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column12.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 30)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column12.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight13() { // 11시 45분

        val table_column13: TableRow
        table_column13 = findViewById(R.id.table_column13)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 11)
        busTime.set(Calendar.MINUTE, 30)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column13.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 45)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column13.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight14() { // 12시

        val table_column14: TableRow
        table_column14 = findViewById(R.id.table_column14)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 11)
        busTime.set(Calendar.MINUTE, 45)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column14.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.HOUR_OF_DAY, 12)
        busTime.set(Calendar.MINUTE, 0)
        busTime.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column14.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight15() { // 12시 20분

        val table_column15: TableRow
        table_column15 = findViewById(R.id.table_column15)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 12)
        busTime.set(Calendar.MINUTE, 0)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column15.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 20)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column15.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight16() { // 12시 40분

        val table_column16: TableRow
        table_column16 = findViewById(R.id.table_column16)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 12)
        busTime.set(Calendar.MINUTE, 20)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column16.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 40)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column16.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight17() { // 13시

        val table_column17: TableRow
        table_column17 = findViewById(R.id.table_column17)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 12)
        busTime.set(Calendar.MINUTE, 40)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column17.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.HOUR_OF_DAY, 13)
        busTime.set(Calendar.MINUTE, 0)
        busTime.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column17.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight18() { // 13시 15분

        val table_column18: TableRow
        table_column18 = findViewById(R.id.table_column18)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 13)
        busTime.set(Calendar.MINUTE, 0)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column18.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 15)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column18.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight19() { // 13시 30분

        val table_column19: TableRow
        table_column19 = findViewById(R.id.table_column19)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 13)
        busTime.set(Calendar.MINUTE, 15)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column19.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 30)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column19.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight20() { // 13시 45분

        val table_column20: TableRow
        table_column20 = findViewById(R.id.table_column20)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 13)
        busTime.set(Calendar.MINUTE, 30)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column20.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 45)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column20.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight21() { // 14시

        val table_column21: TableRow
        table_column21 = findViewById(R.id.table_column21)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 13)
        busTime.set(Calendar.MINUTE, 45)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column21.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.HOUR_OF_DAY, 14)
        busTime.set(Calendar.MINUTE, 0)
        busTime.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column21.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight22() { // 14시 15분

        val table_column22: TableRow
        table_column22 = findViewById(R.id.table_column22)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 14)
        busTime.set(Calendar.MINUTE, 0)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column22.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 15)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column22.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight23() { // 14시 30분

        val table_column23: TableRow
        table_column23 = findViewById(R.id.table_column23)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 14)
        busTime.set(Calendar.MINUTE, 15)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column23.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 30)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column23.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight24() { // 14시 45분

        val table_column24: TableRow
        table_column24 = findViewById(R.id.table_column24)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 14)
        busTime.set(Calendar.MINUTE, 30)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column24.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 45)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column24.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight25() { // 15시

        val table_column25: TableRow
        table_column25 = findViewById(R.id.table_column25)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 14)
        busTime.set(Calendar.MINUTE, 45)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column25.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.HOUR_OF_DAY, 15)
        busTime.set(Calendar.MINUTE, 0)
        busTime.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column25.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight26() { // 15시 15분

        val table_column26: TableRow
        table_column26 = findViewById(R.id.table_column26)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 15)
        busTime.set(Calendar.MINUTE, 0)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column26.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 15)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column26.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight27() { // 15시 30분

        val table_column27: TableRow
        table_column27 = findViewById(R.id.table_column27)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 15)
        busTime.set(Calendar.MINUTE, 15)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column27.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 30)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column27.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight28() { // 15시 45분

        val table_column28: TableRow
        table_column28 = findViewById(R.id.table_column28)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 15)
        busTime.set(Calendar.MINUTE, 30)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column28.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 45)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column28.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight29() { // 16시

        val table_column29: TableRow
        table_column29 = findViewById(R.id.table_column29)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 15)
        busTime.set(Calendar.MINUTE, 45)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column29.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.HOUR_OF_DAY, 16)
        busTime.set(Calendar.MINUTE, 0)
        busTime.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column29.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight30() { // 16시 15분

        val table_column30: TableRow
        table_column30 = findViewById(R.id.table_column30)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 16)
        busTime.set(Calendar.MINUTE, 0)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column30.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 15)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column30.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight31() { // 16시 30분

        val table_column31: TableRow
        table_column31 = findViewById(R.id.table_column31)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 16)
        busTime.set(Calendar.MINUTE, 15)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column31.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 30)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column31.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight32() { // 16시 40분

        val table_column32: TableRow
        table_column32 = findViewById(R.id.table_column32)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 16)
        busTime.set(Calendar.MINUTE, 30)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column32.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 40)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column32.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight33() { // 16시 50분

        val table_column33: TableRow
        table_column33 = findViewById(R.id.table_column33)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 16)
        busTime.set(Calendar.MINUTE, 40)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column33.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 50)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column33.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight34() { // 17시

        val table_column34: TableRow
        table_column34 = findViewById(R.id.table_column34)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 16)
        busTime.set(Calendar.MINUTE, 50)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column34.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.HOUR_OF_DAY, 17)
        busTime.set(Calendar.MINUTE, 0)
        busTime.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column34.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight35() { // 17시 10분

        val table_column35: TableRow
        table_column35 = findViewById(R.id.table_column35)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 17)
        busTime.set(Calendar.MINUTE, 0)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column35.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.HOUR_OF_DAY, 17)
        busTime.set(Calendar.MINUTE, 10)
        busTime.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column35.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight36() { // 17시 20분

        val table_column36: TableRow
        table_column36 = findViewById(R.id.table_column36)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 17)
        busTime.set(Calendar.MINUTE, 10)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column36.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 20)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column36.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight37() { // 17시 30분

        val table_column37: TableRow
        table_column37 = findViewById(R.id.table_column37)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 17)
        busTime.set(Calendar.MINUTE, 20)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column37.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 30)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column37.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight38() { // 17시 40분

        val table_column38: TableRow
        table_column38 = findViewById(R.id.table_column38)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 17)
        busTime.set(Calendar.MINUTE, 30)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column38.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 40)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column38.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight39() { // 17시 50분

        val table_column39: TableRow
        table_column39 = findViewById(R.id.table_column39)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 17)
        busTime.set(Calendar.MINUTE, 40)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column39.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 50)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column39.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight40() { // 18시

        val table_column40: TableRow
        table_column40 = findViewById(R.id.table_column40)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 17)
        busTime.set(Calendar.MINUTE, 50)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column40.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.HOUR_OF_DAY, 18)
        busTime.set(Calendar.MINUTE, 0)
        busTime.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column40.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight41() { // 18시 10분

        val table_column41: TableRow
        table_column41 = findViewById(R.id.table_column41)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 18)
        busTime.set(Calendar.MINUTE, 0)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column41.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 10)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column41.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight42() { // 18시 20분

        val table_column42: TableRow
        table_column42 = findViewById(R.id.table_column42)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 18)
        busTime.set(Calendar.MINUTE, 10)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column42.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 20)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column42.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight43() { // 18시 30분

        val table_column43: TableRow
        table_column43 = findViewById(R.id.table_column43)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 18)
        busTime.set(Calendar.MINUTE, 20)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column43.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 30)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column43.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight44() { // 18시 45분

        val table_column44: TableRow
        table_column44 = findViewById(R.id.table_column44)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 18)
        busTime.set(Calendar.MINUTE, 30)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column44.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 45)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column44.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight45() { // 19시

        val table_column45: TableRow
        table_column45 = findViewById(R.id.table_column45)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 18)
        busTime.set(Calendar.MINUTE, 45)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column45.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.HOUR_OF_DAY, 19)
        busTime.set(Calendar.MINUTE, 0)
        busTime.set(Calendar.SECOND, 0)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column45.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight46() { // 19시 15분

        val table_column46: TableRow
        table_column46 = findViewById(R.id.table_column46)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 19)
        busTime.set(Calendar.MINUTE, 0)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column46.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 15)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column46.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight47() { // 19시 30분

        val table_column47: TableRow
        table_column47 = findViewById(R.id.table_column47)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 19)
        busTime.set(Calendar.MINUTE, 15)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column47.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 30)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column47.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight48() { // 19시 45분

        val table_column48: TableRow
        table_column48 = findViewById(R.id.table_column48)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 19)
        busTime.set(Calendar.MINUTE, 30)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column48.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.MINUTE, 45)

        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column48.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    private fun highlight49() { // 20시

        val table_column49: TableRow
        table_column49 = findViewById(R.id.table_column49)

        val busTime = Calendar.getInstance()
        busTime.set(Calendar.HOUR_OF_DAY, 19)
        busTime.set(Calendar.MINUTE, 45)
        busTime.set(Calendar.SECOND, 0)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column49.setBackgroundColor(Color.LTGRAY)
            }
        }, busTime.time)

        busTime.set(Calendar.HOUR_OF_DAY, 20)
        busTime.set(Calendar.MINUTE, 0)
        busTime.set(Calendar.SECOND, 0)


        timer.schedule(object : TimerTask() {
            override fun run() {
                table_column49.setBackgroundColor(Color.WHITE)
            }
        }, busTime.time)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.bus_menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId) {
            R.id.action_vacation -> {
                val intent = Intent(this, VacationActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_qna -> {
                val intent = Intent(this, QnaActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}