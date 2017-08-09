package net.morgan.oschina.search;

import android.content.Context;
import android.support.v4.app.Fragment;
import com.alibaba.android.arouter.facade.annotation.Route;
import net.morgan.oschina.common.moduleinterface.provider.ISearchProvider;

import static net.morgan.oschina.common.moduleinterface.provider.ISearchProvider.SEARCH_MAIN_SERVICE;

/**
 * Created by wxmylife on 2017/4/21.
 */
@Route(path = SEARCH_MAIN_SERVICE)
public class SearchProvider implements ISearchProvider {
    @Override public Fragment newInstance(Object... args) {
        return SearchFragment.newInstance(args);
    }


    @Override public void init(Context context) {

    }
}
