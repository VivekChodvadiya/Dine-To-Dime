package com.softfinite

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.softfinite.utils.ExitStrategy
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*


/**
 * Created by Softfinite (Viv'Ek Chodvadiya) on 13-Jun-18.
 */

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
    }

    private fun init() {

        btnSignIn.setOnClickListener {
            val changePage = Intent(getActivity(), MainActivity::class.java)
            startNewActivity(changePage)
        }
        tvForgotPass.setOnClickListener {
            val changePage = Intent(getActivity(), ForgotPassActivity::class.java)
            startNewActivity(changePage)
        }
    }
}
