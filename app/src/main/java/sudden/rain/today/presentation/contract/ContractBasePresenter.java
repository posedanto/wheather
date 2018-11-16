package sudden.rain.today.presentation.contract;

public interface ContractBasePresenter<T> {
    void attachView(T view);

    void detachView();
}
