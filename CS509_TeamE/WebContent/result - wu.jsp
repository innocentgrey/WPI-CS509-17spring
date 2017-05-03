<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="driver.*" %>

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
    <link rel="stylesheet" href="css/result.css">
    <!-- Custom styles for this template -->

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>


  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
            <label class="navbar-brand color-white" href="index.html">Sorting</label>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="#" id="sortbyprice" name="sortbyprice">By Price</a></li>
            <li><a href="#" id="sortbystops" name="sortbystops">By Stops</a></li>
            <li><a href="#" id="sortbycompanies" name="sortbycompanies">By Companies</a></li>
            <li></li>
          </ul>
        </div>
      </div>
    </nav>


    <div class="" style="height:0px" >
        <div class="div3 border">
          <p>Departure|Arrival</p>
        </div>
        <div class="div4 border">
          <p>Duration</p>
        </div>
        <div class="div5 border">
          <p>Stops</p>
        </div>

    </div>

    <div class="container border">
      <div class="border" style="min-height: 100px">
        <p style="padding:6px min-height: 0px"></p>
      </div>
      <div class="root-content border" id="root" style="height:600px;width:1218px;overflow:auto;overflow-x:hidden;margin-top:0px;">
        <div class="col-sm-7 padding-div" >

        </div>


        <!--add here -->
    <!--    <button type="button" value="golist" onclick="window.location='index.jsp';">abcdefg</button>  -->
        <div class="row flight-div1" >
          <div class="col-sm-7 row-content flight-div2">

            <div class="col-sm-9 padding-p">
              <div class="col-sm-12">
                <div class="col-sm-4">
                  <p>BOS 5:10p-SZX 1:30a</p>
                </div>
                <div class="col-sm-4">
                  <p>20h 20m</p>
                </div>
                <div class="col-sm-4">
                  <p>1</p>
                </div>
              </div>


              <div class="col-sm-12">
                <div class="col-sm-4">
                  <p>SZX 9:35p-BOS 3:10p</p>
                </div>
                <div class="col-sm-4">
                  <p>29h 35m</p>
                </div>
                <div class="col-sm-4">
                  <p>1</p>
                </div>
              </div>
            </div>
            <div class="col-sm-3">
                <p style="font-size:30px"><span class="glyphicon glyphicon-usd" style="font-size: 25px"></span>1,663</p><!--jsonStr[i].totalPrice-->
                <p><a href="#" type="button" class="btn btn-success" id="select1">Select</a></p>
                <ul class="list-unstyled">
                  <li><a id="d" href="#">Flight Details <span class="caret"></span></a></li>
                </ul>
            </div>

            <div id="" style="" class="col-sm-12 flight-div3">
              <div class="col-sm-12">
                <div class="col-sm-3">
                  <p>Flight 7962</p>  <!--jsonStr[i].ticketList[j].number -->
                </div>
                <div class="col-sm-3">
                  <p>departs BOS 4:35p</p>  <!--jsonStr[i].ticketList[j].deTimeString.split(" ")[1] -->
                </div>
                <div class="col-sm-3">
                  <p>arrives PVG 7:15p</p>  <!-- jsonStr[i].ticketList[j].arTimeString.split(" ")[1]-->
                </div>
                <div class="col-sm-3">
                  <p>14h40m</p> <!-- jsonStr[i].ticketList[j].flightTime-->
                </div>
              </div>
            </div>

            <div id="" style="" class="col-sm-12 flight-div3">
              <div class="col-sm-12">
                <div class="col-sm-3">
                  <p>Flight 7962</p>  <!-- -->
                </div>
                <div class="col-sm-3">
                  <p>departs BOS 4:35p</p>  <!-- -->
                </div>
                <div class="col-sm-3">
                  <p>arrives PVG 7:15p</p>  <!-- -->
                </div>
                <div class="col-sm-3">
                  <p>14h40m</p> <!-- -->
                </div>
              </div>
            </div>
        </div>
      </div>

      <div class="row ">
        <div class="col-sm-7" style="border-bottom:2px ridge #999900">
          <p style="padding:8px"></p>
        </div>
      </div>

      <div class="row flight-div1 " >
        <div class="col-sm-7 row-content flight-div2 ">

          <div class="col-sm-9 padding-p">
            <div class="col-sm-12">
              <div class="col-sm-4">
                <p>BOS 5:10p-SZX 1:30a</p>
              </div>
              <div class="col-sm-4">
                <p>20h 20m</p>
              </div>
              <div class="col-sm-4">
                <p>1</p>
              </div>
            </div>


            <div class="col-sm-12">
              <div class="col-sm-4">
                <p>SZX 9:35p-BOS 3:10p</p>
              </div>
              <div class="col-sm-4">
                <p>29h 35m</p>
              </div>
              <div class="col-sm-4">
                <p>1</p>
              </div>
            </div>
          </div>
          <div class="col-sm-3">
              <p style="font-size:30px"><span class="glyphicon glyphicon-usd" style="font-size: 25px"></span>1,663</p>
              <p>
                <button class="btn btn-success" type="button" value="golist" data-toggle="modal" data-target="#successmodal1">Select111</button>
                <div class="modal fade" id="successmodal1" tabindex="-1" role="dialog">
	                <div class="modal-dialog">
		                <div class="modal-content">
			                <div class="modal-header">
				                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times; </button>
				                <h4 class="modal-title">Ticket Concirmation</h4>
                      </div>
			                <div class="modal-body">Are you sure to buy this ticket?</div>
			                <div class="modal-footer">
				                  <button type="button" class="btn btn-default" data-dismiss="modal">No</button>
				                  <button type="button" class="btn btn-primary">Yes</button>
			                </div>
		                </div><!-- /.modal-content -->
	               </div><!-- /.modal -->
               </div>
              </p>
              <ul class="list-unstyled">
                <li><a id=""  href="#">Flight Details <span class="caret"></span></a></li>
              </ul>
          </div>

          <div id="" style="" class="col-sm-12 flight-div3">
            <div class="col-sm-3">
              <p>Flight 7962</p>
            </div>
            <div class="col-sm-3">
              <p>departs BOS 4:35p</p>
            </div>
            <div class="col-sm-3">
              <p>arrives PVG 7:15p</p>
            </div>
            <div class="col-sm-3">
              <p>14h40m</p>
            </div>
          </div>
      </div>
    </div>



      </div>
    </div>





























