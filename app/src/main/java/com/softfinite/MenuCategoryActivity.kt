package com.softfinite

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_category.*

/**
 * Created by Softfinite (Viv'Ek Chodvadiya) on 13-Jun-18.
 */

class MenuCategoryActivity : BaseActivity() {

//    lateinit var menuCategoryAdapter: MenuCategoryAdapter
//    internal lateinit var mLayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_category)
        initDrawer()
        initBack(false)
        initNotification()
        init()
    }

    private fun init() {
        setTitleText("Table No. 2 (Ground Fl.)")


        flComboSelection.setOnClickListener {
            val changePage = Intent(getActivity(), SelectMoreActivity::class.java)
            startNewActivity(changePage)
        }

        flAlaCarte.setOnClickListener {
            val changePage = Intent(getActivity(), SelectMenuActivity::class.java)
            startNewActivity(changePage)
        }
//        mLayoutManager = LinearLayoutManager(getActivity())
//        if (rvAreaList != null) rvAreaList!!.layoutManager = mLayoutManager
//        menuCategoryAdapter = MenuCategoryAdapter(this.getActivity())
//        if (rvAreaList != null) rvAreaList!!.adapter = menuCategoryAdapter
//
//        menuCategoryAdapter.setEventListener(object : MenuCategoryAdapter.EventListener {
//            override fun onItemViewClicked(position: Int) {
//                val changePage = Intent(getActivity(), SelectMenuActivity::class.java)
//                startNewActivity(changePage)
//            }
//        })

    }
}
