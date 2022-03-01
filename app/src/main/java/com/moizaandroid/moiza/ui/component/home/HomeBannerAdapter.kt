package com.moizaandroid.moiza.ui.component.home

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.moizaandroid.moiza.R

class HomeBannerAdapter(val context: Context?) : PagerAdapter() {

    val layout = arrayOf(
        R.layout.banner_gsm_item,
        R.layout.banner_dgsm_item,
        R.layout.banner_dsm_item,
        R.layout.banner_mirim_item,
        R.layout.banner_bsm_item
    )

    val schoolUrl = arrayOf(
        "http://gsm.gen.hs.kr/main/main.php",
        "http://www.dgsw.hs.kr/index.do",
        "https://dsmhs.djsch.kr/main.do",
        "https://school.busanedu.net/bssm-h/main.do",
        "https://www.e-mirim.hs.kr/main.do"
    )

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view =
            LayoutInflater.from(container.context).inflate(layout[position], container, false)
        container.addView(view)
        view.findViewById<TextView>(R.id.homepage_btn).setOnClickListener {
            goHomepage(position)
        }
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }

    override fun getCount(): Int {
        return 5
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return (view == `object`)
    }

    private fun goHomepage(position: Int) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse(schoolUrl[position]))
        context!!.startActivity(intent)
    }
}