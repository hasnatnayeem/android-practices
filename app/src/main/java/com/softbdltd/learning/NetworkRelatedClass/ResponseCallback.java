package com.softbdltd.learning.NetworkRelatedClass;

/**
 * Created by nayeem on 1/2/18.
 */

public interface ResponseCallback<T> {
    void onSuccess(T data);
    void onError(Throwable th);
}
