package com.example.napominalka

import android.annotation.SuppressLint
import android.icu.util.IslamicCalendar
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.TextView
import com.example.napominalka.utils.DatePojo
import com.example.napominalka.utils.dataCalculate
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
        setCurrentValues()
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

    @SuppressLint("SetTextI18n")
    private fun setCurrentValues(){
            val currentDateCalculated:DatePojo = dataCalculate()
            val currentMinuts = currentDateCalculated.minute
            val currentHours = currentDateCalculated.hour
            val currentDays = currentDateCalculated.day
            val currentDaysOfMonth = currentDateCalculated.daysOfMonth

            sbDays.max = currentDaysOfMonth
            sbDays.progress = currentDays
            tvDays.text = "$currentDays day"
            sbHours.progress = currentHours
            tvHours.text = "$currentHours hours"
            sbMinutes.progress = currentMinuts
            tvMinutes.text = "$currentMinuts minutes"
    }

}
