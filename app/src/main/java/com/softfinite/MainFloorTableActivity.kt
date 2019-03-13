package com.softfinite

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.PopupMenu
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.Window
import android.widget.*
import com.common.view.SimpleListDividerDecorator
import com.softfinite.adapter.FloorTablesListAdapter
import com.softfinite.adapter.MergeTableAdapter
import com.softfinite.adapter.SpinnerAdapter
import com.softfinite.objects.Spinner
import com.softfinite.utils.SpinnerCallback
import kotlinx.android.synthetic.main.activity_main_table_floor.*
import kotlinx.android.synthetic.main.dialog_merge_table.*
import kotlinx.android.synthetic.main.dialog_person_tbl.*
import android.view.LayoutInflater


/**
 * Created by Softfinite (Viv'Ek Chodvadiya) on 13-Jun-18.
 */

class MainFloorTableActivity : BaseActivity() {

    lateinit var floorTableListAdapter: FloorTablesListAdapter
    internal lateinit var mLayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_table_floor)
        initDrawer()
        initBack(false)
        initNotification()
        init()
    }

    private fun init() {
        setTitleText("Main Floor Tables")

        mLayoutManager = LinearLayoutManager(getActivity())
        if (rvFlooor != null) rvFlooor!!.layoutManager = mLayoutManager
        floorTableListAdapter = FloorTablesListAdapter(this.getActivity())
        if (rvFlooor != null) rvFlooor!!.adapter = floorTableListAdapter
        rvFlooor.addItemDecoration(SimpleListDividerDecorator(getResources().getDrawable(R.drawable.list_divider), true))

        floorTableListAdapter.setEventListener(object : FloorTablesListAdapter.EventListener {
            override fun onItemMoreClicked(position: Int, imgMoreOption: ImageView) {
                val menu = PopupMenu(getActivity(), imgMoreOption)
//                menu.inflate(R.layout.dialog_menu)

                val inflater = applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                val view: View = inflater.inflate(R.layout.dialog_menu, null)

                val mypopupWindow: PopupWindow = PopupWindow(view, 500, RelativeLayout.LayoutParams.WRAP_CONTENT, true)

                val tvPopupMerge: TextView = view.findViewById(R.id.tvPopupMerge)
                val tvPopupCart: TextView = view.findViewById(R.id.tvPopupCart)
                val tvPopupInvoice: TextView = view.findViewById(R.id.tvPopupInvoice)

                tvPopupMerge.setOnClickListener {
                    showMergeDailog()
                    mypopupWindow.dismiss()
                }
                tvPopupCart.setOnClickListener {
                    val intent = Intent(getActivity(), CartActivity::class.java)
                    startNewActivity(intent)
                    mypopupWindow.dismiss()
                }
                tvPopupInvoice.setOnClickListener {
                    val intent = Intent(getActivity(), OrderInvoiceActivity::class.java)
                    startNewActivity(intent)
                    mypopupWindow.dismiss()
                }


                mypopupWindow.showAsDropDown(imgMoreOption, -153, 0)

//                menu.menu.add(0, 1, 1, Utils.menuIconWithText(ContextCompat.getDrawable(getActivity(), R.drawable.ic_multi_tbl)!!, "Merge"))
//                menu.menu.add(0, 2, 2, Utils.menuIconWithText(ContextCompat.getDrawable(getActivity(), R.drawable.ic_eye)!!, "View Cart"))
//                menu.menu.add(0, 3, 3, Utils.menuIconWithText(ContextCompat.getDrawable(getActivity(), R.drawable.ic_invoice)!!, "Invoice"))
//                menu.show()
//
//                menu.setOnMenuItemClickListener {
//
//                    if (it.itemId == 1) {
//                        showMergeDailog()
//                    } else if (it.itemId == 2) {
//                        val intent = Intent(getActivity(), CartActivity::class.java)
//                        startNewActivity(intent)
//                    } else if (it.itemId == 3) {
//                        val intent = Intent(getActivity(), OrderInvoiceActivity::class.java)
//                        startNewActivity(intent)
//                    }
//
//                    true
//                }
            }

            override fun onItemViewClicked(position: Int) {
                showDialogPerson()
            }
        })
    }

    private fun showDialogPerson() {
        var dialogs = Dialog(getActivity())
        dialogs.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogs.setCancelable(true)
        dialogs.getWindow().setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        dialogs.setContentView(R.layout.dialog_person_tbl)
        dialogs.btnOccupied.setOnClickListener {
            dialogs.dismiss()
            val intent = Intent(getActivity(), MenuCategoryActivity::class.java)
            startNewActivity(intent)
        }

        dialogs.editNoPerson.setOnClickListener {
            val array = java.util.ArrayList<Spinner>()
            array.add(Spinner("1", "1"))
            array.add(Spinner("2", "2"))
            array.add(Spinner("3", "3"))
            array.add(Spinner("4", "4"))
            array.add(Spinner("5", "5"))
            array.add(Spinner("6", "6"))
            array.add(Spinner("7", "7"))
            showSpinner("Number of person", dialogs.editNoPerson, array, null)
        }

        dialogs.show()

    }

    fun showSpinner(title: String, editText: EditText,
                    data: ArrayList<Spinner>, callback: SpinnerCallback?) {

        val a = Dialog(getActivity())
        val w = a.window
        a.requestWindowFeature(Window.FEATURE_NO_TITLE)
        a.setContentView(R.layout.spinner)
        w!!.setBackgroundDrawableResource(android.R.color.transparent)

        val lblselect = w.findViewById(R.id.dialogtitle) as TextView
        lblselect.text = title.replace("*", "").trim { it <= ' ' }

        //        TextView dialogClear = (TextView) w.findViewById(R.id.dialogClear);
        //        dialogClear.setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View view) {
        //                tv.setText("");
        //                tv.setTag(null);
        //
        //                a.dismiss();
        //            }
        //        });

        val adapter = SpinnerAdapter(getActivity())
        val lv = w.findViewById(R.id.lvSpinner) as ListView
        val editSearch = w.findViewById(R.id.editSearch) as EditText

        editSearch.visibility = View.GONE
        lv.adapter = adapter
        adapter.addAll(data)

        lv.onItemClickListener = AdapterView.OnItemClickListener { adapterview, view, position, l ->
            val selList = ArrayList<Spinner>()
            selList.add(adapter.getItem(position))

            editText.setText(adapter.getItem(position).title)
            editText.tag = adapter.getItem(position).ID

            if (callback != null) {
                callback.onDone(selList)
            }

            a.dismiss()
        }

        //        editSearch.addTextChangedListener(new TextWatcher() {
        //
        //            @Override
        //            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        //
        //            }
        //
        //            @Override
        //            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        //
        //            }
        //
        //            @Override
        //            public void afterTextChanged(Editable editable) {
        //                if (editable.toString().trim().length() >= 1) {
        //                    adapter.getFilter().filter(editable.toString().trim());
        //                } else {
        //                    adapter.getFilter().filter("");
        //                }
        //
        //            }
        //        });

        a.show()
    }

    private fun showMergeDailog() {
        var dialogs = Dialog(getActivity())
        dialogs.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogs.setCancelable(true)
        dialogs.getWindow().setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        dialogs.setContentView(R.layout.dialog_merge_table)

        lateinit var mergeTableAdapter: MergeTableAdapter
        lateinit var mLayoutManager: RecyclerView.LayoutManager

        mLayoutManager = LinearLayoutManager(getActivity())
        if (dialogs.rvMerge != null) dialogs.rvMerge!!.layoutManager = mLayoutManager
        mergeTableAdapter = MergeTableAdapter(this.getActivity())
        if (dialogs.rvMerge != null) dialogs.rvMerge!!.adapter = mergeTableAdapter

        dialogs.btnMerge.setOnClickListener {
            dialogs.dismiss()


        }

        dialogs.show()
    }
}
