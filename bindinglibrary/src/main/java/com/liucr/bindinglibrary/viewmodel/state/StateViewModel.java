package com.liucr.bindinglibrary.viewmodel.state;

import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.IntDef;


/**
 * Created by liucr on 2018/5/16.
 */
public class StateViewModel {

    public final MutableLiveData<Integer> viewState = new MutableLiveData<>();
    public final MutableLiveData<Integer> viewEmptyStringRes = new MutableLiveData<>();
    public final MutableLiveData<Integer> viewErrorStringRes = new MutableLiveData<>();

    public final static class State {
        public final static int STATE_DEFAULT = 0;
        public final static int STATE_CONTENT = 1;
        public final static int STATE_EMPTY = 2;
        public final static int STATE_ERROR = 3;

        @IntDef({STATE_DEFAULT, STATE_CONTENT, STATE_EMPTY, STATE_ERROR})
        public @interface ViewState {

        }
    }
}
