package com.sir.richard.boss.regex;

public class LogFinder {

    private static String TEXT_LOG = """
                        2023-02-14 13:30:45,748 DEBUG ? [http-nio-0.0.0.0-61665-exec-18] Before request [POST /input/request-report, headers=[charset:"UTF-8", authorization:"Basic QUJDT1dFQkkwMTox", x-request-id:"380ddeec-58d9-47d3-ab19-7ccb9d8ed741", dt:"ReqReportBCRB", sender:"ABCOWEBI01", prep:"2023-02-14T16:30", user:"Yaqoob.Baqi", content-length:"27", host:"localhost:61665", connection:"Keep-Alive", user-agent:"Apache-HttpClient/4.5.14 (Java/1.8.0_333)", accept-encoding:"gzip,deflate", Content-Type:"application/json;charset=UTF-8"]]

                        2023-02-14 13:30:45,749 DEBUG ? [http-nio-0.0.0.0-61665-exec-18] Read "application/json;charset=UTF-8" to ["{"rc":"REP009","params":{}}"]
                        2023-02-14 13:30:45,749 ERROR ? [http-nio-0.0.0.0-61665-exec-18] Wrong date: 2023-02-14T16:30 for pattern: yyyyMMdd
                        2023-02-14 13:30:45,749 DEBUG ? [http-nio-0.0.0.0-61665-exec-18] REST Controller, got new message, type: ReqReportBCRB, ref:380ddeec-58d9-47d3-ab19-7ccb9d8ed741, sender: ABCOWEBI01
                        2023-02-14 13:30:45,749 DEBUG ? [http-nio-0.0.0.0-61665-exec-18] REST Controller, message: {"rc":"REP009","params":{}}

                        2023-02-14 13:30:45,808 DEBUG ? [http-nio-0.0.0.0-61665-exec-18] DocId: 1082, report REP009 template:
                        1000 02 %1$s 01 %2$s REP009 01 2000 02 2023-02-14 13:30:45,810 DEBUG ? [http-nio-0.0.0.0-61665-exec-18] DocId: 1082, params: [4002,40020020,,,,,,] 2023-02-14 13:30:45,810 DEBUG ? [http-nio-0.0.0.0-61665-exec-18] DocId: 1082, formatted message:
                        2023-02-14 13:30:58,944 DEBUG ? [DefaultMessageListenerContainer-1] decrypted string(1256):

                        1624<TITLE>Consumer Monthly Data Audit Report</TITLE>REP00920230214 04:30:57 PMArab Banking CorporationBanks and financial institutionsJANUARY 20235168005880000000SHA5123082010A0282010100D8F165280738A827AA1D2960D09ECA7EA3928BC3B6BA4CF034BEFE6E00DB434793B96C2FD2411BE086B6CE4B30441D18DFF377497F99F043E74B2C30555D2157C2838C9E7BDD566F0633CC0BE6F2649278BB8FE15EB2D4020C087B2252D8ED024DD260A3AA07F399D90EBDA722BEFECAD6D7A011A30F9013C4AFE3E15BA5E5B9028DE51079CDE125555B82E4269699E662D8BF182DF173FCC90135FC117B8254BF7036FE0A9B0667C0266E8EF94F9EE630CA0CF611FF0BB2BBFD99A7B9D9CC6C93D272A7DC8
            """;
    public static void main(String[] args) {
        // найти все записи с кодом отчета REP009 у пользователя Yaqoob
        String regex = """
                Yaqoob[\\s\\b\\d\\-\\.\\w",:\\/\\(\\);=\\]\\&\\?\\[\\}\\{#'<>\\$\\@]*(REP009){1}
                """;

    }
}
