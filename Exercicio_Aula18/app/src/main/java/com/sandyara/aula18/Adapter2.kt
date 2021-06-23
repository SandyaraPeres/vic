package com.sandyara.aula18

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class Adapter2(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment = First()
        if(position == 0){
            fragment = First()
        } else if(position == 1){
            fragment = Second()
        }

        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var x: String = ""
        if(position == 0){
            x = "Primeiro"
        } else if(position == 1){
            x = "Segundo"
        }

        return x
    }

}