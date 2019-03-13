package com.softfinite

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.common.view.SimpleListDividerDecorator
import com.softfinite.adapter.OrderPreparingAdapter
import kotlinx.android.synthetic.main.activity_order_prepering.*

/**
 * Created by Softfinite (Viv'Ek Chodvadiya) on 13-Jun-18.
 */

class OrderPreperingActivity : BaseActivity() {

    lateinit var orderPreparingAdapter: OrderPreparingAdapter
    internal lateinit var mLayoutManager: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_prepering)
        initDrawer()
        initBack(false)
        initNotification()
        init()
    }

    private fun init() {
        setTitleText("Kushal Kumar")

        mLayoutManager = LinearLayoutManager(getActivity())
        if (rvOrderPrepare != null) rvOrderPrepare!!.layoutManager = mLayoutManager
        orderPreparingAdapter = OrderPreparingAdapter(this.getActivity())
        if (rvOrderPrepare != null) rvOrderPrepare!!.adapter = orderPreparingAdapter
        rvOrderPrepare.addItemDecoration(SimpleListDividerDecorator(getResources().getDrawable(R.drawable.list_divider), true))


//        btnConfirmOrder.setOnClickListener {
//            val i = Intent(getActivity(), OrderInvoiceActivity::class.java)
//            startNewActivity(i)
//        }
    }
}
