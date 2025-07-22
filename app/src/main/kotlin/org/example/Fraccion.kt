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
        println(this.toString()) //print de la fraccion como un string
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
        return Fraccion(f.numerador/mcd, f.denominador/mcd) // devuelve la fraccion simplificada
    }

    public fun esMayor(otra: Fraccion): Boolean {
        val resultadoThis = this.numerador.toDouble() / this.denominador.toDouble()
        val resultadoOtra = otra.numerador.toDouble() / otra.denominador.toDouble()
        return resultadoThis > resultadoOtra // true si this es menor
    }

    public fun aDecimal(): Double{
        val resultadoThis = this.numerador.toDouble() / this.denominador.toDouble()
        return resultadoThis // devuelve la fraccion como un decimal
    }

    public fun esMenor(otra: Fraccion): Boolean {
        val resultadoThis = this.numerador.toDouble() / this.denominador.toDouble()
        val resultadoOtra = otra.numerador.toDouble() / otra.denominador.toDouble()
        return resultadoThis < resultadoOtra // true si this es menor
    }

    override fun toString():String {
        return "${numerador}/${denominador}" // devuelve una string que representa a la fracción
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
            ) // devuelve una fraccion resutado de la suma
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
            ) // devuelve una fraccion resutado de la resta
    }

    operator fun times(otra: Fraccion): Fraccion{
        if (otra.denominador === 0){
            throw IllegalStateException("El denominador no puede ser cero")
        }
        return simplificar(Fraccion(
            this.numerador * otra.numerador,
            this.denominador * otra.denominador
        )) // devuelve una fraccion resutado de la multiplicación
    }

    operator fun div(otra: Fraccion): Fraccion{
        if (otra.numerador === 0){
            throw IllegalStateException("El numerador del divisor no puede ser cero")
        }
        return simplificar(Fraccion(
            this.numerador * otra.denominador,
            this.denominador * otra.numerador
        )) // devuelve una fraccion resutado de la division
    }

    operator fun compareTo(otra: Fraccion): Int{
        val resultadoThis = this.aDecimal()
        val resultadoOtra = otra.aDecimal()
        return when{
            resultadoThis > resultadoOtra -> 1 // si es mayor
            resultadoThis < resultadoOtra -> -1 // si es menor
            else -> 0 // si es igual
        }
    }

    override fun equals(other: Any?): Boolean{
        var otra = other
        if (other is Fraccion){
            var simpThis = simplificar(this)
            var simpOther = simplificar(other)
            if (simpOther.numerador === simpThis.numerador && simpOther.denominador === simpThis.denominador){
                return true //si es igual
            } else {
                return false //si no es igual
            }
        } else {
            throw Exception("La comparación de Fraccion con otra tipo esta prohibida")
        }
    }

    companion object{
        fun desdeDecimal(decimal: Double): Fraccion{
            var valorSinDecimales = decimal.toString()
            val divisor = valorSinDecimales.split(".")
            valorSinDecimales = divisor[0] + divisor[1]
            val cantDecimales = divisor[1].length
            val retorno = Fraccion(valorSinDecimales.toInt(),10*cantDecimales)
            return retorno //Devuelve la Fraccion desde el decimal
        }
    }
}