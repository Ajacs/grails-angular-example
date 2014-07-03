import grails.angular.example.Mascota
import grails.angular.example.Propietario

class BootStrap {

    def init = { servletContext ->

        Propietario propietario1 = new Propietario(nombre: 'Nombre1', apellidoPaterno: 'Apellido paterno 1', apellidoMaterno: 'Apellido materno 1', edad: 25, fechaNacimiento: new Date()).save()
        Propietario propietario2 = new Propietario(nombre: 'Nombre2', apellidoPaterno: 'Apellido paterno 2', apellidoMaterno: 'Apellido materno 2', edad: 25, fechaNacimiento: new Date()).save()
        Propietario propietario3 = new Propietario(nombre: 'Nombre3', apellidoPaterno: 'Apellido paterno 3', apellidoMaterno: 'Apellido materno 3', edad: 25, fechaNacimiento: new Date()).save()
        Propietario propietario4 = new Propietario(nombre: 'Nombre4', apellidoPaterno: 'Apellido paterno 4', apellidoMaterno: 'Apellido materno 4', edad: 25, fechaNacimiento: new Date()).save()

        Mascota mascota1 = new Mascota(nombre: 'firulais', edad: 2, usuario: propietario1).save()
        Mascota mascota2 = new Mascota(nombre: 'firulais', edad: 2, usuario: propietario2).save()
        Mascota mascota3 = new Mascota(nombre: 'firulais', edad: 2, usuario: propietario3).save()
        Mascota mascota4 = new Mascota(nombre: 'firulais', edad: 2, usuario: propietario4).save()
    }
    def destroy = {
    }
}
