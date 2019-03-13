package com.softfinite

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.common.view.SimpleListDividerDecorator
import com.softfinite.adapter.SelectMoreCombosAdapter
import kotlinx.android.synthetic.main.activity_select_more_combos.*

/**
 * Created by Softfinite (Viv'Ek Chodvadiya) on 13-Jun-18.
 */

class SelectMoreCombosActivity : BaseActivity() {

    lateinit var selectMoreCombosAdapter: SelectMoreCombosAdapter
    internal lateinit var mLayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_more_combos)
        initDrawer()
        initBack(false)
        initNotification()
        init()
        btnSelectMoreCombos.setOnClickListener {

        }

        btnConfirmOrder.setOnClickListener {
            val changePage = Intent(getActivity(), ConfirmOrderActivity::class.java)
            startNewActivity(changePage)
        }
    }

    private fun init() {
        setTitleText("Table No. 2 (Ground Fl.)")

        mLayoutManager = LinearLayoutManager(getActivity())
        if (rvSelectMoreCombos != null) rvSelectMoreCombos!!.layoutManager = mLayoutManager
        selectMoreCombosAdapter = SelectMoreCombosAdapter(this.getActivity()!!)
        if (rvSelectMoreCombos != null) rvSelectMoreCombos!!.adapter = selectMoreCombosAdapter
        rvSelectMoreCombos.addItemDecoration(SimpleListDividerDecorator(getResources().getDrawable(R.drawable.list_divider), true))

    }
}
