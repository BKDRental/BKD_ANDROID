package app.mimo.it.bkd.viewModel

import androidx.lifecycle.viewModelScope
import app.mimo.it.core.base.BaseViewModel
import app.mimo.it.core.utils.DateUtils
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : BaseViewModel() {

    private val _titleDay: MutableStateFlow<Boolean> = MutableStateFlow(true)
    val titleDay: StateFlow<Boolean> get() = _titleDay

    private val _showDate: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val showDate: StateFlow<Boolean> get() = _showDate

    private val _startDay: MutableStateFlow<CharSequence?> = MutableStateFlow(null)
    val startDay: StateFlow<CharSequence?> get() = _startDay

    private val _startMonth: MutableStateFlow<CharSequence?> = MutableStateFlow(null)
    val startMonth: StateFlow<CharSequence?> get() = _startMonth

    private val _startWeek: MutableStateFlow<CharSequence?> = MutableStateFlow(null)
    val startWeek: StateFlow<CharSequence?> get() = _startWeek

    private val _endDay: MutableStateFlow<CharSequence?> = MutableStateFlow(null)
    val endDay: StateFlow<CharSequence?> get() = _endDay

    private val _endMonth: MutableStateFlow<CharSequence?> = MutableStateFlow(null)
    val endMonth: StateFlow<CharSequence?> get() = _endMonth

    private val _endWeek: MutableStateFlow<CharSequence?> = MutableStateFlow(null)
    val endWeek: StateFlow<CharSequence?> get() = _endWeek

    private val _pickUpTime: MutableStateFlow<List<String>> = MutableStateFlow(mutableListOf())
    val pickUpTime: StateFlow<List<String>> get() = _pickUpTime

    fun getDate(start: Long?, end: Long?) = viewModelScope.launch {
        start?.let {
            showTitle()
            showStartDate(it)
        }
        end?.let {
            showEndDate(it)
        }
    }

    private suspend fun showTitle() = viewModelScope.launch {
        _titleDay.emit(false)
        _showDate.emit(true)
    }

    private suspend fun showStartDate(date: Long) = viewModelScope.launch {
        _startDay.emit(DateUtils.getDay(date))
        _startMonth.emit(DateUtils.getMonth(date))
        _startWeek.emit(DateUtils.getWeek(date))
    }

    private suspend fun showEndDate(date: Long) = viewModelScope.launch {
        _endDay.emit(DateUtils.getDay(date))
        _endMonth.emit(DateUtils.getMonth(date))
        _endWeek.emit(DateUtils.getWeek(date))
    }

    private fun initTime() = viewModelScope.launch {
        _pickUpTime.value = mutableListOf(
            "09:30",
            "10:00",
            "10:30",
            "11:00",
            "11:30",
            "12:00",
            "12:30",
            "13:00",
            "13:30",
            "14:00",
            "14:30",
            "15:00",
            "15:30",
            "16:00",
            "16:30",
            "17:00",
            "17:30",
            "18:00",
            "18:30"
        )
    }

    init {
        initTime()
    }
}