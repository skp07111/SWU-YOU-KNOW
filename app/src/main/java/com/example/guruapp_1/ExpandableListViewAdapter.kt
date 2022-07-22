package com.example.guruapp_1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView

class ExpandableListViewAdapter internal constructor(private val context: Context, private val categoryList: List<String>, private val menuList: HashMap<String, List<String>>):
    BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {
        return categoryList.size
    }

    override fun getChildrenCount(p0: Int): Int {
        return this.menuList[this.categoryList[p0]]!!.size
    }

    override fun getGroup(p0: Int): Any {
        return categoryList[p0]
    }

    override fun getChild(p0: Int, p1: Int): Any {
        return this.menuList[this.categoryList[p0]]!![p1]
    }

    override fun getGroupId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return p1.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(
        p0: Int,
        p1: Boolean,
        p2: View?,
        p3: ViewGroup?
    ): View {
        var convertView = p2
        var categoryTitle = getGroup(p0) as String

        if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.category_list, null)
        }

        val categoryTv = convertView!!.findViewById<TextView>(R.id.category_tv)
        categoryTv.setText(categoryTitle)

        return convertView
    }

    override fun getChildView(
        p0: Int,
        p1: Int,
        p2: Boolean,
        p3: View?,
        p4: ViewGroup?
    ): View {
        var convertView = p3
        var menuTitle = getChild(p0, p1) as String

        if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.menu_list, null)
        }

        val menuTv = convertView!!.findViewById<TextView>(R.id.menu_tv)
        menuTv.setText(menuTitle)

        return convertView
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return true
    }
}
