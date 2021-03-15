package me.cyberdie22.clipc

import com.google.common.base.Charsets
import com.google.common.io.Resources
import java.io.File

fun main(args: Array<String>) {
    @Suppress("UnstableApiUsage")
    val file = Resources.toString(Resources.getResource("test_files/test1.clip"), Charsets.UTF_8)
    println("E")
    println(Lexer(file).lex())
}