/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc., and individual contributors as indicated
 * by the @authors tag.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.net.protocol;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.net.URLConnection;
import java.net.URL;
import java.net.MalformedURLException;

import java.security.Permission;

/**
 * An delegating URLConnection support class.
 *
 * @todo resolve 1.4 specific issues.
 *
 * @version <tt>$Revision$</tt>
 * @author  <a href="mailto:jason@planet57.com">Jason Dillon</a>
 */
@SuppressWarnings("unchecked")
public class DelegatingURLConnection
   extends URLConnection
{
   protected URL delegateUrl;
   protected URLConnection delegateConnection;

   public DelegatingURLConnection(final URL url)
      throws MalformedURLException, IOException
   {
      super(url);
      
      delegateUrl = makeDelegateUrl(url);
      delegateConnection = makeDelegateUrlConnection(delegateUrl);
   }

   protected URL makeDelegateUrl(final URL url)
      throws MalformedURLException, IOException
   {
      return url;
   }

   protected URLConnection makeDelegateUrlConnection(final URL url)
      throws IOException
   {
      return url.openConnection();
   }

   public void connect() throws IOException
   {
      delegateConnection.connect();
   }
   
   public URL getURL() {
      return delegateConnection.getURL();
   }

   public int getContentLength() {
      return delegateConnection.getContentLength();
   }

   public String getContentType() {
      return delegateConnection.getContentType();
   }

   public String getContentEncoding() {
      return delegateConnection.getContentEncoding();
   }

   public long getExpiration() {
      return delegateConnection.getExpiration();
   }

   public long getDate() {
      return delegateConnection.getDate();
   }

   public long getLastModified() {
      return delegateConnection.getLastModified();
   }

   public String getHeaderField(String name) {
      return delegateConnection.getHeaderField(name);
   }

   /* This is specific to 1.4
   public Map getHeaderFields() {
      return delegateConnection.getHeaderFields();
   }
   */
   
   public int getHeaderFieldInt(String name, int _default) {
      return delegateConnection.getHeaderFieldInt(name, _default);
   }

   public long getHeaderFieldDate(String name, long _default) {
      return delegateConnection.getHeaderFieldDate(name, _default);
   }

   public String getHeaderFieldKey(int n) {
      return delegateConnection.getHeaderFieldKey(n);
   }

   public String getHeaderField(int n) {
      return delegateConnection.getHeaderField(n);
   }

   public Object getContent() throws IOException {
      return delegateConnection.getContent();
   }

   public Object getContent(Class[] classes) throws IOException {
      return delegateConnection.getContent(classes);
   }

   public Permission getPermission() throws IOException {
      return delegateConnection.getPermission();
   }

   public InputStream getInputStream() throws IOException {
      return delegateConnection.getInputStream();
   }

   public OutputStream getOutputStream() throws IOException {
      return delegateConnection.getOutputStream();
   }

   public String toString() {
      return super.toString() + "{ " + delegateConnection + " }";
   }

   public void setDoInput(boolean doinput) {
      delegateConnection.setDoInput(doinput);
   }
   
   public boolean getDoInput() {
      return delegateConnection.getDoInput();
   }

   public void setDoOutput(boolean dooutput) {
      delegateConnection.setDoOutput(dooutput);
    }

   public boolean getDoOutput() {
      return delegateConnection.getDoOutput();
   }

   public void setAllowUserInteraction(boolean allowuserinteraction) {
      delegateConnection.setAllowUserInteraction(allowuserinteraction);
   }

   public boolean getAllowUserInteraction() {
      return delegateConnection.getAllowUserInteraction();
   }

   public void setUseCaches(boolean usecaches) {
      delegateConnection.setUseCaches(usecaches);
   }

   public boolean getUseCaches() {
      return delegateConnection.getUseCaches();
   }

   public void setIfModifiedSince(long ifmodifiedsince) {
      delegateConnection.setIfModifiedSince(ifmodifiedsince);
   }

   public long getIfModifiedSince() {
      return delegateConnection.getIfModifiedSince();
   }

   public boolean getDefaultUseCaches() {
      return delegateConnection.getDefaultUseCaches();
   }

   public void setDefaultUseCaches(boolean defaultusecaches) {
      delegateConnection.setDefaultUseCaches(defaultusecaches);
   }

   public void setRequestProperty(String key, String value) {
      delegateConnection.setRequestProperty(key, value);
   }

   /* This is specific to 1.4
   public void addRequestProperty(String key, String value) {
      delegateConnection.addRequestProperty(key, value);
   }
   */
   
   public String getRequestProperty(String key) {
      return delegateConnection.getRequestProperty(key);
   }

   /* This is specific to 1.4
   public Map getRequestProperties() {
      return delegateConnection.getRequestProperties();
   }
   */
}
