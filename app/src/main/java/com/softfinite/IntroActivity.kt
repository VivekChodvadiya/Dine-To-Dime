package com.softfinite

import agency.tango.materialintroscreen.MaterialIntroActivity
import android.os.Bundle
import android.content.Intent
import com.softfinite.fragment.*

/**
 * Created by Softfinite (Viv'Ek Chodvadiya) on 13-Jun-18.
 */

class IntroActivity : MaterialIntroActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableLastSlideAlphaExitTransition(true);
//        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        backButtonTranslationWrapper
                .setEnterTranslation { view, percentage -> view.alpha = percentage }

        addSlide(IntroOneFragment())
        addSlide(IntroSecondFragment())
        addSlide(IntroThirdFragment())
        addSlide(IntroForthFragment())
        addSlide(IntroFiveFragment())
        addSlide(IntroSixFragment())
        addSlide(IntroSevenFragment())
        addSlide(IntroEightFragment())
        addSlide(IntroNineFragment())
    }

    override fun onFinish() {
        super.onFinish()
        val i = Intent(this@IntroActivity, LoginActivity::class.java)
        startActivity(i)
        finish()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
}
