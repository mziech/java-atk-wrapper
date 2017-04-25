/*
 * Java ATK Wrapper for GNOME
 * Copyright (C) 2009 Sun Microsystems Inc.
 * Copyright (C) 2015 Magdalen Berns <m.berns@thismagpie.com>
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

import javax.accessibility.Accessible;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleTable;


public interface AtkTable {
    AccessibleContext ref_at(int row, int column);

    int get_column_at_index(int index);

    int get_row_at_index(int index);

    int get_n_columns();

    int get_n_rows();

    int get_column_extent_at(int row, int column);

    int get_row_extent_at(int row, int column);

    AccessibleContext get_caption();

    void setCaption(Accessible a);

    String get_column_description(int column);

    void setColumnDescription(int column, String description);

    String get_row_description(int row);

    void setRowDescription(int row, String description);

    AccessibleContext get_column_header(int column);

    void setColumnHeader (int column, AccessibleTable table);

    AccessibleContext get_row_header(int row);

    void setRowHeader(int row, AccessibleTable table);

    AccessibleContext get_summary();

    void setSummary(Accessible a);

    int[] get_selected_columns();

    int[] get_selected_rows();

    boolean is_column_selected(int column);

    boolean is_row_selected(int row);

    boolean is_selected(int row, int column);

    boolean addColumnSelection(int column);

    boolean addRowSelection(int row);

    boolean remove_column_selection(int column);

    boolean remove_row_selection(int row);
}
