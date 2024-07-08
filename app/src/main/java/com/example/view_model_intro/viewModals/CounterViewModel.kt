package com.example.view_model_intro.viewModals

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private val _count = mutableIntStateOf(0)
    
    fun getCount(): Int {
        return _count.value;
    }

    fun increment() {
        _count.value++
    }

    fun decrement() {
        _count.value--
    }
}