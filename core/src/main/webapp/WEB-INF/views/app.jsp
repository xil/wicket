<%--
  Created by IntelliJ IDEA.
  User: inver
  Date: 29.06.13
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>MNSolution</title>
    <link rel="stylesheet" href="resources/js/lib/dijit/themes/claro/claro.css" media="screen"/>
    <link rel="stylesheet" href="resources/css/main.css"/>
    <link rel="stylesheet" href="resources/js/lib/dojox/grid/resources/claroGrid.css"/>

    <script>
        var dojoConfig = {
            async: true,
            baseUrl: "resources/js/",
            packages: [
                {name: "dojo", location: "lib/dojo" },
                {name: "dijit", location: "lib/dijit" },
                {name: "dojox", location: "lib/dojox" },
                {name: "app", location: "app", main: "app" },
                {name: "controllers", location: "app/controllers"},
                {name: "views", location: "app/views"},
                {name: "models", location: "app/models"},
                {name: "nls", location: "app/nls"}
            ],
            has: {
                "dojo-debug-messages": true
            },
            isDebug: true,
            locale: "ru",
//            parseOnLoad:true, //If this is true, then throw error, because double parsing 0_o
            deps: ["app/app" ]
        }
    </script>
    <script src="resources/js/lib/dojo/dojo.js"></script>
    <script>
        require(["dojo/parser", "app/app", "dojo/domReady!"], function (parser, App) {
            parser.parse();
            var application = new App();
            application.init();
        });
    </script>
</head>
<body class="claro">
<script type="dojo/require">at: "dojox/mvc/at"</script>
<div id="container"></div>
</body>
</html>