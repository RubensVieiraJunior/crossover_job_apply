/**
 * BackEndService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dev.webservice;

public interface BackEndService extends javax.xml.rpc.Service {
    public java.lang.String getBackEndAddress();

    public com.dev.webservice.BackEnd getBackEnd() throws javax.xml.rpc.ServiceException;

    public com.dev.webservice.BackEnd getBackEnd(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
