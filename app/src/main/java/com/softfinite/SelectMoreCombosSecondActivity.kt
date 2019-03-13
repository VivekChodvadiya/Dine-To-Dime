package com.softfinite

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.common.view.SimpleListDividerDecorator
import com.softfinite.adapter.SelectMoreCombosSecondAdapter
import kotlinx.android.synthetic.main.activity_select_more_combos_second.*

/**
 * Created by Softfinite (Viv'Ek Chodvadiya) on 13-Jun-18.
 */

class SelectMoreCombosSecondActivity : BaseActivity() {

    lateinit var selectMoreCombosSecondAdapter: SelectMoreCombosSecondAdapter
    internal lateinit var mLayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_more_combos_second)
        initDrawer()
        initBack(false)
        initNotification()
        init()
    }

    private fun init() {
        setTitleText("Table No. 2 (Ground Fl.)")

        mLayoutManager = LinearLayoutManager(getActivity())
        if (rvSelectMoreCombosSecond != null) rvSelectMoreCombosSecond!!.layoutManager = mLayoutManager
        selectMoreCombosSecondAdapter = SelectMoreCombosSecondAdapter(this.getActivity())
        if (rvSelectMoreCombosSecond != null) rvSelectMoreCombosSecond!!.adapter = selectMoreCombosSecondAdapter
        rvSelectMoreCombosSecond.addItemDecoration(SimpleListDividerDecorator(getResources().getDrawable(R.drawable.list_divider), true))

        selectMoreCombosSecondAdapter.setEventListener(object : SelectMoreCombosSecondAdapter.EventListener {
            override fun onItemViewClicked(position: Int) {
                val changePage = Intent(getActivity(), MarkDoneActivity::class.java)
                startNewActivity(changePage)
            }

        })

        btnBack.setOnClickListener {
            finish()
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }
}
