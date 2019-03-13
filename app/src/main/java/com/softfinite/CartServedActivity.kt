package com.softfinite

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.softfinite.adapter.CartServedAdapter
import com.softfinite.adapter.ServedItemtAdapter
import kotlinx.android.synthetic.main.activity_cart_served.*
import kotlinx.android.synthetic.main.cart_bottomview.*

/**
 * Created by Softfinite (Viv'Ek Chodvadiya) on 13-Jun-18.
 */

class CartServedActivity : BaseActivity() {

    lateinit var cartServedAdapter: CartServedAdapter
    internal lateinit var mLayoutManager: RecyclerView.LayoutManager
    lateinit var servedItemtAdapter: ServedItemtAdapter
    internal lateinit var mLayoutManagerServed: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart_served)
        initDrawer()
        initBack(false)
        initNotification()
        init()
    }

    private fun init() {
        setTitleText("Table No. 2 (Ground Fl.)")

        mLayoutManager = LinearLayoutManager(getActivity())
        if (rvCartServed != null) rvCartServed!!.layoutManager = mLayoutManager
        cartServedAdapter = CartServedAdapter(this.getActivity())
        if (rvCartServed != null) rvCartServed!!.adapter = cartServedAdapter

        btnSelectMore.setOnClickListener {
            val intent = Intent(getActivity(), SelectMenuActivity::class.java)
            startNewActivity(intent)
        }

        btnAllServed.setOnClickListener {

        }

        btnInvoice.setOnClickListener {
            val intent = Intent(getActivity(), OrderInvoiceActivity::class.java)
            startNewActivity(intent)
        }
    }
}
