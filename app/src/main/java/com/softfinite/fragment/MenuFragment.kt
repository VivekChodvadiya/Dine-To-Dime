package com.softfinite.fragment

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.softfinite.R
import com.softfinite.adapter.BreadAdapter
import com.softfinite.adapter.ExtrasAdapter
import com.softfinite.adapter.MenuAdapter
import kotlinx.android.synthetic.main.dialog_add_to_cart.*
import kotlinx.android.synthetic.main.menu_fragment.*

/**
 * Created by Softfinite (Viv'Ek Chodvadiya) on 13-Jun-18.
 */

class MenuFragment : BaseFragment() {

    internal var type: Int = 0

    lateinit var menuAdapter: MenuAdapter
    internal lateinit var mLayoutManager: RecyclerView.LayoutManager

    companion object {
        internal val LAYOUT_ID = "layoutid"
        fun newInstance(layoutId: Int, type: Int): MenuFragment {
            val pane = MenuFragment()
            val args = Bundle()
            args.putInt(LAYOUT_ID, layoutId)
            args.putInt("type", type)
            pane.arguments = args
            return pane
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.menu_fragment, container, false)
    }

    private fun init() {

        mLayoutManager = LinearLayoutManager(getActivity())
        if (rvMenu != null) rvMenu!!.layoutManager = mLayoutManager
        menuAdapter = MenuAdapter(this.getActivity()!!)
        if (rvMenu != null) rvMenu!!.adapter = menuAdapter

        menuAdapter.setEventListener(object : MenuAdapter.EventListener {
            override fun onItemtvNumAddToCartViewClicked(position: Int, llNumberPicker: View, llAddQty: View) {
                showAddToCartDailog(llNumberPicker, llAddQty)
            }

            override fun onItemAddQtyViewClicked(position: Int, llNumberPicker: View, llAddQty: View) {
//                llNumberPicker.visibility = View.VISIBLE
//                llAddQty.visibility = View.GONE
                showAddToCartDailog(llNumberPicker, llAddQty)
            }

            override fun onItemViewClicked(position: Int) {
//                val i = Intent(getActivity(), UserDetailActivity::class.java)
//                startNewActivity(i)
            }
        })

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun showAddToCartDailog(llNumberPicker: View, llAddQty: View) {
        var dialogs = Dialog(getActivity())
        dialogs.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogs.setCancelable(true)
        dialogs.getWindow().setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        dialogs.setContentView(R.layout.dialog_add_to_cart)

        if (com.softfinite.utils.Utils.isTablet(this!!.activity!!)) {
            val width = resources.getDimensionPixelSize(R.dimen._200sdp)
            val height = resources.getDimensionPixelSize(R.dimen._250sdp)
            dialogs.getWindow().setLayout(width, height)
        }


        lateinit var breadAdapter: BreadAdapter
        lateinit var mLayoutManager: RecyclerView.LayoutManager

        mLayoutManager = LinearLayoutManager(getActivity())
        if (dialogs.rvBread != null) dialogs.rvBread!!.layoutManager = mLayoutManager
        breadAdapter = BreadAdapter(this.getActivity()!!)
        if (dialogs.rvBread != null) dialogs.rvBread!!.adapter = breadAdapter

        lateinit var extrasAdapter: ExtrasAdapter
        lateinit var mLayoutManagerr: RecyclerView.LayoutManager

        mLayoutManagerr = LinearLayoutManager(getActivity())
        if (dialogs.rvExtras != null) dialogs.rvExtras!!.layoutManager = mLayoutManagerr
        extrasAdapter = ExtrasAdapter(this.getActivity()!!)
        if (dialogs.rvExtras != null) dialogs.rvExtras!!.adapter = extrasAdapter

        dialogs.btnAddToCart.setOnClickListener {
            dialogs.dismiss()
        }

        dialogs.show()
    }
}