import kotlin.math.abs

object Map {
    val ausl = listOf<Int>()
    val ausr = listOf<Int>(0)
    val auso = listOf<Int>()
    val ausu = listOf<Int>()
    val postru = listOf<Int>()
    var map : Array<Int> = Array(1000000) {i-> 24}
    var plaroom : Int = 0
    var raumliste : List<Raum> = listOf(
            Raum("Raum/Raum0.png", listOf(),  arrayOf(false,true,false,false), listOf()),
            Raum("Raum/Raum1.png", listOf(),  arrayOf(false,true,true,true),  listOf()),
            Raum("Raum/Raum2.png", listOf(),  arrayOf(true,false,true,true),  listOf()),
            Raum("Raum/Raum3.png", listOf(),  arrayOf(false,true,false,true),  listOf()),
            Raum("Raum/Raum4.png", listOf(),  arrayOf(false,true,false,true),  listOf()),
            Raum("Raum/Raum5.png", listOf(),  arrayOf(false,true,false,true),  listOf()),
            Raum("Raum/Raum6.png", listOf(),  arrayOf(true,false,true,false),  listOf()),
            Raum("Raum/Raum7.png", listOf(),  arrayOf(true,false,true,false),  listOf()),
            Raum("Raum/Raum8.png", listOf(),  arrayOf(true,false,true,false),  listOf()),
            Raum("Raum/Raum9.png", listOf(),  arrayOf(true,false,false,true),  listOf()),
            Raum("Raum/Raum10.png", listOf(),  arrayOf(true,false,false,true),  listOf()),
            Raum("Raum/Raum11.png", listOf(),  arrayOf(true,false,false,true),  listOf()),
            Raum("Raum/Raum12.png", listOf(),  arrayOf(false,false,true,true),  listOf()),
            Raum("Raum/Raum13.png", listOf(),  arrayOf(false,false,true,true),  listOf()),
            Raum("Raum/Raum14.png", listOf(),  arrayOf(false,false,true,true),  listOf()),
            Raum("Raum/Raum15.png", listOf(),  arrayOf(false,true,true,false),  listOf()),
            Raum("Raum/Raum16.png", listOf(),  arrayOf(false,true,true,false),  listOf()),
            Raum("Raum/Raum17.png", listOf(),  arrayOf(false,true,true,false),  listOf()),
            Raum("Raum/Raum18.png", listOf(),  arrayOf(true,true,false,false),  listOf()),
            Raum("Raum/Raum19.png", listOf(),  arrayOf(true,true,false,false),  listOf()),
            Raum("Raum/Raum20.png", listOf(),  arrayOf(true,true,false,false),  listOf()),
            Raum("Raum/Raum21.png", listOf(),  arrayOf(false,false,false,true),  listOf()),
            Raum("Raum/Raum22.png", listOf(),  arrayOf(false,true,false,false),  listOf()),
            Raum("Raum/Raum23.png", listOf(),  arrayOf(false,false,true,false),  listOf()),
            Raum("", listOf(), arrayOf(false,false,false,false), listOf()),
            Raum("Raum/Raum25.png", listOf(),  arrayOf(true,false,false,false), listOf()),
            Raum("Raum/Raum26.png", listOf(),  arrayOf(true,true,false,true), listOf()),
            Raum("Raum/Raum27.png", listOf(),  arrayOf(true,true,true,false), listOf()),
            Raum("Raum/Raum28.png", listOf(),  arrayOf(true,true,true,true), listOf()),
            Raum("Raum/Raum22.png", listOf(),  arrayOf(false,true,false,false),  listOf()),
            Raum("Raum/Raum23.png", listOf(),  arrayOf(false,false,true,false),  listOf()),
            Raum("Raum/Raum22.png", listOf(),  arrayOf(false,true,false,false),  listOf()),
            Raum("Raum/Raum23.png", listOf(),  arrayOf(false,false,true,false),  listOf()),
            Raum("Raum/Raum25.png", listOf(),  arrayOf(true,false,false,false), listOf()),
            Raum("Raum/Raum25.png", listOf(),  arrayOf(true,false,false,false), listOf())
            )


