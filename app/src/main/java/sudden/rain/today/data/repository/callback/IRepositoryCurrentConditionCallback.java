package sudden.rain.today.data.repository.callback;

import sudden.rain.today.data.model.CurrentCondition;

public interface IRepositoryCurrentConditionCallback {
    void onCurrentConditionLoaded(CurrentCondition condition);

    void onFailure(Throwable throwable);
}
