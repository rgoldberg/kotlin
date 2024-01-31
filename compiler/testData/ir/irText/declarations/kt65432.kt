// WITH_STDLIB
// ENABLE_IR_FAKE_OVERRIDE_GENERATION
// SEPARATE_SIGNATURE_DUMP_FOR_K2
// ^ Value parameters in fake overrides generated by K1 and K2 are different

// WITH_REFLECT
// TARGET_BACKEND: JVM_IR

// FILE: Java1.java
public class Java1 extends KotlinClass { }

// FILE: 1.kt
import java.util.ArrayList

class A : Java1()

open class KotlinClass : ArrayList<Int>()