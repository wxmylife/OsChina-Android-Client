package net.morgan.oschina.common.moduleinterface.provider;

/**
 * Created by wxmylife on 2017/4/21.
 */

public interface ICommentProvider extends IFragmentProvider {
    //服务
    String COMMENT_MAIN_SERVICE = "/comment/main/service";
    //作为Fragment被添加时候的key
    String COMMENT_KEY_FRAGMENT = "comment_key_fragment";

    String COMMENT_ACT_MAIN = "/comment/act/main";
}
