package grails.angular.example



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PropietarioController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def offset = params?:0
        respond Propietario.list(params), model:[totalCount: Propietario.count(), currentMax:params.max,currentOffset:offset]
    }

    def show(Propietario propietarioInstance) {
        respond propietarioInstance
    }

    def create() {
        respond new Propietario(params)
    }

    @Transactional
    def save(Propietario propietarioInstance) {
        if (propietarioInstance == null) {
            notFound()
            return
        }

        if (propietarioInstance.hasErrors()) {
            respond propietarioInstance.errors, view:'create'
            return
        }

        propietarioInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'propietario.label', default: 'Propietario'), propietarioInstance.id])
                redirect propietarioInstance
            }
            '*' { respond propietarioInstance, [status: CREATED] }
        }
    }

    def edit(Propietario propietarioInstance) {
        respond propietarioInstance
    }

    @Transactional
    def update(Propietario propietarioInstance) {
        if (propietarioInstance == null) {
            notFound()
            return
        }

        if (propietarioInstance.hasErrors()) {
            respond propietarioInstance.errors, view:'edit'
            return
        }

        propietarioInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Propietario.label', default: 'Propietario'), propietarioInstance.id])
                redirect propietarioInstance
            }
            '*'{ respond propietarioInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Propietario propietarioInstance) {

        if (propietarioInstance == null) {
            notFound()
            return
        }

        propietarioInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Propietario.label', default: 'Propietario'), propietarioInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'propietario.label', default: 'Propietario'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