    fun generateMap(){
        Map.map[0] = 0
        var aab = -1
        var ran : Int
        while(aab<99999){
            aab++
            print(aab)
            println(Map.map[aab])
            if(Map.map[aab]!=24) {
                if (Map.raumliste[Map.map[aab]].exith[0] && Map.map[cotoint(inttox(aab), inttoy(aab) + 1)] == 24) {
                    var boo = true
                    while (boo) {
                        ran = (1..33).random()
                        if(ran>=24) ran++
                        println("a")
                        if (Map.raumliste[ran].exith[2] &&
                                (Map.map[cotoint(inttox(aab) - 1, inttoy(aab) + 1)] == 24 || (Map.raumliste[ran].exith[3] == false && Map.raumliste[Map.map[cotoint(inttox(aab) - 1, inttoy(aab) + 1)]].exith[1] == false) || (Map.raumliste[ran].exith[3] && Map.raumliste[Map.map[cotoint(inttox(aab) - 1, inttoy(aab) + 1)]].exith[1])) &&
                                (Map.map[cotoint(inttox(aab), inttoy(aab) + 2)] == 24 || (Map.raumliste[ran].exith[0] == false && Map.raumliste[Map.map[cotoint(inttox(aab), inttoy(aab) + 2)]].exith[2] == false) || (Map.raumliste[ran].exith[0] && Map.raumliste[Map.map[cotoint(inttox(aab), inttoy(aab) + 2)]].exith[2])) &&
                                (Map.map[cotoint(inttox(aab) + 1, inttoy(aab) + 1)] == 24 || (Map.raumliste[ran].exith[1] == false && Map.raumliste[Map.map[cotoint(inttox(aab) + 1, inttoy(aab) + 1)]].exith[3] == false) || (Map.raumliste[ran].exith[1] && Map.raumliste[Map.map[cotoint(inttox(aab) + 1, inttoy(aab) + 1)]].exith[3]))
                        ) {
                            //&&
                            //                                (aab<300 || (ran != 1 && ran != 2 && ran != 26 && ran != 27 && ran != 28))
                            boo = false
                            Map.map[cotoint(inttox(aab), inttoy(aab) + 1)] = ran
                            aab = 0
                            print("gen")
                        }
                    }

                }
                else if (Map.raumliste[Map.map[aab]].exith[1] && Map.map[cotoint(inttox(aab) + 1, inttoy(aab))] == 24) {
                    var boo = true
                    while (boo) {
                        ran = (1..33).random()
                        if(ran>=24) ran++
                        println("b")
                        if (Map.raumliste[ran].exith[3] &&
                                (Map.map[cotoint(inttox(aab) + 1, inttoy(aab) + 1)] == 24 || (Map.raumliste[ran].exith[0] == false && Map.raumliste[Map.map[cotoint(inttox(aab) + 1, inttoy(aab) + 1)]].exith[2] == false) || (Map.raumliste[ran].exith[0] && Map.raumliste[Map.map[cotoint(inttox(aab) + 1, inttoy(aab) + 1)]].exith[2])) &&
                                (Map.map[cotoint(inttox(aab) + 2, inttoy(aab))] == 24 || (Map.raumliste[ran].exith[1] == false && Map.raumliste[Map.map[cotoint(inttox(aab) + 2, inttoy(aab))]].exith[3] == false) || (Map.raumliste[ran].exith[1] && Map.raumliste[Map.map[cotoint(inttox(aab) + 2, inttoy(aab))]].exith[3])) &&
                                (Map.map[cotoint(inttox(aab) + 1, inttoy(aab) - 1)] == 24 || (Map.raumliste[ran].exith[2] == false && Map.raumliste[Map.map[cotoint(inttox(aab) + 1, inttoy(aab) - 1)]].exith[0] == false) || (Map.raumliste[ran].exith[2] && Map.raumliste[Map.map[cotoint(inttox(aab) + 1, inttoy(aab) - 1)]].exith[0]))
                        ) {
                            //&&
                            //                                (aab<300 || (ran != 1 && ran != 2 && ran != 26 && ran != 27 && ran != 28))
                            boo = false
                            Map.map[cotoint(inttox(aab) + 1, inttoy(aab))] = ran
                            aab=0
                            print("gen")
                        }
                    }

                }
                else if (Map.raumliste[Map.map[aab]].exith[2] && Map.map[cotoint(inttox(aab), inttoy(aab) - 1)] == 24) {
                    var boo = true
                    while (boo) {
                        ran = (1..33).random()
                        if(ran>=24) ran++
                        println("c")
                        if (Map.raumliste[ran].exith[0] &&
                                (Map.map[cotoint(inttox(aab) + 1, inttoy(aab) - 1)] == 24 || (Map.raumliste[ran].exith[1] == false && Map.raumliste[Map.map[cotoint(inttox(aab) + 1, inttoy(aab) - 1)]].exith[3] == false) || (Map.raumliste[ran].exith[1] && Map.raumliste[Map.map[cotoint(inttox(aab) + 1, inttoy(aab) - 1)]].exith[3])) &&
                                (Map.map[cotoint(inttox(aab), inttoy(aab) - 2)] == 24 || (Map.raumliste[ran].exith[2] == false && Map.raumliste[Map.map[cotoint(inttox(aab), inttoy(aab) - 2)]].exith[0] == false) || (Map.raumliste[ran].exith[2] && Map.raumliste[Map.map[cotoint(inttox(aab), inttoy(aab) - 2)]].exith[0])) &&
                                (Map.map[cotoint(inttox(aab) - 1, inttoy(aab) - 1)] == 24 || (Map.raumliste[ran].exith[3] == false && Map.raumliste[Map.map[cotoint(inttox(aab) - 1, inttoy(aab) - 1)]].exith[1] == false) || (Map.raumliste[ran].exith[3] && Map.raumliste[Map.map[cotoint(inttox(aab) - 1, inttoy(aab) - 1)]].exith[1]))
                        ) {
                            //&&
                            //                                (aab<300 || (ran != 1 && ran != 2 && ran != 26 && ran != 27 && ran != 28))
                            boo = false
                            Map.map[cotoint(inttox(aab), inttoy(aab) - 1)] = ran
                            aab=0
                            print("gen")
                        }
                    }

                }
                else if (Map.raumliste[Map.map[aab]].exith[3] && Map.map[cotoint(inttox(aab) - 1, inttoy(aab))] == 24) {
                    var boo = true
                    while (boo) {
                        ran = (1..33).random()
                        if(ran>=24) ran++
                        println("d")
                        if (Map.raumliste[ran].exith[1]&&
                                (Map.map[cotoint(inttox(aab) - 1, inttoy(aab) - 1)] == 24 || (Map.raumliste[ran].exith[2] == false && Map.raumliste[Map.map[cotoint(inttox(aab) - 1, inttoy(aab) - 1)]].exith[0] == false) || (Map.raumliste[ran].exith[2] && Map.raumliste[Map.map[cotoint(inttox(aab) - 1, inttoy(aab) - 1)]].exith[0])) &&
                                (Map.map[cotoint(inttox(aab) - 2, inttoy(aab))] == 24 || (Map.raumliste[ran].exith[3] == false && Map.raumliste[Map.map[cotoint(inttox(aab) - 2, inttoy(aab))]].exith[1] == false) || (Map.raumliste[ran].exith[3] && Map.raumliste[Map.map[cotoint(inttox(aab) - 2, inttoy(aab))]].exith[1])) &&
                                (Map.map[cotoint(inttox(aab) - 1, inttoy(aab) + 1)] == 24 || (Map.raumliste[ran].exith[0] == false && Map.raumliste[Map.map[cotoint(inttox(aab) - 1, inttoy(aab) + 1)]].exith[2] == false) || (Map.raumliste[ran].exith[0] && Map.raumliste[Map.map[cotoint(inttox(aab) - 1, inttoy(aab) + 1)]].exith[2]))
                        ) {
                            //&&
                            //                                (aab<300 || (ran != 1 && ran != 2 && ran != 26 && ran != 27 && ran != 28))
                            boo = false
                            Map.map[cotoint(inttox(aab) - 1, inttoy(aab))] = ran
                            aab=0
                            print("gen")
                        }
                    }

                }
            }

        }
    }



