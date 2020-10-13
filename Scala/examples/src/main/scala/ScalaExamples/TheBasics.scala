package ScalaExamples

object TheBasics {

  def main(args: Array[String]) {

    // This is a one-line comment.


    /*
    This is
    a multiline comments
     */


    /* Conventions
    - class MyPerson
    - object MyPerson
    - package com.my.packagename
    - def myFunction
    - val and var: val myValue, var myVariable
    - static constants: val MyConstant
    - Generic variables starts with A, then B, and so on
    - Dont specify type if it is trivial: val name = "Bob"
    - Curly braces should be at the same line as the function
    - functions should have one space in between
    - val and var should have no space in between
   */


    /* Data types
    - Byte, Short, Int, Long
    - Float, Double
    - Char, String
    - Boolean
    - Unit: means "no value"
    - Null: mean "no reference"
    - Nothing: subtype of all types. It can be used in functions to return a non normal value
    - Any: The supertype of any type.
    - AnyRef: The supertype of any reference type.
   */
    val myByte: Byte = 127
    val myShort: Short = 32767
    val myInt: Int = 2147483647
    val myLong: Long = 9223372036854775807L
    val myFloat: Float = 3.14F
    val myDouble: Double = 3.14
    val myChar: Char = 'A'
    val myString: String = "ABC"
    val myBoolean: Boolean = true
    val myUnit: Unit = 1 // NB: myUnit still contains no value "()" even when referenced one
    val myNull: Null = null
    // val myNothing: Nothing = // NB: It is not possible to assign a value with type Nothing.
    val myAny: Any = "sfdsds"
    val myAnyRef: AnyRef = "sdd" // This works since String is an object with a reference.


    // variables
    var x = 10
    x = 20

    // constants
    val y = 20
    // y = 30  (This is not allowed)


    // if, else if, else
    if (x > 5) {
      println("x is more than 5")
    }
    else if (x > 0) {
      println("x is between 1 and 5")
    }
    else {
      println("x is 0 or less")
    }


    // functions


    // function call


    // function call with nothing


    // nested functions


    // Lambda function


    // for


    // while


    // object vs class?

    // What is case object and case class?

    // class

    // constructor

    // multiple constructors

    // functions with same name

    // interface

    // trait?

    // subclass

    // Generic parameters

    // Map, Filter, Reduce
  }
}
