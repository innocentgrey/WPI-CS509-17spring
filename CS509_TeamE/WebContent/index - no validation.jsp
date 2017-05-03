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
          <!-- <form class="form-horizontal" role="form" action="result.jsp" method="get"> -->

            <div id="searching_board" class="form-group"><!--id中间不能出现空格。需要用下划线代替空格 -->
              <div id="adjust1" class="col-sm-2">
                <input class="form-control" type="text" id="customer_from" name="customer_from" placeholder="From City or Airport" >
              </div>
              <div id="adjust2" class="col-sm-2">
                <input class="form-control" type="text" id="customer_to"  name="customer_to" placeholder="To City or Airport"  >
              </div>
              <div class="col-sm-2">
                <input class="form-control" type="date" id="customer_date" name="customer_date" id="date1"; required>
              </div>

              <div class="col-sm-2" id="returndiv">
                <input class="form-control" type="date" id="customer_returndate" name="customer_returndate" style="display:none"></input>
              </div>

              <div id="adjust3" class="col-sm-2">
                <button type="submit" class="btn btn-md btn-primary btn-block" id="customer_search" name="customer_search">Search</button>
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
                    <input type="radio" name="customer_cabin" id="Coach" value="Coach" checked>
                    Coach
                  </label>
                  <label class="color-1">
                    <input type="radio" name="customer_cabin" id="First-Class" value="First-Class">
                    First-Class
                  </label>
                </div>
                <label class="col-sm-1 color-1">Time Type</label>
                <div class="col-sm-2" id="adjust4">
                  <label class="color-1">
                    <input type="radio" name="customer_timetype" id="Departure" value="Departure" checked>
                    Departure
                  </label>
                  <label class="color-1">
                    <input type="radio" name="customer_timetype" id="Arrival" value="Arrival">
                    Arrival
                  </label>
                  
              </div>
              <label  id="returntimetypelabel" class="col-sm-1 color-1" style="display:none">Time Type</label>
                <div class="col-sm-2" id="returntimetypediv" style="display:none">
                  <label class="color-1">
                    <input type="radio" name="customer_returntimetype" id="Departure_return" value="Departure" checked>
                    Departure
                  </label>
                <label class="color-1">
                <input type="radio" name="customer_returntimetype" id="Arrival_return" value="Arrival">
                Arrival</label>
               </div>

              </div>
            </div>
          <!-- </form> -->
        </div>
      </div>
    </div>

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->

    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script language="javascript">
    
      $(function() {
          $("#one-way").click(function() {
            document.getElementById("returntimetypediv").style.display="none"
            document.getElementById("returntimetypelabel").style.display="none"
            document.getElementById("returninput").style.display="none"
          });
      });

      $(function() {
          $("#roundtrip").click(function() {
             $("#returntimetypediv").show();
             $("#returntimetypelabel").show();
             $("#returninput").show();
          });
      });


      $(function() {
          $("#customer_search").click(function() {
            window.location='result.jsp?customer_from='+document.getElementsByName("customer_from")[0].value+
             '&customer_to='+document.getElementsByName("customer_to")[0].value+
             '&customer_date='+document.getElementsByName("customer_date")[0].value+
             '&customer_returndate='+document.getElementsByName("customer_returndate")[0].value+
             '&customer_search='+document.getElementsByName("customer_search")[0].value+
             '&customer_triptype='+document.getElementsByName("customer_triptype")[0].value+
             '&customer_cabin='+document.getElementsByName("customer_cabin")[0].value+
             '&customer_timetype='+document.getElementsByName("customer_timetype")[0].value+
             '&customer_returntimetype='+document.getElementsByName("customer_returntimetype")[0].value;
          });
      });

    </script>
  </body>
</html>
