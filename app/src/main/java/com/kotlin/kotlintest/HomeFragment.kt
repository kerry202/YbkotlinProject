package com.kotlin.kotlintest

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.text_layout.*

/**
 * Created by yangbo on 2018/7/4
 */
class HomeFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener {
    override fun onRefresh() {

        Toast.makeText(activity, "refresh", Toast.LENGTH_SHORT).show()
        lists.clear()
        lists.add("refresh 1")
        lists.add("refresh 2")
        lists.add("refresh 3")
        lists.add("refresh 4")
        myAdapter?.notifyDataSetChanged()
        swiperefresh.isRefreshing = false

    }

    var inflate: View? = null
    var lists: ArrayList<String> = ArrayList()
    var myAdapter: MyAdapter? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        inflate = View.inflate(activity, R.layout.text_layout, null)
        System.out.println("  测试  HomeFragment")
        return inflate
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lists.add("list itme 1")
        lists.add("list itme 2")
        lists.add("list itme 3")
        lists.add("list itme 4")

        swiperefresh.setOnRefreshListener(this)

        myAdapter = MyAdapter(activity, lists)

        recyler.layoutManager = LinearLayoutManager(activity)

        recyler.adapter = myAdapter

    }


    class MyAdapter : RecyclerView.Adapter<MyAdapter.ViewHolder> {
        var lists: ArrayList<String> = ArrayList()
        var activity: Activity

        constructor(activitys: Activity, list: ArrayList<String>) {
            this.lists = list
            this.activity = activitys
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.tvTitle?.text = lists.get(position)
            holder.tvTitle.setOnClickListener(View.OnClickListener {
                Toast.makeText(activity, lists.get(position), Toast.LENGTH_SHORT).show()
            })

        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {

            val view = View.inflate(activity, R.layout.item_view_list_layout, null)
            val findViewById = view.findViewById<TextView>(R.id.tv)

            return ViewHolder(findViewById)

        }

        override fun getItemCount(): Int {
            return lists?.size as Int
        }

        class ViewHolder : RecyclerView.ViewHolder {
            var tvTitle: TextView

            constructor(itmeView: View) : super(itmeView) {
                tvTitle = itemView.findViewById(R.id.tv)

            }
        }
    }
}