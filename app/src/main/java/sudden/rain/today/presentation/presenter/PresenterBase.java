package sudden.rain.today.presentation.presenter;

import java.lang.ref.WeakReference;

import sudden.rain.today.presentation.contract.ContractBasePresenter;

public class PresenterBase<T> implements ContractBasePresenter<T> {

    private WeakReference<T> refView;

    @Override
    public void attachView(T view){
        refView = new WeakReference<>(view);
    }

    @Override
    public void detachView(){
        refView.clear();
    }

    public T getView() {
        if (refView == null || refView.get() == null)
            return null;

        return refView.get();
    }
}
