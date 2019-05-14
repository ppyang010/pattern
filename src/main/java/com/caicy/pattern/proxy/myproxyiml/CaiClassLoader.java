package com.caicy.pattern.proxy.myproxyiml;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class CaiClassLoader extends ClassLoader {

    private static File classPathFile;

    public CaiClassLoader(){
        String classPath = CaiClassLoader.class.getResource("").getPath();
        CaiClassLoader.classPathFile = new File(classPath);
    }

    /**
     * 查找当前类加载器所在目录的class并加载
     *
     * 重写这个方法可以自定义查找哪些目录下的class  甚至可以找网络中的
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //完整类名
        String classFullName = CaiClassLoader.class.getPackage().getName() + "." + name;
        //目录存在
        if(classPathFile != null){
            File classFile = new File(classPathFile,name.replaceAll("\\.","/") + ".class");
            if(classFile.exists()){
                //将class文件 写入内存 变为字节码数组
                FileInputStream in =null;
                ByteArrayOutputStream out =null;
                try {
                    in = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();
                    byte[] buff =new byte[1024];
                    int len;
                    while((len=in.read(buff))!=-1){
                        out.write(buff,0,len);
                    }
                    //把字节数组 b中的内容转换成 Java 类，
                    return defineClass(classFullName,out.toByteArray(),0,out.size());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}
