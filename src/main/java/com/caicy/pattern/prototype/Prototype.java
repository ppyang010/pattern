package com.caicy.pattern.prototype;

import org.springframework.beans.BeanUtils;
import org.springframework.util.SerializationUtils;

import java.io.*;

public class Prototype implements Cloneable,Serializable {
    int a;
    String b;
    Field field;




    /**
     * 方式1
     * 使用java clone 方式 浅拷贝
     * @return
     */
    protected Prototype simpleCopy() {
        try {
            Prototype clone = (Prototype) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 方式2
     * 使用java clone 方式 深拷贝
     * 循环clone
     * 如果要实现深度拷贝，则需要将实现了Cloneable接口并重写了clone方法的类中，所有的引用类型也全部实现Cloneable接口并重写clone方法，而且需要将引用类型的属性全部拷贝一遍。
     * 不过实际当中我们使用原型模式时，也可以写一个基类实现Cloneable接口重写clone方法，然后让需要具有拷贝功能的子类继承自该类，这是一种节省代码量的常用方式
     *
     * @return
     */
    protected Prototype deepClone() {
        try {
            Prototype clone = (Prototype) super.clone();
            clone.setField(this.field.clone());
            return clone;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 方式3
     * 序列化方式
     * @return
     */
    protected Prototype serializeClone() {
        try {
            //将object 写入（以字节数组的方式） 内存中的一个缓冲区
            //序列化
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream =new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);

            //反序列化
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Prototype clone = (Prototype) objectInputStream.readObject();
            return clone;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //spring提供的工具类
//       SerializationUtils.deserialize( SerializationUtils.serialize(this));
        return null;
    }

    /**
     * 方式4 反射方式
     * 调用spring的方法 提供的是浅copy
     * 据说commons-lang 提供的是深copy
     * @return
     */
    protected Prototype springRefClone() {
        Prototype clone = new Prototype();
        BeanUtils.copyProperties(this,clone);
        return clone;
    }





    public Field getField() {
        return field;
    }

    public Prototype setField(Field field) {
        this.field = field;
        return this;
    }

    public int getA() {
        return a;
    }

    public Prototype setA(int a) {
        this.a = a;
        return this;
    }

    public String getB() {
        return b;
    }

    public Prototype setB(String b) {
        this.b = b;
        return this;
    }
}