<!--jsonStr[i].departure + ' ' + jsonStr[i].deTimeString.split(" ")[1] +  ' - ' + jsonStr[i].arrival + ' ' + jsonStr[i].arTimeString.split(" ")[1] -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script language="javascript">

    var triptype = 1;
    <%
      int trtpe = 1;
      if (request.getParameter("customer_triptype").equals("Roundtrip")) {
        trtpe = 2;
      }
    %>
    triptype = <%=trtpe%>;

    //var test2 = "#detail" + i + "_content";
    var jsonStr=    	<%
      DriverManager driverManager=new DriverManager();
      String str  = request.getParameter("customer_date").replace('-', '_');
      String str2 = "";
      String returntype = "";
      if(request.getParameter("customer_triptype").equals("Roundtrip")){

        str2  = request.getParameter("customer_returndate").replace('-', '_');
        returntype = request.getParameter("customer_returntimetype");
      }
    out.println(driverManager.search(request.getParameter("customer_triptype"), request.getParameter("customer_cabin"), request.getParameter("customer_from"),  str, request.getParameter("customer_to"), request.getParameter("customer_timetype"),str2,returntype));
    %>



    $(document).ready(function(){
      if (triptype == 1) {
        createDiv1();
      } else {
        createDiv2();
      }
    });

    function myToggle(obj) {
      var value = obj.id.replace(/[^0-9]/ig,"");
      //alert(value);
      var contentID1 = "detail" + value + "_content";
      var contentID2 = "Detail" + value + "_content";
      var tg = document.getElementById(contentID1);
      var tg2 = document.getElementById(contentID2);
      if (tg.style.display == 'none') {
        tg.style.display = 'inline';
      } else {
        tg.style.display = 'none';
      }

      if (tg2.style.display == 'none') {
        tg2.style.display = 'inline';
      } else {
        tg2.style.display = 'none';
      }
    }

    function myForward() {
      window.location='success.jsp?flight=123&date=456#';
    }

    function createDiv1() {
        var num = jsonStr.length;
        var root = document.getElementById('root');

        for (var i = 0; i < jsonStr.length; i++) {
          var txt_id = "detail" + i + "_tag";
          var txt_content = "detail" + i + "_content";
          var forward_List = "success.jsp?";

          var detail_txt = "";
          var select_txt = "";

          for (var j = 0; j < jsonStr[i].ticketList.length; j++) {
            detail_txt += '<div class="col-sm-12"><div class="col-sm-3"><p>Flight Number ' + jsonStr[i].ticketList[j].number + '</p>' + '</div><div class="col-sm-3"><p>departs ' + jsonStr[i].ticketList[j].departure + ' ' + jsonStr[i].ticketList[j].deTimeString + '</p></div><div class="col-sm-3"><p>arrives ' + jsonStr[i].ticketList[j].arrival + ' ' +
            jsonStr[i].ticketList[j].arTimeString + '</p></div><div class="col-sm-3"><p>' + jsonStr[i].ticketList[j].flightTime + 'minutes' + '</p></div></div>';

            forward_List += "flight" + j + '=' + jsonStr[i].ticketList[j].number + '&' + 'seatType' + j + '=' + jsonStr[i].ticketList[j].seatType;
            if (j != jsonStr[i].ticketList.length - 1) {
              forward_List += '&';
            }
          }
          forward_List += '#';
          //alert(forward_List);


          select_txt += '<button class="btn btn-success" type="button" data-toggle="modal" data-target="#successmodal' + i + '">Select</button><div class="modal fade" id="successmodal' + i + '" tabindex="-1" role="dialog"><div class="modal-dialog"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button><h4 class="modal-title">Ticket Concirmation</h4></div><div class="modal-body">Are you sure to buy this ticket?</div><div class="modal-footer"><button type="button" class="btn btn-default" data-dismiss="modal">No</button><button type="button" class="btn btn-primary"onclick="window.location=&apos;' + forward_List + '&apos;;">Yes</button></div></div></div></div>';



          root.innerHTML = root.innerHTML + '<div class="row flight-div1" ><div class="col-sm-7 row-content flight-div2"><div class="col-sm-9 padding-p"><div class="col-sm-12"><div class="col-sm-4">' +
          '<p>' + jsonStr[i].ticketList[0].departure + ' ' + jsonStr[i].deTimeString.split(" ")[1] +  ' - <br>' + jsonStr[i].ticketList[jsonStr[i].ticketList.length-1].arrival + ' ' + jsonStr[i].arTimeString.split(" ")[1] + '</p>'
          + '</div><div class="col-sm-4"><p>' + jsonStr[i].totalFlightTime + '</div><div class="col-sm-4">  <p>'  + (jsonStr[i].ticketList.length-1) +  '</p></div></div></div>' + '<div class="col-sm-3"><p style="font-size:30px"><span class="glyphicon glyphicon-usd" style="font-size: 25px"></span>' + jsonStr[i].totalPrice.toFixed(1) + '</p><p>' + select_txt + '</p><ul class="list-unstyled">  <li><a id="' + txt_id + '" href="#" onclick="myToggle(this)">Flight Details <span class="caret"></span></a></li>  </ul></div>' + '<div id="' + txt_content + '" style="display:none" class="col-sm-12 flight-div3">' + detail_txt + '</div>'
          + '</div></div>' + '<div class="row "><div class="col-sm-7" style="border-bottom:2px ridge #999900"><p style="padding:8px"></p></div></div>'
        }
    }

    function createDiv2() {
        var len = 10;
        if (jsonStr.length < len) {
          len = jsonStr.length;
        }
        var num = jsonStr.length;
        var root = document.getElementById('root');


        for (var i = 0; i < len; i++) {
          var txt_id = "detail" + i + "_tag";
          var txt_content = "detail" + i + "_content";
          var txt_content2 = "Detail" + i + "_content";
          var forward_List = "success.jsp?";
          var select_txt = "";
          var detail_txt = "";
          var detail_txt2 = "";

          for (var j = 0; j < jsonStr[i].outboundTickets.ticketList.length; j++) {

            detail_txt += '<div class="col-sm-12"><div class="col-sm-3"><p>Flight Number ' + jsonStr[i].outboundTickets.ticketList[j].number + '</p>' + '</div><div class="col-sm-3"><p>departs ' + jsonStr[i].outboundTickets.ticketList[j].departure + ' ' + jsonStr[i].outboundTickets.ticketList[j].deTimeString + '</p></div><div class="col-sm-3"><p>arrives ' + jsonStr[i].outboundTickets.ticketList[j].arrival + ' ' +
            jsonStr[i].outboundTickets.ticketList[j].arTimeString + '</p></div><div class="col-sm-3"><p>' + jsonStr[i].outboundTickets.ticketList[j].flightTime + 'minutes' + '</p></div></div>';

            forward_List += "flight" + j + '=' + jsonStr[i].outboundTickets.ticketList[j].number + '&' + 'seatType' + j + '=' + jsonStr[i].outboundTickets.ticketList[j].seatType;

            forward_List += '&';

          }

          for (var j = 0; j < jsonStr[i].returnTickets.ticketList.length; j++) {

            detail_txt2 += '<div class="col-sm-12"><div class="col-sm-3"><p>Flight Number ' + jsonStr[i].returnTickets.ticketList[j].number + '</p>' + '</div><div class="col-sm-3"><p>departs ' + jsonStr[i].returnTickets.ticketList[j].departure + ' ' + jsonStr[i].returnTickets.ticketList[j].deTimeString + '</p></div><div class="col-sm-3"><p>arrives ' + jsonStr[i].returnTickets.ticketList[j].arrival + ' ' +
            jsonStr[i].returnTickets.ticketList[j].arTimeString + '</p></div><div class="col-sm-3"><p>' + jsonStr[i].returnTickets.ticketList[j].flightTime + 'minutes' + '</p></div></div>';

            forward_List += "flight" + j + '=' + jsonStr[i].returnTickets.ticketList[j].number + '&' + 'seatType' + j + '=' + jsonStr[i].returnTickets.ticketList[j].seatType;
            if (j != jsonStr[i].returnTickets.ticketList.length - 1) {
              forward_List += '&';
            }
          }

          forward_List += '#';
          //alert(forward_List);


          select_txt += '<button class="btn btn-success" type="button" data-toggle="modal" data-target="#successmodal' + i + '">Select</button><div class="modal fade" id="successmodal' + i + '" tabindex="-1" role="dialog"><div class="modal-dialog"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button><h4 class="modal-title">Ticket Concirmation</h4></div><div class="modal-body">Are you sure to buy this ticket?</div><div class="modal-footer"><button type="button" class="btn btn-default" data-dismiss="modal">No</button><button type="button" class="btn btn-primary"onclick="window.location=&apos;' + forward_List + '&apos;;">Yes</button></div></div></div></div>';

          root.innerHTML = root.innerHTML + '<div class="row flight-div1" ><div class="col-sm-7 row-content flight-div2"><div class="col-sm-9 padding-p"><div class="col-sm-12"><div class="col-sm-4">' +
          '<p>' + jsonStr[i].outboundTickets.ticketList[0].departure + ' ' + jsonStr[i].outboundTickets.deTimeString.split(" ")[1] +  ' - <br>' + jsonStr[i].outboundTickets.ticketList[jsonStr[i].outboundTickets.ticketList.length-1].arrival + ' ' + jsonStr[i].outboundTickets.arTimeString.split(" ")[1] + '</p>'
          + '</div><div class="col-sm-4"><p>' + jsonStr[i].outboundTickets.totalFlightTime + '</p></div><div class="col-sm-4">  <p>'  + (jsonStr[i].outboundTickets.ticketList.length-1) +  '</p></div></div>' + '<div class="col-sm-12"><div class="col-sm-4"><p>' + jsonStr[i].returnTickets.ticketList[0].departure + ' ' + jsonStr[i].returnTickets.deTimeString.split(" ")[1] + ' - <br>' +
           jsonStr[i].returnTickets.ticketList[jsonStr[i].returnTickets.ticketList.length-1].arrival + ' ' + jsonStr[i].returnTickets.arTimeString.split(" ")[1] + '</p>' + '</div><div class="col-sm-4"><p>' + jsonStr[i].returnTickets.totalFlightTime + '</p></div><div class="col-sm-4"><p>' + (jsonStr[i].returnTickets.ticketList.length-1) + '</p></div></div>' + '</div>' + '<div class="col-sm-3"><p style="font-size:30px"><span class="glyphicon glyphicon-usd" style="font-size: 25px"></span>' + jsonStr[i].roundTripTotalPrice.toFixed(1) + '</p><p>' + select_txt + '</p><ul class="list-unstyled">  <li><a id="' + txt_id + '" href="#" onclick="myToggle(this);">Flight Details <span class="caret"></span></a></li>  </ul></div>' + '<div id="' + txt_content + '" style="display:none" class="col-sm-12 flight-div3">' + detail_txt + '</div>' + '<div id="' + txt_content2 + '" style="display:none" class="col-sm-12 flight-div3">' + detail_txt2 + '</div>'
         + '</div></div>' + '<div class="row "><div class="col-sm-7" style="border-bottom:2px ridge #999900"><p style="padding:8px"></p></div></div>';



/*
            + '<div class="col-sm-3"><p style="font-size:30px"><span class="glyphicon glyphicon-usd" style="font-size: 25px"></span>' + jsonStr[i].roundTripTotalPrice.toFixed(1) + '</p><p>' + select_txt + '</p><ul class="list-unstyled">  <li><a id="' + txt_id + '" href="#" onclick="myToggle(this)">Flight Details <span class="caret"></span></a></li>  </ul></div>' + '<div id="' + txt_content + '" style="display:none" class="col-sm-12 flight-div3">' + detail_txt + '</div>'
          + '</div></div>' + '<div class="row "><div class="col-sm-7" style="border-bottom:2px ridge #999900"><p style="padding:8px"></p></div></div>'
        }
*/


    }
  }


</script>
  </body>
</html>
