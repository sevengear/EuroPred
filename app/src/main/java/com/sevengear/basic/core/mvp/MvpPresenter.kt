package com.sevengear.basic.core.mvp

abstract class MvpPresenter<T : MvpView> {

    var view: T? = null

}