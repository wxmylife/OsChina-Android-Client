package net.morgan.oschina.common.moduleinterface.module.app;

import net.morgan.oschina.common.moduleinterface.provider.IAppProvider;
import net.morgan.oschina.common.moduleinterface.router.ModuleManager;

/**
 * Created by wxmylife on 2017/4/21.
 */

public class AppService {

    private static boolean hasModule(){
        return ModuleManager.getInstance().hasModule(IAppProvider.APP_MAIN_SERVICE);
    }
}
