package com.caicy.pattern.delegate.mvc;

import com.caicy.pattern.delegate.mvc.controller.OrderController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用spring mvc来进行模拟
 * 以下是伪代码
 */
public class ServletDispatcher {

    private List<Handler> handlerMapping = new ArrayList<Handler>();

    public ServletDispatcher() {
        try {
            Class<?> orderControllerClass = OrderController.class;
            handlerMapping.add(new Handler()
                    .setController(orderControllerClass.newInstance())
                    .setMethod(orderControllerClass.getMethod("getOrderById", new Class[]{String.class}))
                    .setUrl("/web/getOrderById.json"));
        } catch (Exception e) {

        }
    }


    public void doService(HttpServletRequest request, HttpServletResponse response) {
        doDispatch(request, response);
    }


    private void doDispatch(HttpServletRequest request, HttpServletResponse response) {

        //1、获取用户请求的url
        //   如果按照J2EE的标准、每个url对对应一个Serlvet，url由浏览器输入
        String uri = request.getRequestURI();

        //2、Servlet拿到url以后，要做权衡（要做判断，要做选择）
        //   根据用户请求的URL，去找到这个url对应的某一个java类的方法

        //3、通过拿到的URL去handlerMapping（我们把它认为是策略常量）
        Handler handle = null;
        for (Handler h : handlerMapping) {
            if (uri.equals(h.getUrl())) {
                handle = h;
                break;
            }
        }

        //4、将具体的任务分发给Method（通过反射去调用其对应的方法）
        Object object = null;
        try {
            object = handle.getMethod().invoke(handle.getController(), request.getParameter("mid"));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //5、获取到Method执行的结果，通过Response返回出去
//        response.getWriter().write();


    }

    class Handler {

        private Object controller;
        private Method method;
        private String url;

        public Object getController() {
            return controller;
        }

        public Handler setController(Object controller) {
            this.controller = controller;
            return this;
        }

        public Method getMethod() {
            return method;
        }

        public Handler setMethod(Method method) {
            this.method = method;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Handler setUrl(String url) {
            this.url = url;
            return this;
        }
    }

}
