package com.meiya.mode;

import lombok.Data;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 建造者模式的javabean
 * 外部类提供成员变量、私有构造、@Data(Getter、Setter、equals、hashcode、toString)
 * 静态内部类提供成员变量、构造器、字段设置方法、build方法
 */
@Data
public class JavaBeanBuilder {
    private Integer must1;
    private String must2;
    private Integer optional1;
    private String optional2;
    private List<Long> optional3;
    private Map<Integer, Set<String>> optional4;

    //私有构造器
    private JavaBeanBuilder(Builder builder){
        this.must1 = builder.must1;
        this.must2 = builder.must2;
        this.optional1 = builder.optional1;
        this.optional2 = builder.optional2;
        this.optional3 = builder.optional3;
        this.optional4 = builder.optional4;
    }


    public static class Builder{
        private Integer must1;
        private String must2;
        private Integer optional1;
        private String optional2;
        private List<Long> optional3;
        private Map<Integer, Set<String>> optional4;

        //如果没有must的字段，则改成无参构造
        public Builder(Integer must1,String must2){
            this.must1 = must1;
            this.must2 = must2;
        }
        public Builder optional1(Integer optional1){
            this.optional1 = optional1;
            return this;
        }

        public Builder optional2(String optional2){
            this.optional2 = optional2;
            return this;
        }

        public Builder optional3(List<Long> optional3){
            this.optional3 = optional3;
            return this;
        }

        public Builder optional4(Map<Integer, Set<String>> optional4){
            this.optional4 = optional4;
            return this;
        }

        public JavaBeanBuilder build(){
            return new JavaBeanBuilder(this);
        }
    }
}
