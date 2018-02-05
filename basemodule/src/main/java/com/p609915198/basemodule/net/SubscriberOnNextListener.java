package com.p609915198.basemodule.net;

public abstract class SubscriberOnNextListener<T> {
    protected abstract void onNext(T t);

    public void onError(Throwable e) {
    }
}