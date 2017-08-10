package net.morgan.oschina.common.moduleinterface.router;

import net.morgan.oschina.common.moduleinterface.config.ModuleOptions;

/**
 * Created by wxmylife on 2017/4/20.
 */

public class ModuleManager {

    private ModuleOptions options;

    private ModuleManager(){}

    private static class ModuleManagerHolder{
        private static final ModuleManager instance=new ModuleManager();
    }

    public static ModuleManager getInstance(){
        return ModuleManagerHolder.instance;
    }

    public void init(ModuleOptions options) {
        if (this.options == null && options != null) {
            this.options = options;
        }
    }

    public ModuleOptions getOptions() {
        return options;
    }

    public boolean hasModule(String key) {
        return options.hasModule(key);
    }


}
