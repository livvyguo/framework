package com.lvy.framework;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by livvy on 14-5-24.
 */
public class Test {
    public static void main(String[] args) {
        ScriptEngineManager mgr = new ScriptEngineManager();
        for(ScriptEngineFactory f:mgr.getEngineFactories()){
            System.out.println("Test.main() " + f.getEngineName());
        }
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        try {
            engine.put("name", "tigo");
            engine.put("a", 1);
            engine.put("b", 3);
            engine.eval("print('Hello ' + name + '!'); print(a+b);");
        } catch (ScriptException ex) {
            ex.printStackTrace();
        }

    }
}
