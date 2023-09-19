package com.example.caculatorudemy

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class SharedViewModel: ViewModel() {
    val expression = mutableListOf<Any>()

}