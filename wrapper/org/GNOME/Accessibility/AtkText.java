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

import java.awt.*;


public interface AtkText {
    /* Return string from start, up to, but not including end */
    String get_text(int start, int end);

    char get_character_at_offset(int offset);

    AtkTextImpl.StringSequence get_text_at_offset(int offset,
                                                  int boundary_type);

    int get_caret_offset();

    Rectangle get_character_extents(int offset, int coord_type);

    int get_character_count();

    int get_offset_at_point(int x, int y,
                            int coord_type);

    Rectangle get_range_extents(int start, int end,
                                int coord_type);

    int get_n_selections();

    AtkTextImpl.StringSequence get_selection();

    boolean add_selection(int start, int end);

    boolean remove_selection(int selection_num);

    boolean set_selection(int selection_num,
                          int start, int end);

    boolean set_caret_offset(int offset);
}
