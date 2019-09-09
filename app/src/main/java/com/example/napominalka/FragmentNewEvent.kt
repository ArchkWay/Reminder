package com.example.napominalka

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_newevent.*


class FragmentNewEvent : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_newevent, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listenSeekBar(sbMinutes, tvMinutes, "minutes")
        listenSeekBar(sbHours, tvHours, "hours")
        listenSeekBar(sbDays, tvDays, "days")
    }

    private fun listenSeekBar(seekBar: SeekBar, textView: TextView, type: String) {
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                textView.text =" $progress $type"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })
    }

}
