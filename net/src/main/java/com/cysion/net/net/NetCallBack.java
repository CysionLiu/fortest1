package com.cysion.net.net;

import com.cysion.ktbox.net.ApiException;
import retrofit2.Call;

public interface NetCallBack<T> {
    void onSuccess(Call<T> call, T t);

    void onError(Call<T> call, ApiException error);
}

