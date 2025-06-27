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

    public fun esMayor(otra: Fraccion): Boolean {
        val resultadoThis = this.numerador.toDouble() / this.denominador.toDouble()
        val resultadoOtra = otra.numerador.toDouble() / otra.denominador.toDouble()
        return resultadoThis > resultadoOtra
    }

    public fun desdeDecimal(decimal: Double): Fraccion{
        
    }

    public fun aDecimal(): Double{
        val resultadoThis = this.numerador.toDouble() / this.denominador.toDouble()
        return resultadoThis
    }

    public fun esMenor(otra: Fraccion): Boolean {
        val resultadoThis = this.numerador.toDouble() / this.denominador.toDouble()
        val resultadoOtra = otra.numerador.toDouble() / otra.denominador.toDouble()
        return resultadoThis < resultadoOtra
    }

    override fun toString():String {
        return "${numerador}/${denominador}"
    }

    operator fun plus(otra: Fraccion): Fraccion {
        if (otra.denominador === 0){
            throw IllegalStateException("El denominador no puede ser cero")
        }
        var num = this.numerador * otra.denominador + this.denominador * otra.numerador
        var deno = this.denominador * otra.denominador
        if (num < 0 && deno < 0){
            num = -num
            deno = -deno
        }
        return Fraccion(
            num,
            deno
            )
    }

    operator fun minus(otra: Fraccion): Fraccion{
        if (otra.denominador === 0){
            throw IllegalStateException("El denominador no puede ser cero")
        }
        var num = this.numerador * otra.denominador - this.denominador * otra.numerador
        var deno = this.denominador * otra.denominador
        if (num < 0 && deno < 0){
            num = -num
            deno = -deno
        }
        return Fraccion(
            num,
            deno
            )
    }

    operator fun times(otra: Fraccion): Fraccion{
        if (otra.denominador === 0){
            throw IllegalStateException("El denominador no puede ser cero")
        }
        return simplificar(Fraccion(
            this.numerador * otra.numerador,
            this.denominador * otra.denominador
        ))
    }

    operator fun div(otra: Fraccion): Fraccion{
        if (otra.numerador === 0){
            throw IllegalStateException("El numerador del divisor no puede ser cero")
        }
        return simplificar(Fraccion(
            this.numerador * otra.denominador,
            this.denominador * otra.numerador
        ))
    }

    operator fun compareTo(otra: Fraccion): Int{
        val resultadoThis = this.numerador.toDouble() / this.denominador.toDouble()
        val resultadoOtra = otra.numerador.toDouble() / otra.denominador.toDouble()
        return when{
            resultadoThis > resultadoOtra -> 1
            resultadoThis < resultadoOtra -> -1
            else -> 0
        }
    }

    override fun equals(other: Any?): Boolean{
        var otra = other
        if (other is Fraccion){
            var simpThis = simplificar(this)
            var simpOther = simplificar(other)
            if (simpOther.numerador === simpThis.numerador && simpOther.denominador === simpThis.denominador){
                return true
            } else {
                return false
            }
        } else {
            throw Exception("La comparación de Fraccion con otra tipo esta prohibida")
        }
    }
}