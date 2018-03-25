package com.caicy.pattern.delegate.leader;

import java.util.HashMap;
import java.util.Map;

public class Leader implements Worker{

    private static Map<String,Worker> handlers = new HashMap<String,Worker>();

    static {
        handlers.put("加密",new EmployeeA());
        handlers.put("登录",new EmployeeB());
    }

    @Override
    public void doWorker(String cmd) {
        handlers.get(cmd).doWorker(cmd);

    }
}
