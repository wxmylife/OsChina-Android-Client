package net.morgan.oschina.base.moduleinterface.module.user;

import net.morgan.oschina.base.moduleinterface.config.ModuleBundle;
import net.morgan.oschina.base.moduleinterface.provider.IUserProvider;
import net.morgan.oschina.base.moduleinterface.router.ModuleManager;
import net.morgan.oschina.base.moduleinterface.router.ModuleRouter;

/**
 * Created by wxmylife on 2017/4/21.
 */

public class UserIntent {

    private static boolean hasModule() {
        return ModuleManager.getInstance().hasModule(IUserProvider.USER_MAIN_SERVICE);
    }

    public static void launchUser(int tabType) {
        ModuleBundle bundle=new ModuleBundle();
        bundle.put(IUserProvider.USER_MAIN_SERVICE,tabType);
        ModuleRouter.newInstance(IUserProvider.USER_MAIN_SERVICE)
            .withBundle(bundle)
            .navigation();
    }
}
