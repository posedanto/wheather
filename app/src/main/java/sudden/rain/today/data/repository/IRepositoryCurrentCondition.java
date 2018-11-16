package sudden.rain.today.data.repository;

import sudden.rain.today.data.repository.callback.IRepositoryCurrentConditionCallback;
import sudden.rain.today.data.repository.callback.IRepositoryLocationsCallback;

public interface IRepositoryCurrentCondition {
    void requestCurrentCondition(String location, String lang, boolean details,IRepositoryCurrentConditionCallback callback);
}
