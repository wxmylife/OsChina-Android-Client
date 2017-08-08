package net.morgan.oschina.tweet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import net.morgan.oschina.base.view.adapter.BaseAdapter;
import net.morgan.oschina.base.view.adapter.VH;

/**
 * Created by wxmylife on 2017/4/21.
 */

public class TweetAdapter extends BaseAdapter<Books, TweetAdapter.TweetHolder> {

    public TweetAdapter(List<Books> mDatas) {
        super(mDatas);
    }

    @Override
    protected TweetHolder getHolder(ViewGroup parent, int viewType) {
        return new TweetHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.tweet_fragment_main_item, parent, false));
    }

    class TweetHolder extends VH<Books> {

        private TextView name;
        private TextView author;

        public TweetHolder(View itemView) {
            super(itemView);
            name = findvViewById(R.id.tweet_fragment_main_item_name);
            author = findvViewById(R.id.tweet_fragment_main_item_author);
        }

        @Override
        protected void setData(Books data) {
            name.setText(data.getName());
            author.setText(data.getAuthor());
        }
    }

}
