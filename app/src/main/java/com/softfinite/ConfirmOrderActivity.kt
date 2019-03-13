package com.softfinite

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.common.view.SimpleListDividerDecorator
import com.softfinite.adapter.ConfirmOrderAdapter
import kotlinx.android.synthetic.main.activity_confirm_order.*

/**
 * Created by Softfinite (Viv'Ek Chodvadiya) on 13-Jun-18.
 */

class ConfirmOrderActivity : BaseActivity() {

    lateinit var confirmOrderAdapter: ConfirmOrderAdapter
    internal lateinit var mLayoutManager: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_order)
        initDrawer()
        initBack(false)
        initNotification()
        init()
    }

    private fun init() {
        setTitleText("Table No. 2 (Ground Fl.)")

        mLayoutManager = LinearLayoutManager(getActivity())
        if (rvConfirmOrder != null) rvConfirmOrder!!.layoutManager = mLayoutManager
        confirmOrderAdapter = ConfirmOrderAdapter(this.getActivity())
        if (rvConfirmOrder != null) rvConfirmOrder!!.adapter = confirmOrderAdapter
        rvConfirmOrder.addItemDecoration(SimpleListDividerDecorator(getResources().getDrawable(R.drawable.list_divider), true))

        confirmOrderAdapter.setEventListener(object : ConfirmOrderAdapter.EventListener {
            override fun onItemViewClicked(position: Int) {
                val changePage = Intent(getActivity(), SelectMoreCombosSecondActivity::class.java)
                startNewActivity(changePage)
            }

            override fun onItemAddQtyViewClicked(position: Int, llNumberPicker: View, llAddQty: View) {

            }

        })

        btnInvoice.setOnClickListener {
            val changePage = Intent(getActivity(), OrderInvoiceActivity::class.java)
            startNewActivity(changePage)
        }
    }
}
