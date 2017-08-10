package net.morgan.oschina.common.moduleinterface.module.comment;

import android.app.Activity;
import java.io.Serializable;
import net.morgan.oschina.common.moduleinterface.config.ModuleBundle;
import net.morgan.oschina.common.moduleinterface.provider.ICommentProvider;
import net.morgan.oschina.common.moduleinterface.router.ModuleManager;
import net.morgan.oschina.common.moduleinterface.router.ModuleRouter;

/**
 * Created by wxmylife on 2017/4/21.
 */

public class CommentIntent {

    private static boolean hasComment() {
        return ModuleManager.getInstance().hasModule(ICommentProvider.COMMENT_MAIN_SERVICE);
    }

    public static void launchComment(Activity activity, int requestCode, Serializable data) {
        if (!hasComment()) return;
        ModuleBundle bundle = new ModuleBundle();
        bundle.put("data", data);
        ModuleRouter.newInstance(ICommentProvider.COMMENT_ACT_MAIN)
            .withBundle(bundle)
            .navigation(activity, requestCode);
    }
}
