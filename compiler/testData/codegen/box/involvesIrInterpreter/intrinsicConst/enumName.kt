// !LANGUAGE: +IntrinsicConstEvaluation
// TARGET_BACKEND: JVM_IR
// IGNORE_BACKEND_K1: JVM_IR
fun <T> T.id() = this

enum class EnumClass {
    OK, VALUE, anotherValue, WITH_UNDERSCORE
}

const val name1 = EnumClass.OK.<!EVALUATED("OK")!>name<!>
const val name2 = EnumClass.VALUE.<!EVALUATED("VALUE")!>name<!>
const val name3 = EnumClass.anotherValue.<!EVALUATED("anotherValue")!>name<!>
const val name4 = EnumClass.WITH_UNDERSCORE.<!EVALUATED("WITH_UNDERSCORE")!>name<!>

fun box(): String {
    if (EnumClass.OK.<!EVALUATED("OK")!>name<!>.id() != "OK") return "Fail 1"
    if (<!EVALUATED("VALUE")!>name2<!>.id() != "VALUE") return "Fail 2"
    if (<!EVALUATED("anotherValue")!>name3<!>.id() != "anotherValue") return "Fail 3"
    if (<!EVALUATED("WITH_UNDERSCORE")!>name4<!>.id() != "WITH_UNDERSCORE") return "Fail 4"
    return <!EVALUATED("OK")!>name1<!>.id()
}
