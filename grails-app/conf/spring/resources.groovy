import grails.angular.example.marshallers.PropietarioJsonMarshaller
import grails.converters.JSON
import org.codehaus.groovy.grails.web.converters.configuration.ObjectMarshallerRegisterer

// Place your Spring DSL code here
beans = {

    //registro de nuestros beans JsonMarshaller

    customPropietarioJsonMarshaller(ObjectMarshallerRegisterer){
        marshaller = new PropietarioJsonMarshaller()
        converterClass = JSON
        priority = 1
    }

}
