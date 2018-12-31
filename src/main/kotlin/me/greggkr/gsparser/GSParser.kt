package me.greggkr.gsparser

import java.io.File

object GSParser {
    fun parse(file: File): String {
        return file.readText()
            .replace("<br/>", "")
            .replace("&nbsp;", "")
            // Remove head
            .replace(Regex("<head.*?>.*?</head>", RegexOption.DOT_MATCHES_ALL), "")
            // Remove script tags
            .replace(Regex("<script.*?>.*?</script>", RegexOption.DOT_MATCHES_ALL), "")
            // Remove noscript Tag
            .replace(Regex("<noscript>.*?</noscript>", RegexOption.DOT_MATCHES_ALL), "")
            // Replaces notes
            .replace(Regex("<td class=\"AssignmentNote\"(.*?)>(.*?)</td>", RegexOption.DOT_MATCHES_ALL), "Note:'\$1'")
            // Remove the weird input things
            .replace(Regex("<input.*?( /)?>(.*?</input>)?", RegexOption.DOT_MATCHES_ALL), "")
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

    println(GSParser.parse(file))
}