package com.lvy.framework.test;

import com.google.common.base.Objects;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * Created by livvy on 14-7-11.
 */
public class Test {
    public static class Main {
        public static void main(String[] args) {
//
            Cache<Object,Object> build = CacheBuilder.newBuilder().maximumSize(100000).build();

        }
    }

    public static class Code{
        private String name;
        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return Objects.toStringHelper(this).toString();
        }
    }
}
