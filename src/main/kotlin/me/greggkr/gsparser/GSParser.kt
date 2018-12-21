package me.greggkr.gsparser

import java.io.File

object GSParser {
    fun parse(file: File): String {
        val text = file.readLines()
        return ""
    }
}

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Invalid file.")
        return
    }

    val file = File(args[0])
    if (!file.exists() || !file.isFile) {
        println("Invalid file.")
        return
    }

    GSParser.parse(file)
}