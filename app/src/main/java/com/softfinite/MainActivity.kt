package com.softfinite

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.softfinite.adapter.HomePageAreaAdapter
import com.softfinite.utils.Constant
import com.softfinite.utils.ExitStrategy
import com.softfinite.utils.Utils
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Softfinite (Viv'Ek Chodvadiya) on 13-Jun-18.
 */

class MainActivity : BaseActivity() {

    lateinit var homePageAreaAdapter: HomePageAreaAdapter
    internal lateinit var mLayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDrawer()
        initBack(false)
        initNotification()
        init()
    }

    private fun init() {
        setTitleText("Areas")

        mLayoutManager = LinearLayoutManager(getActivity())
        if (rvAreaList != null) rvAreaList!!.layoutManager = mLayoutManager
        homePageAreaAdapter = HomePageAreaAdapter(this.getActivity())
        if (rvAreaList != null) rvAreaList!!.adapter = homePageAreaAdapter

        homePageAreaAdapter.setEventListener(object : HomePageAreaAdapter.EventListener {
            override fun onItemViewClicked(position: Int) {
                val changePage = Intent(getActivity(), MainFloorTableActivity::class.java)
                startNewActivity(changePage)
            }
        })
        Utils.setPref(getActivity(), Constant.IS_FIRST_TIME, true)
    }

    override fun onBackPressed() {
        try {
            if (ExitStrategy.canExit()) {
                super.onBackPressed()
            } else {
                ExitStrategy.startExitDelay(2000)
                Toast.makeText(getActivity(), getString(R.string.exit_msg),
                        Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
