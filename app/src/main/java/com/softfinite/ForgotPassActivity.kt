package com.softfinite

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_forgot_pass.*


/**
 * Created by Softfinite (Viv'Ek Chodvadiya) on 13-Jun-18.
 */

class ForgotPassActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_pass)
        init()
    }

    private fun init() {

        llBack.setOnClickListener {
            finish()
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
        btnSubimtPass.setOnClickListener {
            showToast("Success")
            finish()
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }
}
