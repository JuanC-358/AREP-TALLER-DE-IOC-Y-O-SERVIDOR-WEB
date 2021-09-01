/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 *
 * @author ADMIN
 */
public class InvokeMain {


    public static void main(String... args) throws IllegalArgumentException, InvocationTargetException {

        try {

            Class<?> c = Class.forName(args[0]);

            Class[] argTypes = new Class[]{String[].class};

            Method main = c.getDeclaredMethod("main", argTypes);

            String[] mainArgs = Arrays.copyOfRange(args, 1, args.length);

            System.out.format("invoking %s.main()%n", c.getName());

            main.invoke(null, (Object) mainArgs);

            // production code should handle these exceptions more gracefully
        } catch (ClassNotFoundException x) {

            x.printStackTrace();

        } catch (NoSuchMethodException x) {

            x.printStackTrace();

        } catch (IllegalAccessException x) {

            x.printStackTrace();

        } catch (InvocationTargetException x) {

            x.printStackTrace();

        }
    }

}