package com.softfinite

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.common.view.SimpleListDividerDecorator
import com.softfinite.adapter.InvoiceItemtAdapter
import kotlinx.android.synthetic.main.activity_order_invoice.*
import kotlinx.android.synthetic.main.cart_bottomview_payment.*
import kotlinx.android.synthetic.main.dialog_make_payment.*
import android.view.*
import kotlinx.android.synthetic.main.card_fragment.*
import kotlinx.android.synthetic.main.wallet_fragment.*

/**
 * Created by Softfinite (Viv'Ek Chodvadiya) on 13-Jun-18.
 */

class OrderInvoiceActivity : BaseActivity() {

    lateinit var invoiceItemtAdapter: InvoiceItemtAdapter
    internal lateinit var mLayoutManager: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_invoice)
        initDrawer()
        initBack(false)
        initNotification()
        init()
    }

    private fun init() {
        setTitleText("Kushal Kumar")

        mLayoutManager = LinearLayoutManager(getActivity())
        if (recyclerViewOrderItem != null) recyclerViewOrderItem!!.layoutManager = mLayoutManager
        invoiceItemtAdapter = InvoiceItemtAdapter(this.getActivity())
        if (recyclerViewOrderItem != null) recyclerViewOrderItem!!.adapter = invoiceItemtAdapter
        recyclerViewOrderItem.addItemDecoration(SimpleListDividerDecorator(getResources().getDrawable(R.drawable.list_divider), true))


        btnMakePayment.setOnClickListener {
            showMakePaymentDailog()
        }

    }

