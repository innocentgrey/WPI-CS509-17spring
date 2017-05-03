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
    <link href="toastr/build/toastr.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="sweetalert-master/dist/sweetalert.css">

    <script src="sweetalert-master/dist/sweetalert.min.js"></script>

    <!-- Custom styles for this template -->

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

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
                <input class="form-control" type="date" id="customer_returndate" name="customer_returndate" style="display:none">
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
                    <input type="radio" name="customer_cabin" id="FirstClass" value="FirstClass">
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
      var Airports = new Array("ATL","ANC","AUS","BWI","BOS","CLT","MDW","ORD","CVG","CLE","CMH","DFW","DEN","DTW","FLL","RSW","BDL","HNL","IAH","HOU","IND","MCI","LAS","LAX","MEM","MIA","MSP","BNA","MSY","JFK","LGA","EWR","OAK","ONT","MCO","PHL","PHX","PIT","PDX","RDU","SMF","SLC","SAT","SAN","SFO","SJC","SNA","SEA","STL","TPA","IAD","DCA");
      $(function() {
          $("#one-way").click(function() {
            document.getElementById("returntimetypediv").style.display="none"
            document.getElementById("returntimetypelabel").style.display="none"
            document.getElementById("customer_returndate").style.display="none"
            // document.getElementById("customer_returndate").value=""
          });
      });

      $(function() {
          $("#roundtrip").click(function() {
             $("#returntimetypediv").show();
             $("#returntimetypelabel").show();
             $("#customer_returndate").show();
          });
      });

      //data validation
      $(function() {
          $("#customer_search").click(function() {
            //alert(document.getElementsByName("customer_date")[0].value)
      //      alert($("input[name='customer_date']").val()=="");
            //sweetAlert("Congratulations","Reservation Success","success")
            if(
              //The return time should not be before the outbound time
              $('input:radio[name="customer_triptype"]:checked').val()=="Roundtrip"&&(
              $("input[name='customer_date']").val()  >
              $("input[name='customer_returndate']").val() )) {
                  //alert("The return time should not be before the outbound time");
                  toastr.warning("The return time should not be before the outbound time")
            }
            else if ($("input[name='customer_date']").val()=="") {
              toastr.warning("Date cannot be empty")
            }
            else if ($("input[name='customer_triptype']:checked").val()=="Roundtrip"&&$("input[name='customer_returndate']").val()=="") {
              toastr.warning("Date cannot be empty!!!")
            }
            //Departure city and Arrival city cannot be the same
            else if(document.getElementsByName("customer_from")[0].value==""||
              document.getElementsByName("customer_to")[0].value==""){
                  //alert("Departure city or Arrival city cannot be empty");
                  toastr.warning("Departure city or Arrival city cannot be empty")

            }
            else if (document.getElementsByName("customer_from")[0].value==document.getElementsByName("customer_to")[0].value){
                //  alert("Departure city and Arrival city cannot be the same");
                  toastr.warning("Departure city and Arrival city cannot be the same")
            }
            else if (Airports.includes($("input[name='customer_from']").val().toUpperCase()) == false || Airports.includes($("input[name='customer_to']").val().toUpperCase()) == false) {
              toastr.warning("Please enter valid airport name");
            }
            else{


                window.location='result.jsp?customer_from='+$("input[name='customer_from']").val().toUpperCase()+
                  '&customer_to='+$("input[name='customer_to']").val().toUpperCase()+
                  '&customer_date='+document.getElementsByName("customer_date")[0].value+
                  '&customer_returndate='+document.getElementsByName("customer_returndate")[0].value+
                  // '&customer_search='+document.getElementsByName("customer_search")[0].value+
                  '&customer_triptype='+$('input:radio[name="customer_triptype"]:checked').val()+
                  '&customer_cabin='+$('input:radio[name="customer_cabin"]:checked').val()+
                  '&customer_returncabin='+$('input:radio[name="customer_cabin"]:checked').val()+
                  '&customer_timetype='+$('input:radio[name="customer_timetype"]:checked').val()+
                  '&customer_returntimetype='+$('input:radio[name="customer_returntimetype"]:checked').val()+
                  "&seatTypes=&flightNums=";
             }
          });
      });

    </script>
    <script src="toastr/toastr.js"></script>
    <script type="text/javascript">
      toastr.options.positionClass = 'toast-bottom-left';
    </script>
  </body>
</html>
