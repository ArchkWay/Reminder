package com.example.napominalka.utils

import java.util.*

fun dataCalculate() :DatePojo{
    val cal = Calendar.getInstance()
    var month: Int = cal.get(Calendar.MONTH)
    var day: Int = cal.get(Calendar.DAY_OF_MONTH)
    var hours: Int = cal.get(Calendar.HOUR_OF_DAY)+3//msk
    var minutes: Int = cal.get(Calendar.MINUTE)

    return DatePojo(minutes, hours, day, detectMonth(month, cal))

}
fun detectMonth(month: Int, calendar: Calendar) :Int{
    when(month){
        0,2,4,6,7,9,11 -> return 31
        1 -> if(calendar.get(Calendar.YEAR)%4 == 0){
            return 29
        }else return 28
        else -> return 30
    }
}