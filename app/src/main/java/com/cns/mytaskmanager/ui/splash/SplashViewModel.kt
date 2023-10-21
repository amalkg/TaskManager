package com.cns.mytaskmanager.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cns.mytaskmanager.Todo
import com.cns.mytaskmanager.data.DataStoreRepository
import com.cns.mytaskmanager.data.MainRepository
import com.cns.mytaskmanager.data.model.Todos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val dataRepository: DataStoreRepository
) :
    ViewModel() {

    val delay = MutableLiveData<Boolean>()

    init {
        splashDelay()
    }

    private fun splashDelay() {
        viewModelScope.launch {
            kotlin.runCatching {
                delay(2000)
            }.onSuccess {
                delay.value = true
            }.onFailure {

            }
        }
    }
}