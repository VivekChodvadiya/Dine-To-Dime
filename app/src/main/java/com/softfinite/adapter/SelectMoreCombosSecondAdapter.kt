package com.softfinite.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.softfinite.R
import com.softfinite.utils.Utils
import com.nostra13.universalimageloader.core.ImageLoader
import com.softfinite.objects.Dummy
import kotlinx.android.synthetic.main.item_select_more.view.*

/**
 * Created by Softfinite (Viv'Ek Chodvadiya) on 13-Jun-18.
 */

class SelectMoreCombosSecondAdapter(internal var context: Context) : RecyclerView.Adapter<SelectMoreCombosSecondAdapter.MyViewHolder>() {

    private var data: MutableList<Dummy>? = ArrayList<Dummy>()

    internal var imageLoader: ImageLoader
    internal var myEventAdapter: SelectMoreCombosSecondAdapter? = null
    private var mEventListener: EventListener? = null
    internal var isFilterable = false

    init {
        imageLoader = Utils.initImageLoader(context)!!
    }

    fun addAll(mData: List<Dummy>) {
        clear()
        try {
            this.data!!.clear()
            this.data!!.addAll(mData)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        notifyDataSetChanged()
    }

    //
    fun clear() {
        data!!.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.item_select_more_combos_second, parent, false)
        return MyViewHolder(v)
    }

    //    public void remove(int position, int id) {
    //        mData = mData + "," + id;
    //        data.remove(position);
    //        notifyDataSetChanged();
    //    }

//    fun getItem(pos: Int): Heros.Hero {
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


        holder.container!!.setOnClickListener {
            if (mEventListener != null) {
                mEventListener!!.onItemViewClicked(position)
            }
        }
    }

    override fun getItemCount(): Int {

//        return data!!.size
        return 2
    }

    fun setEventListener(eventListener: EventListener) {
        mEventListener = eventListener
    }

    interface EventListener {
        fun onItemViewClicked(position: Int)
    }

    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        //        val imgEvent = v.imgInvitation
        val container = v.container
    }
}
