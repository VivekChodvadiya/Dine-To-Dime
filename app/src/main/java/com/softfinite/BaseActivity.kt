package com.softfinite

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.*
import com.afollestad.materialdialogs.MaterialDialog
import com.softfinite.utils.Constant
import com.softfinite.utils.RetrofitProgressDialog
import com.softfinite.utils.Utils
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.nex3z.notificationbadge.NotificationBadge
import com.softfinite.adapter.SideMenusAdapter
import com.softfinite.objects.Dummy
import com.softfinite.utils.Debug
import kotlinx.android.synthetic.main.topbar.*
import java.util.ArrayList
import android.content.res.Configuration.SCREENLAYOUT_SIZE_LARGE
import android.content.res.Configuration.SCREENLAYOUT_SIZE_MASK
import android.content.res.Configuration.SCREENLAYOUT_SIZE_LARGE
import android.content.res.Configuration.SCREENLAYOUT_SIZE_MASK
import android.widget.*
import com.softfinite.adapter.NotificationAdapter
import kotlinx.android.synthetic.main.activity_notification.*


/**
 * Created by Softfinite (Viv'Ek Chodvadiya) on 11-Jun-18.
 */

open class BaseActivity : AppCompatActivity() {


    internal var ad: RetrofitProgressDialog? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)

        toast = Toast.makeText(getActivity(), "", Toast.LENGTH_LONG)

        val intentFilter = IntentFilter()
        intentFilter.addAction(Constant.FINISH_ACTIVITY)

        commonReciever = MyEventServiceReciever()
        LocalBroadcastManager.getInstance(this).registerReceiver(
                commonReciever, intentFilter)
    }

    fun setTitleText(text: String) {
        try {
            tvTitleText.text = text
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    internal lateinit var commonReciever: MyEventServiceReciever

    internal inner class MyEventServiceReciever : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            try {
                if (intent.action!!.equals(
                                Constant.FINISH_ACTIVITY, ignoreCase = true)) {
                    finish()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getActivity(): BaseActivity {
        return this
    }

    fun showDialog(msg: String) {
        try {
            if (ad != null && ad!!.isShowing) {
                return
            }
            ad = RetrofitProgressDialog.getInstant(getActivity())
            ad!!.show(msg)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun dismissDialog() {
        try {
            if (ad != null) {
                ad!!.dismiss()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    internal lateinit var toast: Toast

    fun showToast(text: String, duration: Int) {
        runOnUiThread {
            toast.setText(text)
            toast.duration = duration
            toast.show()
        }
    }

    fun showToast(text: String) {
        runOnUiThread {
            toast.setText(text)
            toast.duration = Toast.LENGTH_SHORT
            toast.show()
        }
    }

    lateinit var result: Drawer

    internal lateinit var customSideMenu: ViewGroup

    private fun bindHeaderData() {
        try {
            //            View navHeader = (View) customSideMenu.findViewById(R.id.navHeader);
            //            TextView tvUserName = (TextView) navHeader.findViewById(R.id.tvUserName);
            //            TextView tvReferralCode = (TextView) navHeader.findViewById(R.id.tvReferralCode);
            //            TextView tvMobileNo = (TextView) navHeader.findViewById(R.id.tvMobileNo);
            //            LoginRes loginRes = Utils.getLoginDetails(getActivity());
            //            tvUserName.setText(Utils.nullSafe(loginRes.data.user.username));
            //            tvReferralCode.setText(Utils.nullSafeDash(loginRes.data.user.referralCode));
            //            tvMobileNo.setText(Utils.nullSafeDash(loginRes.data.user.mobileNumber));
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun initDrawer() {
//        Utils.getLoginDetails(getActivity())
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        customSideMenu = layoutInflater.inflate(R.layout.side_menu, null, false) as ViewGroup
        bindHeaderData()

        // Drawer menu setup
        val mRecyclerView = customSideMenu.findViewById(R.id.mRecyclerView) as RecyclerView
        val layoutManager: RecyclerView.LayoutManager
        val mAdapter: SideMenusAdapter
        layoutManager = LinearLayoutManager(this)
        mRecyclerView.layoutManager = layoutManager
//        mRecyclerView.addItemDecoration(SimpleListDividerDecorator(resources.getDrawable(R.drawable.list_divider), true))
        mAdapter = SideMenusAdapter(getActivity())
        mRecyclerView.adapter = mAdapter
        mAdapter.setEventListener(object : SideMenusAdapter.EventListener {
            override fun onItemViewClicked(position: Int) {
                Debug.e("OnMenuItemClick", position.toString())
                gotoScreen(position)
            }
        })


        // Drawer menu static data
        if (Debug.DEBUG) {
            val menuList = ArrayList<Dummy>()
            val menus = arrayOf("Home", "Occupied Table", "Take Away", "Settings", "Terms of Use", "Privacy Policy", "Logout")

            var position: Int = 0
            for (menu in menus) {
                val myp = Dummy()
                myp.name = menu
                if (position == 0) {
                    myp.drawable = getActivity().resources.getDrawable(R.drawable.ic_home)
                } else if (position == 1) {
                    myp.drawable = getActivity().resources.getDrawable(R.drawable.ic_dinning_table)
                } else if (position == 2) {
                    myp.drawable = getActivity().resources.getDrawable(R.drawable.ic_drink)
                } else if (position == 3) {
                    myp.drawable = getActivity().resources.getDrawable(R.drawable.ic_settings_work)
                } else if (position == 4) {
                    myp.drawable = getActivity().resources.getDrawable(R.drawable.ic_writing)
                } else if (position == 5) {
                    myp.drawable = getActivity().resources.getDrawable(R.drawable.ic_lock)
                } else if (position == 6) {
                    myp.drawable = getActivity().resources.getDrawable(R.drawable.ic_log_out)
                }
                menuList.add(myp)
                position++
            }
            mAdapter.addAll(menuList)
        }


        if (Utils.isTablet(getActivity())) {
            result = DrawerBuilder()
                    .withActivity(this).withCloseOnClick(true).withSelectedItemByPosition(-1)
                    //                .withHeader(R.layout.side_menu)
                    .withCustomView(customSideMenu)
                    .withDrawerWidthDp(400)
                    //                    .withStickyFooter(drawerFooterView)
                    //                    .withStickyFooterShadow(false)
                    //                    .withStickyFooterDivider(true)
                    .build()
        } else {
            result = DrawerBuilder()
                    .withActivity(this).withCloseOnClick(true).withSelectedItemByPosition(-1)
                    //                .withHeader(R.layout.side_menu)
                    .withCustomView(customSideMenu)
                    .withDrawerWidthDp(240)
                    //                    .withStickyFooter(drawerFooterView)
                    //                    .withStickyFooterShadow(false)
                    //                    .withStickyFooterDivider(true)
                    .build()
        }


        val imgMenu = findViewById<View>(R.id.imgMenu) as ImageView
        if (imgMenu != null) {
            imgMenu.visibility = View.VISIBLE
            imgMenu.setOnClickListener {
                if (result.isDrawerOpen) {
                    result.closeDrawer()
                } else {
                    result.openDrawer()
                }
            }
        }


    }

    private fun gotoScreen(position: Int) {
        // hide drawer
        hideDrawer()
        if (position == 0 && getActivity() !is MainActivity) {
            val intent = Intent(getActivity(), MainActivity::class.java)
            startNewActivity(intent)
        } else if (position == 1 && getActivity() !is OccupiedTableActivity) {
            val intent = Intent(getActivity(), OccupiedTableActivity::class.java)
            startNewActivity(intent)
        } else if (position == 2 && getActivity() !is TakeAwayActivity) {
            val intent = Intent(getActivity(), TakeAwayActivity::class.java)
            startNewActivity(intent)
        } else if (position == 3 && getActivity() !is SettingActivity) {
            val intent = Intent(getActivity(), SettingActivity::class.java)
            startNewActivity(intent)
        } else if (position == 7) {
            confirmLogout()
        }
    }

    fun hideMenu(b: Boolean) {
        try {
            if (b)
                result.closeDrawer()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun finishActivity() {
        if (getActivity() is MainActivity) {

        } else {
            getActivity().finish()
        }
    }

    fun confirmLogout() {
        val builder = MaterialDialog.Builder(getActivity())
                .title(getActivity().resources.getString(R.string.logout_title))
                .content(getActivity().resources.getString(R.string.logout_msg))
                .positiveText(getActivity().resources.getString(R.string.btn_yes))
                .negativeText(getActivity().resources.getString(R.string.btn_no))
                .negativeColor(resources.getColor(R.color.primary))
                .positiveColor(resources.getColor(R.color.primary))
                .onPositive { materialDialog, dialogAction ->
                    //                        showToast(getActivity().getString(R.string.logout), Toast.LENGTH_SHORT);

                    Utils.clearLoginCredetials(getActivity())

                    LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(Intent(Constant.FINISH_ACTIVITY))

                    val intent = Intent(getActivity(), LoginActivity::class.java)
                    startNewActivity(intent)
                }.onNegative { materialDialog, dialogAction -> }

        val dialog = builder.build()
        dialog.show()
    }

    fun initBack(b: Boolean) {
        val imgBack = findViewById<View>(R.id.imgBack) as ImageView
        if (b) {
            imgBack.visibility = View.VISIBLE
            imgBack.setOnClickListener {
                finish()
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            }
        } else {
            imgBack.visibility = View.GONE
        }
    }

    fun initNotification() {
        val imgCart = findViewById<View>(R.id.imgCart) as ImageView
//        val imgBadge = findViewById<View>(R.id.badge) as NotificationBadge

        imgCart.visibility = View.VISIBLE
//        badge.visibility = View.VISIBLE

//        badge.setNumber(2)

        imgCart.setOnClickListener {

            val inflater = applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view: View = inflater.inflate(R.layout.dialog_notification, null)

            val mypopupWindow: PopupWindow;
            if (Utils.isTablet(getActivity())) {
                mypopupWindow = PopupWindow(view, 400, RelativeLayout.LayoutParams.WRAP_CONTENT, true)
            } else {
                mypopupWindow = PopupWindow(view, 800, RelativeLayout.LayoutParams.WRAP_CONTENT, true)
            }

            val rvNotification: RecyclerView = view.findViewById(R.id.rvNotification)
            val tvNotificationNotFound: RecyclerView = view.findViewById(R.id.tvNotificationNotFound)

            lateinit var notificationAdapter: NotificationAdapter


            rvNotification.layoutManager = LinearLayoutManager(getActivity())
            notificationAdapter = NotificationAdapter(this.getActivity())
            rvNotification.adapter = notificationAdapter



            mypopupWindow.showAsDropDown(it, -153, 0)

//            val intent = Intent(getActivity(), NotificationActivity::class.java)
//            startNewActivity(intent)
        }
    }

    override fun onBackPressed() {
        try {
            if (result.isDrawerOpen) {
                result.closeDrawer()
            } else {
                super.onBackPressed()
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            }
        } catch (e: Exception) {
            super.onBackPressed()
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }


    private fun hideDrawer() {
        result.closeDrawer()
    }

    fun startNewActivity(i: Intent) {
        startActivity(i)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
}