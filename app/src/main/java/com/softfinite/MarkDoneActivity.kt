package com.softfinite

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.*
import com.common.view.SimpleListDividerDecorator
import com.softfinite.adapter.MarkDoneAdapter
import kotlinx.android.synthetic.main.activity_mark_done.*


/**
 * Created by Softfinite (Viv'Ek Chodvadiya) on 13-Jun-18.
 */

class MarkDoneActivity : BaseActivity() {

    lateinit var markDoneAdapter: MarkDoneAdapter
    internal lateinit var mLayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mark_done)
        initDrawer()
        initBack(false)
        initNotification()
        init()
    }

    private fun init() {
        setTitleText("Menu Tables")

        mLayoutManager = LinearLayoutManager(getActivity())
        if (rvMarkDone != null) rvMarkDone!!.layoutManager = mLayoutManager
        markDoneAdapter = MarkDoneAdapter(this.getActivity())
        if (rvMarkDone != null) rvMarkDone!!.adapter = markDoneAdapter
        rvMarkDone.addItemDecoration(SimpleListDividerDecorator(getResources().getDrawable(R.drawable.list_divider), true))

        markDoneAdapter.setEventListener(object : MarkDoneAdapter.EventListener {
            override fun onItemMoreClicked(position: Int, imgMoreOption: ImageView) {

            }

            override fun onItemViewClicked(position: Int) {
                val changePage = Intent(getActivity(), OrderPreperingActivity::class.java)
                startNewActivity(changePage)
            }
        })
    }

}
