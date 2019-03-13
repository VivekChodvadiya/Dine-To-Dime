package com.softfinite

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.softfinite.adapter.AvailablePrinterAdapter
import kotlinx.android.synthetic.main.activity_setting.*

/**
 * Created by Softfinite (Viv'Ek Chodvadiya) on 13-Jun-18.
 */

class SettingActivity : BaseActivity() {


    internal lateinit var mLayoutManager: RecyclerView.LayoutManager
    lateinit var availablePrinterAdapter: AvailablePrinterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        initDrawer()
        initBack(false)
//        initNotification()
        init()
    }

    private fun init() {
        setTitleText("Settings")


        mLayoutManager = GridLayoutManager(getActivity(), 2)
        if (rvPrinters != null) rvPrinters!!.layoutManager = mLayoutManager
        availablePrinterAdapter = AvailablePrinterAdapter(this.getActivity())
        if (rvPrinters != null) rvPrinters!!.adapter = availablePrinterAdapter

    }

}
