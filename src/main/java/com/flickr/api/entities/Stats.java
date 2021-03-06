/*
 * Copyright (C) 2014 Fabien Barbero
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights 
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.flickr.api.entities;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Fabien Barbero
 */
public class Stats implements Serializable {

    private final int views;
    private final int comments;
    private final int favorites;

    Stats(JSONObject json) throws JSONException {
        views = json.getInt("views");
        comments = json.getInt("comments");
        favorites = json.getInt("favorites");
    }

    /**
     * Get the total views count by other users
     *
     * @return the views count
     */
    public int getViewsCount() {
        return views;
    }

    /**
     * Get the photo count added as favorites by other users
     *
     * @return The favorites count
     */
    public int getFavoritesCount() {
        return favorites;
    }

    /**
     * Get the comments count added by other users
     *
     * @return The comments count
     */
    public int getCommentsCount() {
        return comments;
    }

}
