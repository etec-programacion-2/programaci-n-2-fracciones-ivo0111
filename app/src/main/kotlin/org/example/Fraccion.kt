package org.example

class Fraccion (
    private var _numerador : Int,
    private var _denominador : Int
) {

    init {
        if (_denominador === 0){
            throw IllegalArgumentException("El denominador no puede ser cero")
        }
    }

    var numerador: Int
      get() = _numerador
      set(value) { _numerador = value }
   
    var denominador: Int
        get() = _denominador
        set(value) { 
        if (value == 0) throw IllegalArgumentException("El denominador no puede ser cero")
        _denominador = value 
        }

    open fun mostrar(){
        println(this.toString())
    }

    private fun simplificar(f:Fraccion):Fraccion{
        var a = f.numerador
        var b = f.denominador
        var aux = 0
        var mcd = 0
        while (a != 0 && b != 0){
            aux = b
            b = a%b
            a = aux
        }
        if (a===0){
            mcd = b
        } else {
            mcd = a
        }
        return Fraccion(f.numerador/mcd, f.denominador/mcd)
    }

    override fun toString():String {
        return "${numerador}/${denominador}"
    }

    operator fun plus(otra: Fraccion): Fraccion {
        return simplificar(Fraccion(
            this.numerador * otra.denominador + this.denominador * otra.numerador,
            this.denominador * otra.denominador
            ))
    }

    operator fun minus(otra: Fraccion): Fraccion{
        return simplificar(Fraccion(
            this.numerador * otra.denominador - this.denominador * otra.numerador,
            this.denominador * otra.denominador
            ))
    }
}