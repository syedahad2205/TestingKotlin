import java.io.File
import java.net.FileNameMap
import java.util.*

class lamp{

    private val heavyObject:HeavyClass by lazy {
        println("heavy object init")
        HeavyClass() }

    fun accessheavyobj(){
        println(heavyObject)

    }

    companion object{
        fun callMe()= println("companion executed")
    }

    var isOn: Boolean=false

    fun turnOn(){
        isOn=true
    }
    fun turnOff(){
        isOn=false
    }


}
class HeavyClass{
    fun checkhc(){
        println("Inside heavyclass")
    }

}


fun main(args:Array<String>){
    lateinit var lateinitobj: String
    println("First")
    val l1=lamp()
    val l2=lamp()
    var name="Syed"                                     //mutable
    name="Syed Ahad"
    l1.turnOn()
    println(l1.isOn)
    println(l2.isOn)
    println(name)

    var str: String?="Hello"     //Nullable string
    var len= str?.length            //null safety added
    println("$str legth is : $len")


    val lambdaex = { println("Lambda demo")}
    val lambdasum = {a:Int, b:Int, -> println(a+b)}


    lambdaex()
    lambdasum(2,4)

    //type interference
    val sum2 = { a: Int, b: Int ->
        val res = a + b
        res . toString ()
    }
    println(sum2(6,9))

    val lambdaclassextension : String.(Int) -> String= {this + it} //can be outside main

    val lce = "classextension".lambdaclassextension(10)
    println(lce)

    val itdemo = arrayOf(1,3,2,5,5,6,3)
    println(itdemo.filter { it>3 })     //shorthand form
    println(itdemo.filter { item -> item > 1 })

    //return value from lambda

    val checkeven = fun(num:Int): String {
        if (num % 2 == 0) {
            return "number is even"
        } else {
            return "number is not even"
        }
    }

    println(checkeven(6))

    //anonymous function
    val anofun = fun(x:Int,y:Int)=y-x
    println(anofun(2,4))

    val anofunblock = fun(a:Int, b:Int):Int{
        val mul=a*b
        return mul
    }
    println(anofunblock(3,23))

    fun higherord(lmd:() -> Unit){         //higher order func passing lambda par
        lmd()                               //lmbd recieves lambda
    }
    higherord(lambdaex)

    fun higherfun(lmbd:(Int,Int) -> Int){
        var res2= lmbd(2,4)                 //lmbd par is passed to lamda that is called inside fun par
        println(res2)
    }
    higherfun(anofunblock)


    fun sub(c:Int,d:Int):Int{
        var sub=d-c
        return sub

    }
    fun add(e:Int,f:Int):Int{
        var addi=e+f
        return addi
    }

    fun hfsub(subfun:(Int,Int)->Int){
        var resultsub=sub(2,9)
       println(resultsub)

    }
    hfsub(::sub)                //passing fun returning integer. check with ::

    fun mul(a:Int,b:Int):Int{
        return a*b
    }

    fun higherfun():((Int,Int)->Int){
        return::mul
    }
    val multiply=higherfun()
    println(multiply(9,9))              //returning funtion from higherorderfun

    //imutable collection

    val immutableList=listOf("Syed","Sheikh","hurzuk")
    for(item in immutableList){
        println(item)
    }

    //set is same as list but it omits duplicates even though its repeated in declaration

    val immutableSet = setOf("1","2","3","1")
    for(item in immutableSet)
    {
        println(item)

    }

    //map= key-value, key cannot be duplicated
    var immutableMap= mapOf(1 to "abc", 2 to "def")
    for(value in immutableMap.keys){
        println(immutableMap[value])
    }

    //mutable
    //mutable list can edit
    var mutableList = mutableListOf("a","b","c","d")
    mutableList[0]="start"
    mutableList.add("e")
    for (item in mutableList){
        println(item)
    }

    //set editable
    var mutableSet = mutableSetOf<Int>(6,9)
    mutableSet.add(6)
    mutableSet.add(8)
    for(item in mutableSet)
    {
        print(item)
    }
    println()

    //map editable
    var mutableMap = mutableMapOf<Int,String>(1 to "one", 2 to "too")
    mutableMap.put(3,"three")
    mutableMap.put(2,"Two")
    for(item in mutableMap){
        println(item)
    }

    val longerthan3 = mutableList.filter{it.length>3}
    println(longerthan3)

    val filtermap= mutableMap.filter { (key,value) -> value.endsWith("e") }
    println(filtermap)

    //use filternot to exclude
    //filterindex, if we want to filter using index

    val(first,second)=immutableList.partition{it.length>4}
        println(first)
        println(second)

    val words = listOf("hello","world","kotlin","poo")
    println(words.any{it.endsWith("o")})
    println(words.none{it.endsWith("a")})
    println(words.all {it.endsWith("h")})


    val compexec= lamp.Companion.callMe() //companion execution

    lateinitobj= "late init initialization"
    println(lateinitobj)


    val hob = lamp()
    hob.accessheavyobj()
    val hobjc = HeavyClass()
    hobjc.checkhc()

    //var input1= readLine()
    //println(input1)

    var sc=Scanner(System.`in`)
    //var checkintinput:Int = sc.nextInt()
    //println(2*checkintinput)

    //fun readFile(fileName: String)= File("abc.txt").forEachLine{println(it)}
    val fileName="demo.txt"
    var file=File("demo.txt")
    var isCreated= file.createNewFile()
    if(isCreated)
        println("created")
    else
        println("not created")


   file.writeText("writing to file")

    file.forEachLine { println(it) }
    println("read bytes--")
    var bytes:ByteArray = file.readBytes()
    for(byte in bytes){
        print(byte.toChar())
    }
    //println(file.readText())
    println()
    println("readlines()")

    file.appendText("second line")
    var lines:List<String> = file.readLines()

    for (line in lines){
        println(line)

    }

    val newfile="copy2.txt"
    File(fileName).copyTo(File(newfile),true)

    //File handling done
    var variable_name= String() //empty string creation
    variable_name="string example"
    println(variable_name[3])
    for(i in variable_name.indices)
    {
        print(variable_name[i]+",")
    }
    println()
    println(variable_name.length)
    print(variable_name.subSequence(1,4))
    println(variable_name.get(4))
    var cmpstr="compare"
    println((variable_name.compareTo(cmpstr)))

    var strraw = """My 
        |name
        |is
        |syed
       """.trimMargin()

    println(strraw)

    //use \n in a string to jump to new line
    println(variable_name==cmpstr)







}