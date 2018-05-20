package com.caicy.pattern.proxy.myproxyiml;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicLong;

public class CaiProxy {
    public static final String ln = "\r\n";
    // 所有代理类ProxyClass名字的前缀
    private static final String proxyClassNamePrefix = "$CaiProxy";
    // 用计数器生成代理类ProxyClass的名字
    private static final AtomicLong nextUniqueNumber = new AtomicLong();

    /**
     * 动态生成代理类
     * @param classloader 被代理类的类加载器
     * @param interfaces 被代理类的所有接口
     * @param h  代理类的方法调用时的具体调用者（可以理解为传入的回调函数） 用于被代理类的方法增强
     * @return
     */
    public static Object newProxyInstance(CaiClassLoader  classloader, Class<?> [] interfaces, CaiInvocationHandler h){
        try{

            //1.动态生成实现了所有interfaces代理类 的源代码 .java文件
            String proxyClassName = proxyClassNamePrefix+nextUniqueNumber.getAndAdd(1);
            String javaFileStr = generateSrc(proxyClassName,interfaces,h);
//            System.out.println(javaFileStr);

            //2..java 文件保存到本地
            //获取类的资源路径 这个方法内部会调用对应加载自身的classloader 调用classloader.getResource() 方法
            String javaFilePath = CaiProxy.class.getResource("").getPath();
            System.out.println(javaFilePath);
            File file = new File(javaFilePath + proxyClassName+".java");
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            fw.write(javaFileStr);
            fw.flush();
            fw.close();

            //3. 讲.java 文件编译成 .class
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manage = compiler.getStandardFileManager(null,null,null);
            Iterable<? extends JavaFileObject> iterable = manage.getJavaFileObjects(file);
            JavaCompiler.CompilationTask task = compiler.getTask(null,manage,null,null,null,iterable);
            task.call();
            manage.close();
            //4. 将.class 文件加载到jvm
            //系统自带的classloader 找不到文件 使用自定义类加载器 支持类全名和只有类名
            Class<?> aClass = classloader.loadClass("com.caicy.pattern.proxy.myproxyiml."+proxyClassName);
            //使用方式2 必须是类全名
//            Class<?> aClass = Class.forName("com.caicy.pattern.proxy.myproxyiml."+proxyClassName, true, classloader);
            //获取参数为CaiInvocationHandler 类型的的构造器方法
            Constructor<?> constructor = aClass.getConstructor(h.getClass());
            //5.返回代理类对象
            return constructor.newInstance(h);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private static String generateSrc(String proxyClassName, Class<?>[] interfaces, CaiInvocationHandler h) {
        StringBuffer sb =new StringBuffer();
        //packing 和 import
        //TODO 暂时硬编码
        sb.append("package com.caicy.pattern.proxy.myproxyiml;" + ln);
        //这段参考jdk生成代理类的反编译
        sb.append("import java.lang.reflect.Method;\n" +
                "import java.lang.reflect.UndeclaredThrowableException;"+ln);
        //循环便利要被代理类的接口
        StringBuffer impls = new StringBuffer();
        for(int i = 0; i<interfaces.length; i++){
            sb.append("import " + interfaces[i].getTypeName() + ";" +ln);
            if (i != interfaces.length - 1){
                impls.append(interfaces[i].getName()+", ");
            }else {
                impls.append(interfaces[i].getName()+" ");
            }
        }

        //class
        sb.append("public final class "+proxyClassName+" extends "+CaiProxy.class.getName()+" implements "+impls.toString()+" {"+ln);

            sb.append("CaiInvocationHandler h;"+ln);
            //构造函数
            sb.append("public "+proxyClassName+"("+h.getClass().getName()+" h) {"+ln);
            sb.append("this.h = h;"+ln);
            sb.append("}"+ln);

            //实现所有接口的方法
            //todo object类的方法暂时实现
            //todo 暂时都硬编码为是一个string参数的方法
            for(int i = 0; i<interfaces.length;i++){
                for(Method m : interfaces[i].getMethods()){
                    sb.append("public final "+m.getReturnType().getName() + " " + m.getName() + "(String var1) {" + ln);
                        sb.append("try{" + ln);
                        sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\",Class.forName(\"java.lang.String\"));" + ln);
                        sb.append("this.h.invoke(this,m,new Object[]{var1});" + ln);
                        sb.append("}catch(Throwable e){" + ln);
                        sb.append("e.printStackTrace();" + ln);
                        sb.append("}");

                    sb.append("}"+ln);
                }

            }



        sb.append("}"+ln);

        return sb.toString();
    }
}
