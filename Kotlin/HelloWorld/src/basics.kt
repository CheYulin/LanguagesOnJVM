/**
 * Created by cheyulin on 10/8/16.
 */

package yche.demo

import java.util.*
import Customer

fun sum(a: Int, b: Int): Int {
    return a + b;
}

fun sum2(a: Int, b: Int) = a + b

fun printSum(a: Int, b: Int): Unit {
    println(a + b)
}

fun printSum2(a: Int, b: Int) {
    println(a + b)
}

fun main(args: Array<String>){
    println("3 + 4 = "+ sum(3,4))
    println("3 + 4 = "+ sum2(3,4))
    printSum(3,4)
    printSum2(3,4)

    val customer = Customer("Phase")
    println(customer.name)
    customer.name="Yche"
    println(customer.name)
}
