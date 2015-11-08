package com.dev.webservice;

public class BackEndProxy implements com.dev.webservice.BackEnd {
  private String _endpoint = null;
  private com.dev.webservice.BackEnd backEnd = null;
  
  public BackEndProxy() {
    _initBackEndProxy();
  }
  
  public BackEndProxy(String endpoint) {
    _endpoint = endpoint;
    _initBackEndProxy();
  }
  
  private void _initBackEndProxy() {
    try {
      backEnd = (new com.dev.webservice.BackEndServiceLocator()).getBackEnd();
      if (backEnd != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)backEnd)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)backEnd)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (backEnd != null)
      ((javax.xml.rpc.Stub)backEnd)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.dev.webservice.BackEnd getBackEnd() {
    if (backEnd == null)
      _initBackEndProxy();
    return backEnd;
  }
  
  public java.lang.String save(java.lang.String jsonObject) throws java.rmi.RemoteException{
    if (backEnd == null)
      _initBackEndProxy();
    return backEnd.save(jsonObject);
  }
  
  
}