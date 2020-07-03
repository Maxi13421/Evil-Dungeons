import kotlin.math.abs

object Map {
    val ausl = listOf<Int>()
    val ausr = listOf<Int>(0)
    val auso = listOf<Int>()
    val ausu = listOf<Int>()
    val postru = listOf<Int>()
    val map =listOf<Int>()
    fun cotoint(x : Int, y : Int) : Int {
        if(abs(y)>abs(x)){
            if(y>0){
                return (2*y-1)*(2*y-1) + 7*y + x
            }
            else{
                return (2*y+1)*(2*y+1) - 3*y - x
            }
        }
        else {
            if(x>0){
                return (2*x-1)*(2*x-1) + x - y
            }
            else{
                return (2*x+1)*(2*x+1) - 5*x + y
            }
        }
    }

    fun inttox(int : Int) : Int{
        var r = 0
        while((2*r+1)*(2*r+1)<=int){
            r++
        }
        var intneu = int - (2*r+1)*(2*r+1)
        if(intneu<2*r+1) return r
        else if (intneu<4*r+1) return r - int + 4
        else if (intneu<6*r+1) return -r
        else return int - 12 - r
    }

    fun inttoy(int : Int) : Int{
        var r = 0
        while((2*r+1)*(2*r+1)<=int){
            r++
        }
        var intneu = int - (2*r+1)*(2*r+1)
        if(intneu<2*r+1) return int - r
        else if (intneu<4*r+1) return -r
        else if (intneu<6*r+1) return int - r - 8
        else return r
    }

}