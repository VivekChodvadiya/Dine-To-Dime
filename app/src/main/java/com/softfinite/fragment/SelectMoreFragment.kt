package com.softfinite.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.common.view.SimpleListDividerDecorator
import com.softfinite.R
import com.softfinite.SelectMoreCombosSecondActivity
import com.softfinite.adapter.SelectMoerAdapter
import kotlinx.android.synthetic.main.select_more_fragment.*

/**
 * Created by Softfinite (Viv'Ek Chodvadiya) on 13-Jun-18.
 */

class SelectMoreFragment : BaseFragment() {

    internal var type: Int = 0

    lateinit var selectMoerAdapter: SelectMoerAdapter
    internal lateinit var mLayoutManager: RecyclerView.LayoutManager

    companion object {
        internal val LAYOUT_ID = "layoutid"
        fun newInstance(layoutId: Int, type: Int): SelectMoreFragment {
            val pane = SelectMoreFragment()
            val args = Bundle()
            args.putInt(LAYOUT_ID, layoutId)
            args.putInt("type", type)
            pane.arguments = args
            return pane
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.select_more_fragment, container, false)
    }

    private fun init() {

        mLayoutManager = LinearLayoutManager(getActivity())
        if (rvSelectMore != null) rvSelectMore!!.layoutManager = mLayoutManager
        selectMoerAdapter = SelectMoerAdapter(this.getActivity()!!)
        if (rvSelectMore != null) rvSelectMore!!.adapter = selectMoerAdapter
        rvSelectMore.addItemDecoration(SimpleListDividerDecorator(getResources().getDrawable(R.drawable.list_divider), true))

        selectMoerAdapter.setEventListener(object : SelectMoerAdapter.EventListener {
            override fun onItemViewClicked(position: Int) {
                val changePage = Intent(getActivity(), SelectMoreCombosSecondActivity::class.java)
                startNewActivity(changePage)
            }

            override fun onItemAddQtyViewClicked(position: Int, llNumberPicker: View, llAddQty: View) {

            }

        })

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

}