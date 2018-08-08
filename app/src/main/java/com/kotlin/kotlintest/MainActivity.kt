package com.kotlin.kotlintest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    var homeFragment: HomeFragment? = HomeFragment()
    var classFragment: ClassFragment? = ClassFragment()
    var findFragment: FindFragment? = FindFragment()
    var myFragment: MyFragment? = MyFragment()


    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val beginTransaction = supportFragmentManager.beginTransaction()

        beginTransaction.add(R.id.fragment, homeFragment)
        beginTransaction.add(R.id.fragment, classFragment)
        beginTransaction.add(R.id.fragment, findFragment)
        beginTransaction.add(R.id.fragment, myFragment)
        beginTransaction.commit()


        supportFragmentManager.beginTransaction().show(homeFragment).hide(findFragment).hide(classFragment).hide(myFragment).commit()


        home.setOnClickListener(this)
        cls.setOnClickListener(this)
        find.setOnClickListener(this)
        my.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.home -> {

                supportFragmentManager.beginTransaction().show(homeFragment).hide(findFragment)
                        .hide(myFragment)
                        .hide(classFragment)
                        .commit()
            }
            R.id.cls -> {
                supportFragmentManager.beginTransaction().show(classFragment).hide(homeFragment).hide(findFragment).hide(myFragment)
                        .commit()
            }
            R.id.find -> {
                supportFragmentManager.beginTransaction().show(findFragment).hide(homeFragment).hide(classFragment).hide(myFragment)
                        .commit()
            }
            R.id.my -> {
                supportFragmentManager.beginTransaction().show(myFragment).hide(homeFragment).hide(classFragment).hide(findFragment)
                        .commit()
            }
        }
    }

}
