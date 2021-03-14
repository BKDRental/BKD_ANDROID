package app.mimo.it.core.utils

import android.os.Parcel
import android.os.Parcelable
import androidx.core.util.Pair
import androidx.fragment.app.FragmentManager
import app.mimo.it.core.R
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.MaterialDatePicker
import java.util.concurrent.TimeUnit

object DialogUtils {
    fun dataPickerDialog(
        fragmentManager: FragmentManager,
        listener: (start: Long?, end: Long?) -> Unit
    ) {
        val builder: MaterialDatePicker.Builder<Pair<Long, Long>> =
            MaterialDatePicker.Builder.dateRangePicker()
        val constraintsBuilder = CalendarConstraints.Builder()
        val rangeDateValidator = RangeDateValidator(10)
        constraintsBuilder.setValidator(rangeDateValidator)
        builder.setCalendarConstraints(constraintsBuilder.build())
        builder.setTheme(R.style.ThemeOverlay_MaterialComponents_MaterialCalendar)
        val picker = builder.build()
        rangeDateValidator.rangePicker = picker
        picker.addOnPositiveButtonClickListener {
            listener.invoke(it.first, it.second)
        }
        picker.show(fragmentManager, picker.toString())
    }

    class RangeDateValidator(private val numberOfDays: Int) : CalendarConstraints.DateValidator {

        var rangePicker: MaterialDatePicker<Pair<Long, Long>>? = null

        constructor(parcel: Parcel) : this(parcel.readInt())

        override fun isValid(date: Long): Boolean {
            val selection = rangePicker!!.selection
            if (selection != null) {
                val startDate = selection.first
                if (startDate != null) {
                    val days = (numberOfDays - 1) * TimeUnit.DAYS.toMillis(1)
                    if (date > startDate + days) return false
                    if (date < startDate) return false
                }
            }
            return true
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeInt(numberOfDays)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<RangeDateValidator> {
            override fun createFromParcel(parcel: Parcel): RangeDateValidator {
                return RangeDateValidator(parcel)
            }

            override fun newArray(size: Int): Array<RangeDateValidator?> {
                return arrayOfNulls(size)
            }
        }
    }
}
