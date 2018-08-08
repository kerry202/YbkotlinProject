package com.kotlin.kotlintest

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.text2_layout.*

/**
 * Created by yangbo on 2018/7/4
 */
class ClassFragment : Fragment(){

    var inflate : View? =null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        inflate = View.inflate(activity, R.layout.text2_layout, null)

        System.out.println("  测试  ClassFragment")
        return inflate
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv.text = ("ClassFragment")

    }
}