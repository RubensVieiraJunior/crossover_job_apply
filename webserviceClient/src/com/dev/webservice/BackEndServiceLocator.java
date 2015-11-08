/**
 * BackEndServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dev.webservice;

public class BackEndServiceLocator extends org.apache.axis.client.Service implements com.dev.webservice.BackEndService {

    public BackEndServiceLocator() {
    }


    public BackEndServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BackEndServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BackEnd
    private java.lang.String BackEnd_address = "http://localhost:8080/webservice/services/BackEnd";

    public java.lang.String getBackEndAddress() {
        return BackEnd_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BackEndWSDDServiceName = "BackEnd";

    public java.lang.String getBackEndWSDDServiceName() {
        return BackEndWSDDServiceName;
    }

    public void setBackEndWSDDServiceName(java.lang.String name) {
        BackEndWSDDServiceName = name;
    }

    public com.dev.webservice.BackEnd getBackEnd() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BackEnd_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBackEnd(endpoint);
    }

    public com.dev.webservice.BackEnd getBackEnd(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.dev.webservice.BackEndSoapBindingStub _stub = new com.dev.webservice.BackEndSoapBindingStub(portAddress, this);
            _stub.setPortName(getBackEndWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBackEndEndpointAddress(java.lang.String address) {
        BackEnd_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.dev.webservice.BackEnd.class.isAssignableFrom(serviceEndpointInterface)) {
                com.dev.webservice.BackEndSoapBindingStub _stub = new com.dev.webservice.BackEndSoapBindingStub(new java.net.URL(BackEnd_address), this);
                _stub.setPortName(getBackEndWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BackEnd".equals(inputPortName)) {
            return getBackEnd();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservice.dev.com", "BackEndService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservice.dev.com", "BackEnd"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BackEnd".equals(portName)) {
            setBackEndEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
