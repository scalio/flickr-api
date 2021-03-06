/*
 * Copyright (C) 2011 by Fabien Barbero
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

import com.flickr.api.FlickrErrorCode;
import com.flickr.api.FlickrException;
import com.flickr.api.ServerResponse;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Fabien Barbero
 */
public abstract class JSONResponse implements ServerResponse {

    @Override
    public final void read(String data, String method) throws FlickrException {
        try {
            JSONObject json = new JSONObject(data);
            
            ResponseStatus status = ResponseStatus.valueOf(json.getString("stat"));
            
            if(status == ResponseStatus.fail) {
                FlickrErrorCode code = FlickrErrorCode.fromCode(json.optInt("code"));
                String message = json.optString("message");
                throw new FlickrException("Error calling method '" + method + "' (" + message + ")", code);
            }
            
            readObject(json);
            
        } catch (JSONException ex) {
            throw new FlickrException("Error parsing JSON response", ex);
        }
    }

    protected abstract void readObject(JSONObject json) throws JSONException;

}
