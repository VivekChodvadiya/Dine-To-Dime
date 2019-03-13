package com.softfinite.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nostra13.universalimageloader.core.ImageLoader
import com.softfinite.R
import kotlinx.android.synthetic.main.item_notification_list.view.*
import java.util.*

/**
 * Created by xpro on 1/30/2017.
 */

class NotificationAdapter(internal var context: Context) : RecyclerView.Adapter<NotificationAdapter.MyViewHolder>() {

//    private var data: MutableList<Notification.Info>? = ArrayList<Notification.Info>()

    internal lateinit var imageLoader: ImageLoader
    internal var myEventAdapter: NotificationAdapter? = null
    private var mEventListener: EventListener? = null
    internal var isFilterable = false

    init {
//        imageLoader = Utils.initImageLoader(context)!!
    }

//    fun add(mData: Notification.Info) {
//        data!!.add(mData)
//        notifyDataSetChanged()
//    }


//    fun addAll(mData: List<Notification.Info>) {
//        clear()
//        try {
//            this.data!!.clear()
//            this.data!!.addAll(mData)
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//        notifyDataSetChanged()
//    }

//    fun clear() {
//        data!!.clear()
//        notifyDataSetChanged()
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.item_notification_list, parent, false)
        return MyViewHolder(v)
    }

    //    public void remove(int position, int id) {
    //        mData = mData + "," + id;
    //        data.remove(position);
    //        notifyDataSetChanged();
    //    }

//    fun getItem(pos: Int): Notification.Info {
//        return data!![pos]
//    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        val item = data!![position]
//
//        //            Debug.e("userload-->", item.userPhoto);
//        if (!item.imageurl.isNullOrEmpty()) {
//            imageLoader.displayImage(Utils.nullSafe(item.imageurl), holder.imgEvent)
//        } else {
//            holder.imgEvent.setImageDrawable(context.resources.getDrawable(R.drawable.ic_launcher_background))
//        }
////
//        holder.tvNotification!!.setText(Utils.nullSafe(Utils.subStringForName(item.name)))
//        holder.tvNotificationDetails!!.setText(Utils.nullSafe(item.nText))
//        holder.tvNotificationTime.setText(Utils.nullSafe(getTimeAgo(Utils.parseTimeUTCtoDefault(item.nDate!!, "yyyy-MM-dd HH:mm:ss"))))
//
//        if (item.isReaded) {
//            holder.tvNotification.setTextColor(context.resources.getColor(R.color.col_999))
//            holder.tvNotificationDetails.setTextColor(context.resources.getColor(R.color.col_999))
//            holder.tvNotificationTime.setTextColor(context.resources.getColor(R.color.col_999))
//        } else {
//            holder.tvNotification.setTextColor(context.resources.getColor(R.color.black))
//            holder.tvNotificationDetails.setTextColor(context.resources.getColor(R.color.black))
//            holder.tvNotificationTime.setTextColor(context.resources.getColor(R.color.black))
//        }

//        val s = Utils.getPref(context, Constant.NOTIFICATION_READ, "")
//        if (!s.isNullOrEmpty()) {
//            val prefArray: ArrayList<String> = Gson().fromJson<ArrayList<String>>(s, object : TypeToken<ArrayList<String>>() {}.type)
//            for (i in prefArray) {
//                if (i.equals("" + item.nId, true)) {
//                    holder.tvNotification.setTextColor(context.resources.getColor(R.color.col_666))
//                    holder.tvNotificationDetails.setTextColor(context.resources.getColor(R.color.col_666))
//                    holder.tvNotificationTime.setTextColor(context.resources.getColor(R.color.col_666))
//                } else {
//                    holder.tvNotification.setTextColor(context.resources.getColor(R.color.col_333))
//                    holder.tvNotificationDetails.setTextColor(context.resources.getColor(R.color.col_333))
//                    holder.tvNotificationTime.setTextColor(context.resources.getColor(R.color.col_333))
//                }
//            }
//        } else {
//            holder.tvNotification.setTextColor(context.resources.getColor(R.color.col_333))
//            holder.tvNotificationDetails.setTextColor(context.resources.getColor(R.color.col_333))
//            holder.tvNotificationTime.setTextColor(context.resources.getColor(R.color.col_333))
//        }

//        val strImage: String
//        if (item.profilePic!!.contains("http://graph.facebook.com")) {
//            strImage = item.profilePic!!.replace("http", "https")
//        } else {
//            strImage = item.profilePic!!
//        }
//
//        imageLoader.displayImage(Utils.nullSafe(strImage), holder.ivUser)

        holder.container!!.setOnClickListener {
            if (mEventListener != null) {
//                if (!item.isReaded) {
//                    mEventListener.onItemViewClicked(position)
//                }
            }
        }
    }

    override fun getItemCount(): Int {
//        return data!!.size
        return 10
    }

    fun setFilterable(isFilterable: Boolean) {
        this.isFilterable = isFilterable
    }
//
//    fun isReaded(prefArray: ArrayList<String>) {
//        for (i in data!!) {
//            if (prefArray.contains(i.nId)) {
//                i.isReaded = true
//            } else {
//                i.isReaded = false
//            }
//        }
//        notifyDataSetChanged()
//    }
//
//    fun isReaded(id: String) {
//        for (i in data!!) {
//            if (id.equals(i.nId, true)) {
//                i.isReaded = true
//            }
//        }
//        notifyDataSetChanged()
//    }

    fun setEventListener(eventListener: EventListener) {
        mEventListener = eventListener
    }

    interface EventListener {
        fun onItemViewClicked(position: Int)
    }

    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val container = v.container
        val tvNotificationTime = v.tvNotificationTime
        val tvNotification = v.tvNotification
        val tvNotificationDetails = v.tvNotificationDetails
        val ivUser = v.ivUser
    }

    private val SECOND_MILLIS: Int = 1000
    private val MINUTE_MILLIS: Int = 60 * SECOND_MILLIS
    private val HOUR_MILLIS: Int = 60 * MINUTE_MILLIS
    private val DAY_MILLIS: Int = 24 * HOUR_MILLIS

    private fun currentDate(): Date {
        val calendar = Calendar.getInstance()
        return calendar.time
    }

    fun getTimeAgo(date: Date): String {
        var time = date.time
        if (time < 1000000000000L) {
            time *= 1000
        }

        val now = currentDate().getTime()
        if (time > now || time <= 0) {
//            return "in the future"
            return "moments ago"
        }

        val diff = now - time
        return if (diff < MINUTE_MILLIS) {
            "moments ago"
        } else if (diff < 2 * MINUTE_MILLIS) {
            "a minute ago"
        } else if (diff < 60 * MINUTE_MILLIS) {
            (diff / MINUTE_MILLIS).toString() + " minutes ago"
        } else if (diff < 2 * HOUR_MILLIS) {
            "an hour ago"
        } else if (diff < 24 * HOUR_MILLIS) {
            (diff / HOUR_MILLIS).toString() + " hours ago"
        } else if (diff < 48 * HOUR_MILLIS) {
            "yesterday"
        } else {
            (diff / DAY_MILLIS).toString() + " days ago"
        }
    }

}
