package com.moizaandroid.moiza.ui.component.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.moizaandroid.moiza.R

class HomeBannerAdapter : PagerAdapter() {

    val layout = arrayOf(
        R.layout.banner_gsm_item,
        R.layout.banner_dgsm_item,
        R.layout.banner_dsm_item,
        R.layout.banner_mirim_item,
        R.layout.banner_bsm_item
    )

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view =
            LayoutInflater.from(container.context).inflate(layout[position], container, false)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)
    }

    override fun getCount(): Int {
        return 5
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return (view == `object`)
    }
}