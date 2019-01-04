package me.greggkr.gsparser

import java.io.File

object GSParser {
    fun deserialize(file: File): String {
        return file.readText()
            .replace("<br/>", "")
            .replace("&nbsp;", "")
            // Remove head
            .replace(Regex("<head.*?>.*?</head>", RegexOption.DOT_MATCHES_ALL), "")
            // Remove script tags
            .replace(Regex("<script.*?>.*?</script>", RegexOption.DOT_MATCHES_ALL), "")
            // Remove noscript Tag
            .replace(Regex("<noscript>.*?</noscript>", RegexOption.DOT_MATCHES_ALL), "")
            // Remove the weird input things
            .replace(Regex("<input.*?( /)?>(.*?</input>)?", RegexOption.DOT_MATCHES_ALL), "")
            // Replace Rows
            .replace(Regex("<tr.*?>(.*?)</tr>", RegexOption.DOT_MATCHES_ALL), "tr: \"\"\$1\"\"\n\n")
            // Replaces notes
            .replace(Regex("<td class=\"AssignmentNote\"(.*?)>(.*?)</td>", RegexOption.DOT_MATCHES_ALL), "Note:'\$2'")
            // Replace Names
            .replace(Regex("<td class=\"AssignmentName\"(.*?)>(.*?)</td>", RegexOption.DOT_MATCHES_ALL), "Name:'\$2'")
            // Replace Average
            .replace(Regex("<td>Average</td><td>(.*?)</td>", RegexOption.DOT_MATCHES_ALL), "Average:'\$1`")
            // Remove some of the junk
//            .replace(Regex("<table(.*?)>(.*?)</table>", RegexOption.DOT_MATCHES_ALL), "\$1")
            // Remove navbar
            .replace(Regex("<ul class=\"NavBarLinks\">.*?</ul>", RegexOption.DOT_MATCHES_ALL), "")
            // Remove current user
            .replace(Regex("<p class=\"CurrentUser\">.*?</p>", RegexOption.DOT_MATCHES_ALL), "")
            // Bunch of magic strings
            .replace(PG_HEADER_STD_HEADER_TOP_OF_TABLE, "")
            // Replace Date Assigned
            .replace(
                Regex("<td class=\"DateAssigned\"(.*?)>(.*?)</td>", RegexOption.DOT_MATCHES_ALL),
                "Assigned:'\$2'"
            )
            // Replace Date Due
            .replace(
                Regex("<td class=\"DateDue\"(.*?)>(.*?)</td>", RegexOption.DOT_MATCHES_ALL),
                "Due:'\$2'"
            )
            // Replace Grade:
            .replace(
                Regex("<td class=\"AssignmentGrade\"(.*?)>(.*?)</td>", RegexOption.DOT_MATCHES_ALL),
                "Grade:'\$2'"
            )
            // Very annoying things at the end of each tr
            .replace("<td></td>", "")
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

    println(GSParser.deserialize(file))
}