package com.softfinite

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.ViewGroup
import com.softfinite.fragment.MenuFragment
import kotlinx.android.synthetic.main.activity_select_menu.*
import android.widget.TextView
import com.softfinite.utils.Utils


/**
 * Created by Softfinite (Viv'Ek Chodvadiya) on 13-Jun-18.
 */

class SelectMenuActivity : BaseActivity() {

    lateinit var pagerAdapter: MenusAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_menu)
        initDrawer()
        initBack(false)
        initNotification()
        init()
    }

    private fun init() {
        setTitleText("Table No. 2 (Ground Fl.)")


        pagerAdapter = MenusAdapter(supportFragmentManager)
        pager.setOffscreenPageLimit(pagerAdapter.count)
        pager.setAdapter(pagerAdapter)
        tab_layout.setupWithViewPager(pager)

        btnViewCart.setOnClickListener {
            val intent = Intent(getActivity(), CartActivity::class.java)
            startNewActivity(intent)
        }
        changeTabsFont()
    }

    private fun changeTabsFont() {
        val vg = tab_layout.getChildAt(0) as ViewGroup
        val tabsCount = vg.childCount
        for (j in 0 until tabsCount) {
            val vgTab = vg.getChildAt(j) as ViewGroup
            val tabChildsCount = vgTab.childCount
            for (i in 0 until tabChildsCount) {
                val tabViewChild = vgTab.getChildAt(i)
                if (tabViewChild is TextView) {
                    (tabViewChild as TextView).setTypeface(Utils.getNormal(getActivity()))
                }
            }
        }
    }


    inner class MenusAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
        internal var tabTitles = arrayOf("Top Favourites", "Soups", "Starter", "Main Course", "Desserts")
        override fun getItem(position: Int): Fragment {
            var f = Fragment()
            when (position) {
                0 -> f = MenuFragment()
                1 -> f = MenuFragment()
                2 -> f = MenuFragment()
                3 -> f = MenuFragment()
                4 -> f = MenuFragment()
            }
            return f
        }

        override fun getCount(): Int {
            return 5
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return tabTitles[position]
        }
    }
}
