package net.morgan.oschina.base.moduleinterface.provider;

/**
 * Created by wxmylife on 2017/4/21.
 */

public interface IUserProvider extends IFragmentProvider{

    //服务
    String USER_MAIN_SERVICE = "/user/main/service";
    //作为Fragment被添加时候的key
    String USER_KEY_FRAGMENT = "user_key_fragment";
}
