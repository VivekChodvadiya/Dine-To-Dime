package com.softfinite

import android.content.Intent
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_take_away.*

/**
 * Created by Softfinite (Viv'Ek Chodvadiya) on 13-Jun-18.
 */

class TakeAwayActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_take_away)
        initDrawer()
        initBack(false)
        initNotification()
        init()
    }

    private fun init() {
        setTitleText("Take Way")

        btnSelectMenu.setOnClickListener {
            val changePage = Intent(getActivity(), MenuTableListActivity::class.java)
            startNewActivity(changePage)
        }

        if (switchIsHomwDel.isChecked) {
            editDelAddress.visibility = View.VISIBLE
            editDelCharges.visibility = View.VISIBLE
            editPersonForDel.visibility = View.VISIBLE

            editPickUpTime.visibility = View.GONE
        } else {
            editPickUpTime.visibility = View.VISIBLE

            editDelAddress.visibility = View.GONE
            editDelCharges.visibility = View.GONE
            editPersonForDel.visibility = View.GONE
        }

        switchIsHomwDel.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                editDelAddress.visibility = View.VISIBLE
                editDelCharges.visibility = View.VISIBLE
                editPersonForDel.visibility = View.VISIBLE

                editPickUpTime.visibility = View.GONE
            } else {
                editPickUpTime.visibility = View.VISIBLE

                editDelAddress.visibility = View.GONE
                editDelCharges.visibility = View.GONE
                editPersonForDel.visibility = View.GONE
            }
        }

    }
}