//    lateinit var pagerAdapter: MenusAdapter_

    private fun showMakePaymentDailog() {

        val dialogs = Dialog(getActivity())
        dialogs.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogs.setCancelable(true)
        dialogs.getWindow().setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        dialogs.setContentView(R.layout.dialog_make_payment)

        if (com.softfinite.utils.Utils.isTablet(getActivity())) {
            val width = resources.getDimensionPixelSize(R.dimen._200sdp)
            val height = resources.getDimensionPixelSize(R.dimen._250sdp)
            dialogs.getWindow().setLayout(width, height)
        } else {
            val width = resources.getDimensionPixelSize(R.dimen._300sdp)
            val height = resources.getDimensionPixelSize(R.dimen._400sdp)
            dialogs.getWindow().setLayout(width, height)
        }


//        lateinit var mergeTableAdapter: MergeTableAdapter
//        lateinit var mLayoutManager: RecyclerView.LayoutManager

//        mLayoutManager = LinearLayoutManager(getActivity())
//        if (dialogs.rvMerge != null) dialogs.rvMerge!!.layoutManager = mLayoutManager
//        mergeTableAdapter = MergeTableAdapter(this.getActivity())
//        if (dialogs.rvMerge != null) dialogs.rvMerge!!.adapter = mergeTableAdapter

//        pagerAdapter = MenusAdapter_(supportFragmentManager)
//        dialogs.pagerMakepayment.offscreenPageLimit = pagerAdapter.count
//        dialogs.pagerMakepayment.adapter = pagerAdapter
//        dialogs.tabLayoutMakepayment.setupWithViewPager(dialogs.pagerMakepayment)

        setSelected(1, dialogs)
        dialogs.llCash.setOnClickListener {
            setSelected(1, dialogs)
        }

        dialogs.llCard.setOnClickListener {
            setSelected(2, dialogs)
        }

        dialogs.llWallet.setOnClickListener {
            setSelected(3, dialogs)
        }

        dialogs.btnMakePaymentDone.setOnClickListener {
            val changePage = Intent(getActivity(), DonePaymentActivity::class.java)
            startNewActivity(changePage)
            dialogs.dismiss()
        }

        dialogs.rbAxis.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                dialogs.rbBob.isChecked = false
                dialogs.rbIcici.isChecked = false
                dialogs.rbIdbi.isChecked = false
                dialogs.rbSbi.isChecked = false
            }
        }

        dialogs.rbBob.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                dialogs.rbAxis.isChecked = false
                dialogs.rbIcici.isChecked = false
                dialogs.rbIdbi.isChecked = false
                dialogs.rbSbi.isChecked = false
            }
        }
        dialogs.rbIcici.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                dialogs.rbAxis.isChecked = false
                dialogs.rbBob.isChecked = false
                dialogs.rbIdbi.isChecked = false
                dialogs.rbSbi.isChecked = false
            }
        }
        dialogs.rbIdbi.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                dialogs.rbAxis.isChecked = false
                dialogs.rbBob.isChecked = false
                dialogs.rbIcici.isChecked = false
                dialogs.rbSbi.isChecked = false
            }
        }
        dialogs.rbSbi.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                dialogs.rbAxis.isChecked = false
                dialogs.rbBob.isChecked = false
                dialogs.rbIcici.isChecked = false
                dialogs.rbIdbi.isChecked = false
            }
        }

        dialogs.rbPaytm.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                dialogs.rbPhonePay.isChecked = false
                dialogs.rbFreeCharge.isChecked = false
                dialogs.rbMobikwik.isChecked = false
            }
        }
        dialogs.rbPhonePay.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                dialogs.rbPaytm.isChecked = false
                dialogs.rbFreeCharge.isChecked = false
                dialogs.rbMobikwik.isChecked = false
            }
        }
        dialogs.rbFreeCharge.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                dialogs.rbPaytm.isChecked = false
                dialogs.rbPhonePay.isChecked = false
                dialogs.rbMobikwik.isChecked = false
            }
        }
        dialogs.rbMobikwik.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                dialogs.rbPaytm.isChecked = false
                dialogs.rbPhonePay.isChecked = false
                dialogs.rbFreeCharge.isChecked = false
            }
        }

        dialogs.show()
    }

    private fun setSelected(selected: Int, dialogs: Dialog) {
        if (selected == 1) {
            dialogs.llCash.background = getActivity().resources.getDrawable(R.drawable.primary_round)
            dialogs.llCash.setTextColor(getActivity().resources.getColor(R.color.white))
            dialogs.llCashPart.visibility = View.VISIBLE


            dialogs.llCard.setBackground(null)
            dialogs.llCard.setBackgroundColor(getActivity().resources.getColor(R.color.white))
            dialogs.llCard.setTextColor(getActivity().resources.getColor(R.color.primary))
            dialogs.llCardPart.visibility = View.GONE

            dialogs.llWallet.setBackground(null)
            dialogs.llWallet.setBackgroundColor(getActivity().resources.getColor(R.color.white))
            dialogs.llWallet.setTextColor(getActivity().resources.getColor(R.color.primary))
            dialogs.llWalletPart.visibility = View.GONE
        } else if (selected == 2) {
            dialogs.llCard.background = getActivity().resources.getDrawable(R.drawable.primary_round)
            dialogs.llCard.setTextColor(getActivity().resources.getColor(R.color.white))
            dialogs.llCardPart.visibility = View.VISIBLE


            dialogs.llCash.setBackground(null)
            dialogs.llCash.setBackgroundColor(getActivity().resources.getColor(R.color.white))
            dialogs.llCash.setTextColor(getActivity().resources.getColor(R.color.primary))
            dialogs.llCashPart.visibility = View.GONE

            dialogs.llWallet.setBackground(null)
            dialogs.llWallet.setBackgroundColor(getActivity().resources.getColor(R.color.white))
            dialogs.llWallet.setTextColor(getActivity().resources.getColor(R.color.primary))
            dialogs.llWalletPart.visibility = View.GONE
        } else if (selected == 3) {
            dialogs.llWallet.background = getActivity().resources.getDrawable(R.drawable.primary_round)
            dialogs.llWallet.setTextColor(getActivity().resources.getColor(R.color.white))
            dialogs.llWalletPart.visibility = View.VISIBLE

            dialogs.llCard.setBackground(null)
            dialogs.llCard.setBackgroundColor(getActivity().resources.getColor(R.color.white))
            dialogs.llCard.setTextColor(getActivity().resources.getColor(R.color.primary))
            dialogs.llCardPart.visibility = View.GONE

            dialogs.llCash.setBackground(null)
            dialogs.llCash.setBackgroundColor(getActivity().resources.getColor(R.color.white))
            dialogs.llCash.setTextColor(getActivity().resources.getColor(R.color.primary))
            dialogs.llCashPart.visibility = View.GONE
        }
    }

//    inner class MenusAdapter_(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
//        internal var tabTitles = arrayOf("Cash", "Card", "Wallet")
//        override fun getItem(position: Int): Fragment {
//            var f = Fragment()
//            when (position) {
//                0 -> f = CashFragment()
//                1 -> f = CardFragment()
//                2 -> f = WalletFragment()
//            }
//            return f
//        }
//
//        override fun getCount(): Int {
//            return 3
//        }
//
//        override fun getPageTitle(position: Int): CharSequence? {
//            return tabTitles[position]
//        }
//    }
}

