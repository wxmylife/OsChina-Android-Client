package net.morgan.oschina.tweet;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import net.morgan.oschina.base.BaseRecyclerFragment;

/**
 * Created by wxmylife on 2017/4/21.
 */

public class TweetFragment extends BaseRecyclerFragment {

    public static TweetFragment newInstance(Object... args) {
        return new TweetFragment();
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new TweetAdapter(initTestData());
    }

    @Override
    protected View getContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tweet_fragment_main, container,false);
    }

    private List<Books> initTestData() {
        List<Books> mDatas = new ArrayList<>();
        mDatas.add(new Books("书名A", "作者A"));
        mDatas.add(new Books("书名B", "作者B"));
        mDatas.add(new Books("书名C", "作者C"));
        mDatas.add(new Books("书名D", "作者D"));
        mDatas.add(new Books("书名E", "作者E"));
        mDatas.add(new Books("书名F", "作者F"));
        mDatas.add(new Books("书名G", "作者G"));
        mDatas.add(new Books("书名H", "作者H"));
        mDatas.add(new Books("书名I", "作者I"));
        mDatas.add(new Books("书名J", "作者J"));
        mDatas.add(new Books("书名K", "作者K"));
        return mDatas;
    }
}
