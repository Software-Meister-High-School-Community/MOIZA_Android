package com.moizaandroid.moiza.ui.component.home

import android.graphics.Color
import android.text.Html
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.moizaandroid.moiza.R
import com.moizaandroid.moiza.databinding.FragmentHomeBannerBinding
import com.moizaandroid.moiza.ui.base.BaseFragment

class BannerFragment : BaseFragment<FragmentHomeBannerBinding>(R.layout.fragment_home_banner) {

    var dots: Array<TextView?> = emptyArray()

    override fun init() {
        initSchoolBanner()
        draw()
        changePage()
        clickSearchBtn()
    }

    private fun initSchoolBanner() {
        binding.schoolBanner.adapter = HomeBannerAdapter()
    }

    private fun dotselect(position: Int) {
        for (i in 0..dots.size - 1) {
            if (i == position) {
                dots[i]?.setTextColor(Color.parseColor("#555555"))
            } else {
                dots[i]?.setTextColor(Color.parseColor("#999999"))
            }
        }
    }

    private fun Indicator() {
        for (i in 0..dots.size - 1) {
            dots[i] = TextView(context)
            dots[i]?.setText(Html.fromHtml("&#9679;"))
            dots[i]?.setTextSize(8f)
            if (i == 0) {
                dots[i]?.setTextColor(Color.parseColor("#555555"))
            } else {
                dots[i]?.setTextColor(Color.parseColor("#999999"))
            }
            binding.dotPager.addView(dots[i])
        }
    }

    private fun draw() {
        dots = arrayOfNulls<TextView>(5)
        Indicator()
    }

    private fun changePage() {
        binding.schoolBanner.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                dotselect(position)
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })
    }

    fun clickSearchBtn() {
        binding.searchTabBtn.setOnClickListener {
            this.findNavController().navigate(R.id.action_bannerFragment_to_searchFragment)
        }
    }

}