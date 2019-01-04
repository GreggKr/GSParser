package me.greggkr.gsparser

val PG_HEADER_STD_HEADER_TOP_OF_TABLE = Regex(
    "            <td id=\"_ctl0_tdMainContent\" align=\"left\" class=\"MainContentLeft\">\n" +
            "               \n" +
            "   <span class=\"PageHeader\">Student Grades</span>\n" +
            "   <p class=\"PageNote\"></p>\n" +
            "   <P><div class=\"StudentHeader\"><span class=\"StudentName\">.*?</span> .*?</div><table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" class=\"DataTable\"><tr class=\"TableHeader\"><th align=\"left\" scope=\"col\">Teacher</th><th align=\"left\" scope=\"col\">Notes</th><th align=\"left\" scope=\"col\">Course</th><th align=\"left\" scope=\"col\">Period</th><th align=\"left\" scope=\"col\">Cycle 1</th><th align=\"left\" scope=\"col\">Cycle 2</th><th align=\"left\" scope=\"col\">Exam 1</th><th align=\"left\" scope=\"col\">Sem 1</th><th align=\"left\" scope=\"col\">Cycle 3</th><th align=\"left\" scope=\"col\">Cycle 4</th><th align=\"left\" scope=\"col\">Exam 2</th><th align=\"left\" scope=\"col\">Sem 2</th>",
    RegexOption.DOT_MATCHES_ALL
)