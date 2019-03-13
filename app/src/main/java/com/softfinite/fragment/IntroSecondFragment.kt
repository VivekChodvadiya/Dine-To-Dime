package com.softfinite.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox

import com.softfinite.R

import agency.tango.materialintroscreen.SlideFragment

class IntroSecondFragment : SlideFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frag_intro_two, container, false)
    }

    override fun backgroundColor(): Int {
        return R.color.second_intro
    }

    override fun buttonsColor(): Int {
        return R.color.custom_slide_buttons
    }
}