package grails.angular.example

class Propietario {

    String nombre
    String apellidoMaterno
    String apellidoPaterno
    Integer edad
    Date fechaNacimiento


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
