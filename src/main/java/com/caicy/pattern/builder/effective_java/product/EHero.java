package com.caicy.pattern.builder.effective_java.product;

public class EHero
{

    private  String name;

    private  PartA partA;
    //模拟B依赖A
    private  PartB partB;

    private  PartC partC;

    public EHero() {
    }

    private EHero(Builder builder) {
        this.name = builder.name;
        this.partA = builder.partA;
        this.partB = builder.partB;
        this.partC = builder.partC;
    }
    // 内置 建造者角色
    public static class Builder{
        //必选参数
        private  String name;

        //可选参数
        private  PartA partA;
        //模拟B依赖A
        private  PartB partB;

        private  PartC partC;

        public Builder(String name){
            //必填参数放到构造方法中
            this.name = name;
        }



        public Builder partA(PartA partA) {
            this.partA = partA;
            return this;
        }

        public Builder partB(PartB partB) {
            this.partB = partB;
            return this;
        }

        public Builder partC(PartC partC) {
            this.partC = partC;
            return this;
        }

        public EHero build() {
            return new EHero(this);
        }
    }


    public String getName() {
        return name;
    }

    public EHero setName(String name) {
        this.name = name;
        return this;
    }

    public PartA getPartA() {
        return partA;
    }

    public EHero setPartA(PartA partA) {
        this.partA = partA;
        return this;
    }

    public PartB getPartB() {
        return partB;
    }

    public EHero setPartB(PartB partB) {
        this.partB = partB;
        return this;
    }

    public PartC getPartC() {
        return partC;
    }

    public EHero setPartC(PartC partC) {
        this.partC = partC;
        return this;
    }
}