package com.example.napominalka

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null) supportFragmentManager.beginTransaction().replace(R.id.flMainContainer, FragmentNewEvent()).commit()
        listenSwitcher()
    }

    private fun listenSwitcher() {
        tvNewEvent.setOnClickListener { supportFragmentManager.beginTransaction().replace(R.id.flMainContainer, FragmentNewEvent()).commit() }
        tvSchedules.setOnClickListener { supportFragmentManager.beginTransaction().replace(R.id.flMainContainer, FragmentSchedule()).commit() }
    }
}
//        val myDateListener = { view, year, month, dayOfMonth ->
//
//            val stringBuilder = StringBuilder()
//            if (dayOfMonth < 10) {
//                stringBuilder.append("0")
//            }
//            stringBuilder.append(dayOfMonth).append(".")
//            if (month < 10) {
//                stringBuilder.append("0")
//            }
//            stringBuilder.append(month).append(".").append(year)
//
//            birthday.setText(stringBuilder.toString())
//            toolbarDone.setVisibility(View.VISIBLE)
//            checkValidity()
//        }
//
//        val cal = Calendar.getInstance()
//        legalYearOfBirth = cal.get(Calendar.YEAR) - 13
//        val datePickerDialog = DatePickerDialog(
//            getContext(), myDateListener, legalYearOfBirth, cal.get(
//                Calendar.MONTH
//            ), cal.get(Calendar.DAY_OF_MONTH)
//        )
//        datePickerDialog.show()