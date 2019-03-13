package com.softfinite

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.softfinite.adapter.NotificationAdapter
import kotlinx.android.synthetic.main.activity_notification.*

/**
 * Created by Viv'Ek on 5/8/2018.
 */

class NotificationActivity : BaseActivity() {

    internal lateinit var notificationAdapter: NotificationAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        initBack(true)
        init()
    }

    private fun init() {
        setTitleText("Notifications")

        rvNotification!!.layoutManager = LinearLayoutManager(getActivity())
        notificationAdapter = NotificationAdapter(this.getActivity())
        rvNotification!!.adapter = notificationAdapter

//        notificationAdapter.setEventListener(object : NotificationAdapter.EventListener {
//            override fun onItemViewClicked(position: Int) {
//                val data = notificationAdapter.getItem(position)
//
//                Utils.setNotificationReadData(getActivity(), data)
//                notificationAdapter.isReaded(data.nId)
//
//                if (data.nText!!.contains("chat")) {
////                    LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(Intent(StaticDataUtility.CHAT_LIST_UPDATE))
//                    startNewActivity(Intent(getActivity(), ChatActivity::class.java))
//                } else {
//                    val strRole = SharedPreference.GetPreferences(getActivity(), StaticDataUtility.S_PREFERENCE_NAME, StaticDataUtility.sRole)
//                    if (strRole.equals("1", ignoreCase = true)) {
//                        startNewActivity(Intent(getActivity(), StudentLessonsActivity::class.java))
//                    } else {
//                        startNewActivity(Intent(getActivity(), TeacherLessonsActivity::class.java))
//                    }
//                }
//            }
//        })
//        getNotification()
    }

//    fun getNotification() {
//        try {
//            showDialog("")
//
//            val strUserId = SharedPreference.GetPreferences(getActivity(), StaticDataUtility.S_PREFERENCE_NAME, StaticDataUtility.sUserId)!!
//            val strUserToken = SharedPreference.GetPreferences(getActivity(), StaticDataUtility.S_PREFERENCE_NAME, StaticDataUtility.sUserToken)!!
//            val bodyParameters = HashMap<String, String>()
//            bodyParameters[StaticDataUtility.pUserId] = strUserId
//            bodyParameters[StaticDataUtility.pUserToken] = strUserToken
//
//            val retrofit = RetrofitHttpRequest.newRequestRetrofit(getActivity())
//            val retrofitService = retrofit.create(RetrofitUrls::class.java)
//            retrofitService.getListNotification(bodyParameters).enqueue(getNotificationHandler(getActivity()))
//
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//    }
//
//
//    private inner class getNotificationHandler(context: Activity) : RetrofitResponseHandler(context) {
//
//        override fun onSuccess(content: String) {
//            dismissDialog()
//            try {
//                Debug.e("getNotification #", JSONObject(content).toString())
//                if (true) {
//                    val res = Gson().fromJson<Notification>(JSONObject(content).toString(), object : TypeToken<Notification>() {}.type)
//                    val intCode = res.statusCode
//                    if (intCode == 1) {
////                        notificationAdapter.addAll(res.info!!)
//
//                        try {
//                            notificationAdapter.clear()
//                            if (res.info!!.get(0) != null) {
//                                notificationAdapter.add(res.info!!.get(0))
//                            }
//                        } catch (e: Exception) {
//                            e.printStackTrace()
//                        }
//                        val readableData = Utils.getNotificationReadData(getActivity())
//                        if (readableData != null) {
//                            notificationAdapter.isReaded(readableData)
//                        }
//                    }
//                    refreshPlaceHolder()
//                }
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//
//        }
//
//        override fun onStart() {
//
//        }
//
//        override fun onFinish() {
//            dismissDialog()
//        }
//
//        override fun onFailure(e: Throwable, content: String) {
//            e.printStackTrace()
//            dismissDialog()
//        }
//    }
//
//    fun refreshPlaceHolder() {
//        if (notificationAdapter.getItemCount() > 0) {
//            tvNotificationNotFound.setVisibility(View.GONE)
//            rvNotification.visibility = View.VISIBLE
//        } else {
//            tvNotificationNotFound.setVisibility(View.VISIBLE)
//            rvNotification.visibility = View.GONE
//        }
//    }
}
