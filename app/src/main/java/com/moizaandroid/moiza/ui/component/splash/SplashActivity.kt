package com.moizaandroid.moiza.ui.component.splash

import android.content.Intent
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.annotation.UiThread
import com.moizaandroid.moiza.R
import com.moizaandroid.moiza.databinding.ActivitySplashBinding
import com.moizaandroid.moiza.ui.base.BaseActivity
import com.moizaandroid.moiza.ui.component.login.activity.SignInActivity
import com.moizaandroid.moiza.ui.component.register.SignUpActivity

class SplashActivity : BaseActivity<ActivitySplashBinding>(
    R.layout.activity_splash
) {
    override fun initView() {
        splashAnimation()

        binding.tvSignIn.setOnClickListener {
            gotoSignIn()
        }

        binding.tvSignUp.setOnClickListener {
            gotoSignUp()
        }
    }

    override fun observeEvent() {}

    @UiThread
    private fun splashAnimation() {

        val textAnim = AnimationUtils.loadAnimation(this, R.anim.anim_splash_textview)
        val imageAnim = AnimationUtils.loadAnimation(this, R.anim.anim_splash_imageview)

        binding.splashTvTitle.startAnimation(textAnim)
        binding.splashTvLore.startAnimation(textAnim)
        binding.splashIvLogo.startAnimation(imageAnim)

        textAnim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation) {
                binding.tvSignIn.visibility = View.VISIBLE
                binding.tvSignUp.visibility = View.VISIBLE
            }

            override fun onAnimationRepeat(p0: Animation?) {
            }
        })
    }

    private fun gotoSignUp() {
        val intent = Intent(applicationContext, SignUpActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun gotoSignIn() {
        val intent = Intent(applicationContext, SignInActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}