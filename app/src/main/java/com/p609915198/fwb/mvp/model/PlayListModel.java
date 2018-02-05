package com.p609915198.fwb.mvp.model;

import com.p609915198.basemodule.base.BaseModel;
import com.p609915198.basemodule.di.scope.FragmentScope;
import com.p609915198.basemodule.net.Api;
import com.p609915198.basemodule.net.response.Audio;
import com.p609915198.fwb.mvp.contract.PlayListContract;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/12/25.
 */
@FragmentScope
public class PlayListModel extends BaseModel implements PlayListContract.Model {
    @Inject Api mApi;

    @Inject
    public PlayListModel() {
        super();
    }

    @Override
    public Observable<List<Audio>> audioList(int page, int pagesize, String room_id, String user_id) {
        return mApi.audioList(page, pagesize, room_id, user_id);
    }
}