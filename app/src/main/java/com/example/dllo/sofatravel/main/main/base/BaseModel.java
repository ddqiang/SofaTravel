package com.example.dllo.sofatravel.main.main.base;

/**
 * Created by dllo on 16/7/18.
 */
public interface BaseModel<T> {
    //将 presenter 传给 Modle
    void setPresenter(T presenter);

}
