package net.morgan.oschina.base.moduleinterface.module.home;

import android.app.Activity;
import net.morgan.oschina.base.moduleinterface.provider.IHomeProvider;
import net.morgan.oschina.base.moduleinterface.router.ModuleManager;
import net.morgan.oschina.base.moduleinterface.router.ServiceManager;

/**
 * Created by wxmylife on 2017/4/21.
 */

public class HomeService {

    private static boolean hasModule() {
        return ModuleManager.getInstance().hasModule(IHomeProvider.HOME_MAIN_SERVICE);
    }


    public static void selectedTab(Activity activity, int position) {
        if (!hasModule()) return;
        ServiceManager.getInstance().getHomeProvider().selectedTab(activity, position);
    }
}
