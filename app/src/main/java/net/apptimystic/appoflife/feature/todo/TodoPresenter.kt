package net.apptimystic.appoflife.feature.todo

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TodoPresenter @Inject constructor(var model: TodoActivityMVP.Model) : TodoActivityMVP.Presenter {

    var disposable: Disposable? = null
    override var view: TodoActivityMVP.View? = null

    override fun loadData() {
        disposable = model
                .result()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {result -> view?.updateData(result) },
                        {error -> view?.showSnackBar(error.localizedMessage)}
                )
    }

    override fun rxUnsubscribe() {
        disposable?.dispose()
    }
}