package net.morgan.oschina.common.moduleinterface.module.home;

import net.morgan.oschina.common.moduleinterface.config.ModuleBundle;
import net.morgan.oschina.common.moduleinterface.provider.IHomeProvider;
import net.morgan.oschina.common.moduleinterface.router.ModuleManager;
import net.morgan.oschina.common.moduleinterface.router.ModuleRouter;

/**
 * Created by wxmylife on 2017/4/21.
 */

public class HomeIntent {

    private static boolean hasModule() {
        return ModuleManager.getInstance().hasModule(IHomeProvider.HOME_MAIN_SERVICE);
    }

    public static void launchHome(int tabType) {
        ModuleBundle bundle=new ModuleBundle();
        bundle.put(IHomeProvider.HOME_TABTYPE,tabType);
        ModuleRouter.newInstance(IHomeProvider.HOME_ACT_HOME)
            .withBundle(bundle)
            .navigation();
    }
}
