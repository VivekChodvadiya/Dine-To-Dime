package com.softfinite

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.softfinite.fragment.SelectMoreFragment
import kotlinx.android.synthetic.main.activity_select_more.*

/**
 * Created by Softfinite (Viv'Ek Chodvadiya) on 13-Jun-18.
 */

class SelectMoreActivity : BaseActivity() {

    lateinit var pagerAdapter: SelectMoreAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_more)
        initDrawer()
        initBack(false)
        initNotification()
        init()
    }

    private fun init() {
        setTitleText("Table No. 2 (Ground Fl.)")


        pagerAdapter = SelectMoreAdapter(supportFragmentManager)
        pagerSelectMore.setOffscreenPageLimit(pagerAdapter.count)
        pagerSelectMore.setAdapter(pagerAdapter)
        tabLayoutSelectMore.setupWithViewPager(pagerSelectMore)

        pagerSelectMore.setCurrentItem(1)

        btnViewCart.setOnClickListener {
            val intent = Intent(getActivity(), SelectMoreCombosActivity::class.java)
            startNewActivity(intent)
        }


    }

    inner class SelectMoreAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
        internal var tabTitles = arrayOf("BreakFast", "Lunch", "Dinner")
        override fun getItem(position: Int): Fragment {
            var f = Fragment()
            when (position) {
                0 -> f = SelectMoreFragment()
                1 -> f = SelectMoreFragment()
                2 -> f = SelectMoreFragment()
            }
            return f
        }

        override fun getCount(): Int {
            return 3
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return tabTitles[position]
        }
    }
}
