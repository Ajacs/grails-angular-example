package grails.angular.example
import grails.rest.Resource


@Resource(uri = '/mascotas', formats=['json', 'xml'])
class Mascota {

    String nombre
    String edad

    static belongsTo = [usuario: Propietario]

    static mapping = {
        version(false)
    }

    static constraints = {
        nombre nullable: false
        edad nullable: false
    }
}
