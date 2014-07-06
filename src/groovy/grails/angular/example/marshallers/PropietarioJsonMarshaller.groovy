package grails.angular.example.marshallers

import grails.angular.example.Mascota
import grails.angular.example.Propietario
import org.codehaus.groovy.grails.web.converters.marshaller.ClosureObjectMarshaller

/**
 * Created by adderly on 5/07/14.
 */
class PropietarioJsonMarshaller extends ClosureObjectMarshaller<Propietario> {



    static final marshall = { Propietario propietario ->


        def json = [:]
        json.id = propietario.id
        json.nombre = propietario.nombre
        json.fecha = new Date().format("yy/MM/dd")
        if(propietario?.mascotas){
            println "Tiene mascotas este propietario"
            json.mascotas = []
            propietario.mascotas.each {Mascota mascota ->
            def jsonMascotas = [:]
            jsonMascotas.id = mascota.id
            jsonMascotas.nombre = mascota.nombre
            jsonMascotas.edad = mascota.edad
            json.mascotas << jsonMascotas
            }
        }
        println "JSON: " + json
        return json

    }


    public PropietarioJsonMarshaller() {

        super(Propietario, marshall)
        println "PropietarioJsonMarshaller called ..."
    }
}
