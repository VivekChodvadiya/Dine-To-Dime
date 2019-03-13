package com.softfinite

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.softfinite.adapter.CartAdapter
import com.softfinite.adapter.ServedItemtAdapter
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.cart_bottomview.*

/**
 * Created by Softfinite (Viv'Ek Chodvadiya) on 13-Jun-18.
 */

class CartActivity : BaseActivity() {
    lateinit var cartAdapter: CartAdapter
    internal lateinit var mLayoutManager: RecyclerView.LayoutManager
    lateinit var servedItemtAdapter: ServedItemtAdapter
    internal lateinit var mLayoutManagerServed: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        initDrawer()
        initBack(false)
        initNotification()
        init()
    }

    private fun init() {
        setTitleText("Table No. 2 (Ground Fl.)")

        mLayoutManager = LinearLayoutManager(getActivity())
        if (rvCartList != null) rvCartList!!.layoutManager = mLayoutManager
        cartAdapter = CartAdapter(this.getActivity())
        if (rvCartList != null) rvCartList!!.adapter = cartAdapter

        mLayoutManagerServed = LinearLayoutManager(getActivity())
        if (rvServedList != null) rvServedList!!.layoutManager = mLayoutManagerServed
        servedItemtAdapter = ServedItemtAdapter(this.getActivity())
        if (rvServedList != null) rvServedList!!.adapter = servedItemtAdapter

        btnSelectMore.setOnClickListener {
            val intent = Intent(getActivity(), SelectMenuActivity::class.java)
            startNewActivity(intent)
        }

        btnConfirmOrder.setOnClickListener {
            val intent = Intent(getActivity(), CartServedActivity::class.java)
            startNewActivity(intent)
        }

        btnInvoice.setOnClickListener {
            val intent = Intent(getActivity(), OrderInvoiceActivity::class.java)
            startNewActivity(intent)
        }

    }
}
