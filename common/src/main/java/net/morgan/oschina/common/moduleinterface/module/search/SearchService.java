package net.morgan.oschina.common.moduleinterface.module.search;

import android.support.v4.app.Fragment;
import net.morgan.oschina.common.moduleinterface.provider.ISearchProvider;
import net.morgan.oschina.common.moduleinterface.router.ModuleManager;
import net.morgan.oschina.common.moduleinterface.router.ServiceManager;

/**
 * Created by wxmylife on 2017/4/21.
 */

public class SearchService {

    private static boolean hasSearch() {
        return ModuleManager.getInstance().hasModule(ISearchProvider.SEARCH_MAIN_SERVICE);
    }

    public static Fragment getSearchFragment(Object... args) {
        if (!hasSearch()) return null;
        return ServiceManager.getInstance().getSearchProvider().newInstance(args);
    }

}
