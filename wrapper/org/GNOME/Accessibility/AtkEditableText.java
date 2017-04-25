/*
 * Java ATK Wrapper for GNOME
 * Copyright (C) 2009 Sun Microsystems Inc.
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

import javax.swing.text.AttributeSet;


public interface AtkEditableText extends AtkText {
    void set_text_contents(String s);

    void insert_text(String s, int position);

    void copy_text(int start, int end);

    void cut_text(int start, int end);

    void delete_text(int start, int end);

    void paste_text(int position);

    boolean setRunAttributes(AttributeSet as, int start, int end);
}
