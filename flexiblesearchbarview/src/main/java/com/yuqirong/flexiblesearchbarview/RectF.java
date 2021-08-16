/*
 * Copyright (C) 2020-21 Application Library Enigineering Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.yuqirong.flexiblesearchbarview;

import ohos.agp.utils.RectFloat;

/**
 * RectF class.
 */
public class RectF extends RectFloat {
    /**
     * Default constructor for RectF.
     */
    public RectF() {
        super();
    }

    /**
     * * Parameterised constructor for RectF.
     *
     * @param left left
     * @param top top
     * @param right right
     * @param bottom bottom
     */
    public RectF(final float left, final float top, final float right, final float bottom) {
        super(left, top, right, bottom);
    }

    /**
     * * set RectF coordinates.
     *
     * @param src src
     */
    public void set(final RectF src) {
        if (src == null) {
            return;
        }
        left = src.left;
        top = src.top;
        right = src.right;
        bottom = src.bottom;
    }
}
