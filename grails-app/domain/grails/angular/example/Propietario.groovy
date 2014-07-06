package grails.angular.example
import grails.rest.Resource

@Resource(uri = '/propietarios', formats=['json', 'xml'], readOnly = true)
class Propietario {

    String nombre
    String apellidoMaterno
    String apellidoPaterno
    Integer edad
    Date fechaNacimiento

    static hasMany = [mascotas: Mascota]


    static mapping = {
        version(false)
    }

    static constraints = {
        nombre nullable: false
        apellidoMaterno nullable: false
        apellidoPaterno nullable: false
        edad nullable: false
        fechaNacimiento nullable: false
    }
}
