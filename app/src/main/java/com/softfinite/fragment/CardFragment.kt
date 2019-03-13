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

class CardFragment : BaseFragment() {

    internal var type: Int = 0

    companion object {
        internal val LAYOUT_ID = "layoutid"
        fun newInstance(layoutId: Int, type: Int): CardFragment {
            val pane = CardFragment()
            val args = Bundle()
            args.putInt(LAYOUT_ID, layoutId)
            args.putInt("type", type)
            pane.arguments = args
            return pane
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.card_fragment, container, false)
    }

    private fun init() {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
}