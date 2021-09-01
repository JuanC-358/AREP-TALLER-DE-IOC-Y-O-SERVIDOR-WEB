/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.reflection;

import static java.lang.System.out;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

/**
 *
 * @author ADMIN
 */
public class ReflectionExamples {
    //printMembers(c.getFields(), “Fields”);



private static void printMembers(Member[] mbrs, String s) {

        out.format("%s:%n", s);

        for (Member mbr : mbrs) {

            if (mbr instanceof Field) {
                out.format("  %s%n", ((Field) mbr).toGenericString());
            } else if (mbr instanceof Constructor) {
                out.format("  %s%n", ((Constructor) mbr).toGenericString());
            } else if (mbr instanceof Method) {
                out.format("  %s%n", ((Method) mbr).toGenericString());
            }

        }

        if (mbrs.length == 0) {
            out.format("  -- No %s --%n", s);
        }

        out.format("%n");
    }

}
