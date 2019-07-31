package com.takehome.opentabletakehome.base;

/**
 * Created by nivesuresh on 7/26/19.
 */

public interface IPresenter  {
    void getFirstPageResults();
    void getNextResults();
    boolean hasMore();
}
