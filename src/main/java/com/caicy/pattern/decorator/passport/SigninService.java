package com.caicy.pattern.decorator.passport;

import com.caicy.pattern.template.entity.User;


/**
 * 老的接口
 */
public class SigninService implements ISigninService {

    /**
     * 注册方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg regist(String username, String password){
        return  new ResultMsg(200,"注册成功",new User());
    }


    /**
     * 登录的方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg login(String username, String password){
        return null;
    }

}
