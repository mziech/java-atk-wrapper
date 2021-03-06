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

#ifndef _JAW_UTIL_H_
#define _JAW_UTIL_H_

#include <jni.h>
#include <atk/atk.h>

G_BEGIN_DECLS

#define INTERFACE_ACTION                  0x00000001
#define INTERFACE_COMPONENT               0x00000002
#define INTERFACE_DOCUMENT                0x00000004
#define INTERFACE_EDITABLE_TEXT           0x00000008
#define INTERFACE_HYPERLINK               0x00000010
#define INTERFACE_HYPERTEXT               0x00000020
#define INTERFACE_IMAGE                   0x00000040
#define INTERFACE_SELECTION               0x00000080
#define INTERFACE_STREAMABLE_CONTENT      0x00000100
#define INTERFACE_TABLE                   0x00000200
#define INTERFACE_TABLE_CELL              0x00000400
#define INTERFACE_TEXT                    0x00000800
#define INTERFACE_VALUE                   0x00001000

#define JAW_TYPE_UTIL               (jaw_util_get_type())
#define JAW_UTIL(obj)               (G_TYPE_CHECK_INSTANCE_CAST ((obj), JAW_TYPE_UTIL, JawUtil))
#define JAW_UTIL_CLASS(klass)       (G_TYPE_CHECK_CLASS_CAST ((klass), JAW_TYPE_UTIL, JawUtilClass))
#define JAW_IS_UTIL(obj)            (G_TYPE_CHECK_INSTANCE_TYPE ((obj), JAW_TYPE_UTIL))
#define JAW_IS_UTIL_CLASS(klass)    (G_TYPE_CHECK_CLASS_TYPE ((klass), JAW_TYPE_UTIL))
#define JAW_UTIL_GET_CLASS(obj)     (G_TYPE_INSTANCE_GET_CLASS ((obj), JAW_TYPE_UTIL, JawUtilClass))

typedef struct _JawUtil       JawUtil;
typedef struct _JawUtilClass  JawUtilClass;

struct _JawUtil
{
  AtkUtil parent;
};

GType jaw_util_get_type(void);

struct _JawUtilClass
{
  AtkUtilClass parent_class;
};

guint jaw_util_get_tflag_from_jobj(JNIEnv *jniEnv, jobject jObj);
gboolean jaw_util_is_same_jobject(gconstpointer a, gconstpointer b);
JNIEnv* jaw_util_get_jni_env(void);
AtkRole jaw_util_get_atk_role_from_jobj(jobject jobj);
AtkStateType jaw_util_get_atk_state_type_from_java_state(JNIEnv *jniEnv, jobject jobj);
void jaw_util_get_rect_info(JNIEnv *jniEnv,
                            jobject jrect,
                            gint *x,
                            gint *y,
                            gint *width,
                            gint *height);
gboolean jaw_util_dispatch_key_event (AtkKeyEventStruct *event);

G_END_DECLS

#endif

