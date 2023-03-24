package com.sir.richard.boss.y.sobes;

public class Main {
    public static void main(String[] args) {

        String template = "<Report> \n" +
                "<HEADER>\n" +
                "  <RT>1000</RT>\n" +
                "  <VN>02</VN>  \n" +
                "  <SID>%1$s</SID>\n" +
                "  <ST>01</ST>\n" +
                "  <INU>%2$s</INU>    \n" +
                "  <REPORT_CODE>REP013</REPORT_CODE>\n" +
                "  <REPORT_FORMAT>01</REPORT_FORMAT>\n" +
                "</HEADER>\n" +
                "<Filters>   \n" +
                "  <RT>2000</RT>\n" +
                "  <VN>02</VN>    \n" +
                "  <ACC_TYPE>%5$s</ACC_TYPE>\n" +
                " </Filters>\n" +
                "</Report>";

        Object[] params = {
                "4002",
                "ABCOWEBI01",
                "12345678",
                "67899",
                "11111",
                "33333",
                "20231201",
                "20231201",
        };

        //log.debug("DocId: " + doc.getId() + ", params: " + Utils.traceArray(params, true));

        String message = String.format(template, params);
        System.out.println(message);

        template = "<Report> \n" +
                "<HEADER>\n" +
                "  <RT>1000</RT>\n" +
                "  <VN>02</VN>  \n" +
                "  <SID>%1$s</SID>\n" +
                "  <ST>01</ST>\n" +
                "  <INU>%2$s</INU>    \n" +
                "  <REPORT_CODE>REP001</REPORT_CODE>\n" +
                "  <REPORT_FORMAT>02</REPORT_FORMAT>\n" +
                "</HEADER>\n" +
                "<Filters>   \n" +
                "  <RT>2000</RT>\n" +
                "  <VN>02</VN>    \n" +
                "  <FROM_DATE>%7$s</FROM_DATE>\n" +
                "  <TO_DATE>%8$s</TO_DATE>\n" +
                "  <USER_ID>%6$s</TO_DATE>\n" +
                "  <ACC_TYPE>%5$s</ACC_TYPE>\n" +
                " </Filters>\n" +
                "</Report>";
        message = String.format(template, params);
        System.out.println(message);

        //select F_TEMPLATE_WEB_USERS(p_date => TO_DATE('2023-03-23','YYYY-MM-DD'), p_participant => 123)
        template = "p_date => TO_DATE('%8$s','YYYYMMDD'), p_participant => 123";
        message = String.format(template, params);
        System.out.println(message);


        template = "{" +
                "  \"Report\": {\n" +
                "    \"HEADER\": {\n" +
                "      \"RT\": 1000,\n" +
                "      \"VN\": 2,\n" +
                "      \"SID\": \"%1$s\",\n" +
                "      \"ST\": 1,\n" +
                "      \"INU\": \"%2$s\",\n" +
                "      \"REPORT_CODE\": \"REP002\",\n" +
                "      \"REPORT_FORMAT\": 1\n" +
                "    },\n" +
                "    \"Filters\": {\n" +
                "      \"RT\": 2000,\n" +
                "      \"VN\": 2,\n" +
                "      \"FROM_DATE\": \"%7$s\",\n" +
                "      \"TO_DATE\": \"%8$s\",\n" +
                "      \"USER_ID\": \"%6$s\",\n" +
                "      \"ACC_TYPE\": \"%5$s\"\n" +
                "    }\n" +
                "  }\n" +
                "}";
        message = String.format(template, params);
        System.out.println(message);


    }
}