    fun raumr(){
        Map.plaroom = cotoint(inttox(Map.plaroom)+1, inttoy(Map.plaroom))
    }
    fun rauml(){
        Map.plaroom = cotoint(inttox(Map.plaroom)-1, inttoy(Map.plaroom))
    }
    fun raumo(){
        Map.plaroom = cotoint(inttox(Map.plaroom), inttoy(Map.plaroom)+1)
    }
    fun raumu(){
        Map.plaroom = cotoint(inttox(Map.plaroom)+1, inttoy(Map.plaroom)-1)
    }
    fun cotoint(x : Int, y : Int) : Int {
        if(x==0 && y==0){
            return 0
        }
        else if(abs(y)>abs(x)){
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
        var intneu : Int
        if(r>0) {intneu = int - (2*r-1)*(2*r-1)}
        else{intneu = int}
        if(intneu<2*r+1) return r
        else if (intneu<4*r+1) return r - intneu + 4
        else if (intneu<6*r+1) return - r
        else return intneu - 12 - r
    }

    fun inttoy(int : Int) : Int{
        var r = 0
        while((2*r+1)*(2*r+1)<=int){
            r++
        }
        var intneu : Int
        if(r>0) {intneu = int - (2*r-1)*(2*r-1)}
        else{intneu = int}
        if(intneu<2*r+1) return r - intneu
        else if (intneu<4*r+1) return -r
        else if (intneu<6*r+1) return intneu - r - 8
        else return r
    }



}