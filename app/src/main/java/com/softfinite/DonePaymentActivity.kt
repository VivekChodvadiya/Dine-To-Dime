package com.softfinite

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.softfinite.adapter.HomePageAreaAdapter
import com.softfinite.utils.ExitStrategy
import kotlinx.android.synthetic.main.activity_done.*
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Softfinite (Viv'Ek Chodvadiya) on 13-Jun-18.
 */

class DonePaymentActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_done)
        initDrawer()
        initBack(false)
//        initNotification()
        init()
    }

    private fun init() {
        setTitleText("Payment")

        btnFeedback.setOnClickListener {
            val changePage = Intent(getActivity(), FeedbackActivity::class.java)
            startNewActivity(changePage)
        }

        btnBackFromPay.setOnClickListener {
            finishAffinity()
            val changePage = Intent(getActivity(), MainActivity::class.java)
            startNewActivity(changePage)
        }
    }

}
