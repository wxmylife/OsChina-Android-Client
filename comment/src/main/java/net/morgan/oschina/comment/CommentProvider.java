package net.morgan.oschina.comment;

import android.content.Context;
import android.support.v4.app.Fragment;
import com.alibaba.android.arouter.facade.annotation.Route;
import net.morgan.oschina.common.moduleinterface.provider.ICommentProvider;

import static net.morgan.oschina.common.moduleinterface.provider.ICommentProvider.COMMENT_MAIN_SERVICE;

/**
 * Created by wxmylife on 2017/4/21.
 */
@Route(path = COMMENT_MAIN_SERVICE)
public class CommentProvider implements ICommentProvider {
    @Override
        public Fragment newInstance(Object... args) {
            return CommentFragment.newInstance(args);
        }

    @Override public void init(Context context) {

    }
}
