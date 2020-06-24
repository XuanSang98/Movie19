package com.sunasterisk.movie19.base

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    abstract val compositeDisposable: CompositeDisposable

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}
