package com.softfinite

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.*
import com.common.view.SimpleListDividerDecorator
import com.softfinite.adapter.MenuTablesListAdapter
import kotlinx.android.synthetic.main.activity_menu_table_list.*


/**
 * Created by Softfinite (Viv'Ek Chodvadiya) on 13-Jun-18.
 */

class MenuTableListActivity : BaseActivity() {

    lateinit var menuTableListAdapter: MenuTablesListAdapter
    internal lateinit var mLayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_table_list)
        initDrawer()
        initBack(false)
        initNotification()
        init()
    }

    private fun init() {
        setTitleText("Menu Tables")

        mLayoutManager = LinearLayoutManager(getActivity())
        if (rvMenuTableList != null) rvMenuTableList!!.layoutManager = mLayoutManager
        menuTableListAdapter = MenuTablesListAdapter(this.getActivity())
        if (rvMenuTableList != null) rvMenuTableList!!.adapter = menuTableListAdapter
        rvMenuTableList.addItemDecoration(SimpleListDividerDecorator(getResources().getDrawable(R.drawable.list_divider), true))

        menuTableListAdapter.setEventListener(object : MenuTablesListAdapter.EventListener {
            override fun onItemMoreClicked(position: Int, imgMoreOption: ImageView) {

            }

            override fun onItemViewClicked(position: Int) {
                val changePage = Intent(getActivity(), MenuCategoryActivity::class.java)
                startNewActivity(changePage)
            }
        })

        btnAdddOrder.setOnClickListener {
            val changePage = Intent(getActivity(), TakeAwayActivity::class.java)
            startNewActivity(changePage)
        }
    }

}
