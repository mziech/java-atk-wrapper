/*
 * Java ATK Wrapper for GNOME
 * Copyright (C) 2009 Sun Microsystems Inc.
 * Copyright (C) 2017 Marco Ziech
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.GNOME.Accessibility;


import javax.accessibility.AccessibleContext;
import javax.swing.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import static org.GNOME.Accessibility.AtkDebug.debug;

public class AtkFactory {

    private static final Class<?>[] IMPLEMENTATIONS = new Class<?>[] {
            AtkActionImpl.class,
            AtkComponentImpl.class,
            AtkTableImpl.class,
            AtkTableCellImpl.class,
            AtkEditableTextImpl.class,
            AtkHypertextImpl.class,
            AtkTextImpl.class,
            AtkValueImpl.class,
            AtkSelectionImpl.class,
            AtkHyperlinkImpl.class,
            AtkImageImpl.class,
    };

    public static Object create(Class<?> clazz, AccessibleContext ac) {
        for (Class<?> impl : IMPLEMENTATIONS) {
            if (clazz.isAssignableFrom(impl)) {
                try {
                    return synchronize(impl.getConstructor(AccessibleContext.class).newInstance(ac));
                } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        throw new IllegalArgumentException("Cannot create object of class " + clazz);
    }

    @SuppressWarnings("unchecked")
    static <T> T synchronize(final T orig) {
        try {
            Class<?>[] ifaces = orig.getClass().getInterfaces();
            debug("Wrapped %s (implementing %s)", orig, Arrays.toString(ifaces));
            return (T) Proxy.newProxyInstance(orig.getClass().getClassLoader(), ifaces, new InvocationHandler() {
                @Override
                public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
                    debug("debug: %s.%s(%s)", orig.getClass().getSimpleName(), method.getName(), args);
                    FutureTask<Object> futureTask = new FutureTask(new Callable() {
                        @Override
                        public Object call() throws Exception {
                            return method.invoke(orig, args);
                        }
                    });
                    SwingUtilities.invokeLater(futureTask);

                    Object ret = futureTask.get();
                    debug("debug: %s.%s() = %s", orig.getClass().getSimpleName(), method.getName(), ret);
                    return ret;
                }
            });
        } catch (RuntimeException e) {
            e.printStackTrace();
            return orig;
        }
    }

}
