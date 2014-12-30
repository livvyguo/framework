package com.lvy.framework;

import javax.json.*;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by livvy on 14-5-26.
 */
public class Test1 {
    public static void main(String[] args) {

        JsonObjectBuilder builder = Json.createObjectBuilder();
        builder.add("zhzh",1111);
        JsonObject jsonObject = builder.build();
        String s = jsonObject.toString();
        System.out.println(s);
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        arrayBuilder.add("sss");
        JsonArray build = arrayBuilder.build();
        System.out.println(build.toString());
    }

    public static boolean isLegalCaseNo(final String caseNo) {
        if (Objects.isNull(caseNo))
            return false;
        Pattern pattern = Pattern.compile("^((19)|(20))[0-9]{2}年((高)|(一中)|(西)|(石)|(海)|(门)|(房)|(昌)|(大)|(延)|(二中)|(东)|(朝)|(丰)|(顺)|(通)|(平)|(怀)|(密)|(铁中)|(京铁)|(津铁)|(石铁)|(三中))((民)|(刑)|(行)|(执)|(赔))[^x00-xff]{0,5}字第\\d{5}号$");
        Matcher matcher = pattern.matcher(caseNo);
        return matcher.matches();
    }
}
