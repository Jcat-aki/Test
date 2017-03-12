package com.example.anakano.newscategory;

/**
 * コールバック関数<br>
 *     成功時と失敗時にコールバックを返す
 */

public interface OnCallback<T> {
    public void onSuccess(T object);
    public void onFailure(Exception e);
}
