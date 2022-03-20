package com.moizaandroid.moiza.ui.home

import android.graphics.Color
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.text.Html
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.moizaandroid.moiza.R
import com.moizaandroid.moiza.databinding.FragmentHomeBannerBinding
import com.moizaandroid.moiza.ui.base.BaseFragment

class BannerFragment : BaseFragment<FragmentHomeBannerBinding>(R.layout.fragment_home_banner) {

    var dots: Array<TextView?> = emptyArray()
    var time: Long = 1500
    private val Handler = HomeBannerHandler()

    override fun onResume() {
        super.onResume()
        autoScroll(time)
    }

    override fun onPause() {
        super.onPause()
        autoScrollStop()
    }

    override fun init() {
        initSchoolBanner()
        draw()
        changePage()
        clickSearchBtn()
    }

    private fun initSchoolBanner() {
        binding.schoolBanner.adapter = HomeBannerAdapter(context)
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
            dots[i]?.setPadding(5, 0, 5, 0)
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
                when (state) {
                    ViewPager.SCROLL_STATE_DRAGGING -> autoScrollStop()
                    ViewPager.SCROLL_STATE_IDLE -> autoScroll(time)
                }
            }
        })
    }

    private fun clickSearchBtn() {
        binding.searchTabBtn.setOnClickListener {
            this.findNavController().navigate(R.id.action_bannerFragment_to_searchFragment)
        }
    }

    private fun autoScroll(time: Long) {
        Handler.removeMessages(0)
        Handler.sendEmptyMessageDelayed(0, time)
    }

    private fun autoScrollStop() {
        Handler.removeMessages(0)
    }

    private inner class HomeBannerHandler : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if (msg.what == 0) {
                binding.schoolBanner.setCurrentItem(
                    if (binding.schoolBanner.currentItem >= 4) 0 else ++binding.schoolBanner.currentItem,
                    true
                )
                autoScroll(time)
            }
        }
    }
}