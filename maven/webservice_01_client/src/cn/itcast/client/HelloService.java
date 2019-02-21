
package cn.itcast.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HelloService", targetNamespace = "http://webservice.itheima.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HelloService {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sayHello", targetNamespace = "http://webservice.itheima.com/", className = "cn.itcast.client.SayHello")
    @ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "http://webservice.itheima.com/", className = "cn.itcast.client.SayHelloResponse")
    @Action(input = "http://webservice.itheima.com/HelloService/sayHelloRequest", output = "http://webservice.itheima.com/HelloService/sayHelloResponse")
    public String sayHello(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
