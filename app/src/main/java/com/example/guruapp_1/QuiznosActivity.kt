package com.example.guruapp_1

import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ExpandableListAdapter
import android.widget.Toast
import com.example.guruapp_1.R.drawable
import kotlinx.android.synthetic.main.activity_main.*

class QuiznosActivity : AppCompatActivity() {
//         listView.onItemClickListener = AdapterView.OnItemClickListener{parent, view, position, id ->
//            val selectItem = parent.getItemAtPosition(position)
//            Toast.makeText(this, selectItem.toString(), Toast.LENGTH_SHORT).show()
//        }

    private lateinit var listViewAdapter: ExpandableListAdapter
    private lateinit var categoryList : List<String>
    private lateinit var menuList : HashMap<String, List<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showList() // this function is call before adapter set

        listViewAdapter = ExpandableListViewAdapter(this, categoryList, menuList)
        eListView.setAdapter(listViewAdapter)
    }

    private fun showList() {
        categoryList = ArrayList()
        menuList = HashMap()

        (categoryList as ArrayList<String>).add("Value")
        (categoryList as ArrayList<String>).add("Chicken & Turkey")
        (categoryList as ArrayList<String>).add("Deli")
        (categoryList as ArrayList<String>).add("Steak")
        (categoryList as ArrayList<String>).add("Bread Bowl Soup")
        (categoryList as ArrayList<String>).add("Soup")
        (categoryList as ArrayList<String>).add("Salad")
        (categoryList as ArrayList<String>).add("Pizza")
        (categoryList as ArrayList<String>).add("Combo")
        (categoryList as ArrayList<String>).add("Coffee & Beverage")

        val menu1 : MutableList<String> = ArrayList()
        menu1.add("햄&치즈")
        menu1.add("씨푸드 클래식")
        menu1.add("스파이시 햄")

        val menu2 : MutableList<String> = ArrayList()
        menu2.add("치킨 까르보나라")
        menu2.add("치킨 베이컨 랜치")
        menu2.add("허니 머스타드 치킨")
        menu2.add("크레이지 핫 치킨")
        menu2.add("터키 랜치 스위스")
        menu2.add("터키&아보카도")

        val menu3 : MutableList<String> = ArrayList()
        menu3.add("트레디셔널")
        menu3.add("이탈리안")
        menu3.add("더블 베이컨 BLT")
        menu3.add("리코타 베지 & 아보카도")

        val menu4 : MutableList<String> = ArrayList()
        menu4.add("더블 치즈 스테이크")
        menu4.add("제스티 그릴드 스테이크")

        val menu5 : MutableList<String> = ArrayList()
        menu5.add("컨츄리 프렌치 치킨")
        menu5.add("보스톤 클램 차우더")

        val menu6 : MutableList<String> = ArrayList()
        menu6.add("브로콜리 치즈")
        menu6.add("클램 차우더")

        val menu7 : MutableList<String> = ArrayList()
        menu7.add("씨푸드 샐러드")
        menu7.add("허니 머스타드 치킨 샐러드")
        menu7.add("이탈리안 샐러드\n5,900")

       val menu8 : MutableList<String> = ArrayList()
        menu8.add("1")
        menu8.add("2")
        menu8.add("3")

        val menu9 : MutableList<String> = ArrayList()
        menu9.add("1")
        menu9.add("2")
        menu9.add("3")

        val menu10 : MutableList<String> = ArrayList()
        menu10.add("1")
        menu10.add("2")
        menu10.add("3")

        menuList[categoryList[0]] = menu1
        menuList[categoryList[1]] = menu2
        menuList[categoryList[2]] = menu3
        menuList[categoryList[3]] = menu4
        menuList[categoryList[4]] = menu5
        menuList[categoryList[5]] = menu6
        menuList[categoryList[6]] = menu7
        menuList[categoryList[7]] = menu8
        menuList[categoryList[8]] = menu9
        menuList[categoryList[9]] = menu10
    }
}