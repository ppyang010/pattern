package com.caicy.pattern.decorator.passport;

public class SiginForThirdService implements ISigninService {

    public ResultMsg loginForQQ(String openId){
        return loginForRegist(openId,null);
    }



    public ResultMsg loginForRegist(String username, String password){
        this.regist(username,null);
        return this.login(username,null);
    }


    @Override
    public ResultMsg regist(String username, String password) {
        return null;
    }

    @Override
    public ResultMsg login(String username, String password) {
        return null;
    }
}
