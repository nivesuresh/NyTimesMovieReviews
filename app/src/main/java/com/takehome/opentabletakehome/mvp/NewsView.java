package com.takehome.opentabletakehome.mvp;

import com.takehome.opentabletakehome.base.IBaseView;
import com.takehome.opentabletakehome.models.ResultsModel;

import java.util.List;

/**
 * Created by nivesuresh on 7/25/19.
 */

public interface NewsView extends IBaseView {
    void addToResults();
    void updateResults(List<ResultsModel> resultsList);
}
