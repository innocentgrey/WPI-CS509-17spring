<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <meta http-equiv="content-language" content="en-US" />
    <link rel="icon" href="../../favicon.ico">

    <title>Flight Reservation Web Application</title>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/bootstrap-social.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <style type="text/css">
    body{
      background-image:url(flight.jpg);
      background-repeat:no-repeat;
      background-size:cover;
    }

    .color-white{
      color:#FFF;
    }
    .color-1{
      color:#444444;
    }
  </style>

  <body>

    <div class="container">
      <div class="row">
        <div class="col-xs-12">
          <h1 class="color-white">Look up your flights here</h1>

        </div>
        <div class="col-sm-12">
          <form class="form-horizontal" role="form" action="result.jsp" method="get">

            <div id="searching_board" class="form-group"><!--id中间不能出现空格。需要用下划线代替空格 -->
              <div id="adjust1" class="col-sm-2">
                <input class="form-control" type="text" name="customer_from" placeholder="From City or Airport" required autofocus>
              </div>
              <div id="adjust2" class="col-sm-2">
                <input class="form-control" type="text" name="customer_to" placeholder="To City or Airport" required>
              </div>
              <div class="col-sm-2">
                <input class="form-control" type="date" id="date1" name="customer_date" required>
              </div>

              <div id="adjust3" class="col-sm-2">
                <button type="submit" class="btn btn-md btn-primary btn-block" name="customer_search">Search</button>
              </div>
            </div>

            <div class="col-sm-8">
              <div class="form-group">
                <label class="col-sm-1 color-1">Trip Type</label>
                <div class="col-sm-2">
                  <label class="color-1">
                    <input type="radio" name="customer_triptype" id="one-way" value="One-Way" Checked>
                    One-Way
                  </label>
                  <label class="color-1">
                    <input type="radio" name="customer_triptype" id="roundtrip" value="Roundtrip">
                    Roundtrip
                  </label>
                </div>
                <label class="col-sm-1 color-1">Cabin</label>
                <div class="col-sm-2">
                  <label class="color-1">
                    <input type="radio" name="customer_cabin" id="economy" value="Economy" checked>
                    Economy
                  </label>
                  <label class="color-1">
                    <input type="radio" name="customer_cabin" id="premium" value="Premium">
                    Premium
                  </label>
                </div>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script language="javascript">
    var flag = 0;
    var txt = '<div class="col-sm-2"><input class="form-control" type="date" name="customer_date" id="date1"; required></div><div id="adjust3" class="col-sm-2"><button type="submit" class="btn btn-md btn-primary btn-block" name="customer_search">Search</button></div>'
    var txt1 = '<div class="col-sm-2"><input class="form-control" type="date"id="date2"name="customer_date1" required></div><div class="col-sm-2"><input class="form-control" type="date"id="date3"name="customer_date2" required></div><div id="adjust3" class="col-sm-2"><button type="submit" class="btn btn-md btn-primary btn-block" name="customer_search">Search</button></div>'
      $(function() {
          $("#one-way").click(function() {
            if(flag == 1) {
              $("#adjust3").remove();
              $("#date2").remove();
              $("#date3").remove();
              $("#adjust2").after(txt);
              flag = 0;
            }
          });
      });

      $(function() {
          $("#roundtrip").click(function() {
            if(flag == 0) {
              $("#date1").remove();
              $("#adjust3").remove();
              $("#adjust2").after(txt1);
              flag = 1;
            }
          });
      });
    </script>
    <script language="javascript">
      <%
        ArrayList<String> successFlight = new ArrayList<String>();
        ArrayList<String> successSeatType = new ArrayList<String>();
        Enumeration paramNames = request.getParameterNames();
        int tp = 0;
        while (paramNames.hasMoreElements()) {
          String paramName = (String) paramNames.nextElement();
          String paramValue = request.getParameter(paramName);
          if (tp == 0) {
            successFlight.add(paramValue);
            tp = 1;
          } else {
            successSeatType.add(paramValue);
            tp = 0;
          }
        }
      %>
    </script>
  </body>
</html>
