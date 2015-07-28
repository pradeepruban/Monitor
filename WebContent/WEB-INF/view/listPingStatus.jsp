<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en"><head>
  <meta charset="utf-8">
  <title>Workflow Manager-List Workflow</title>
  <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
  <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
  <link rel="stylesheet" href="lib/bootstrap/css/jquery.dataTables.css">
  <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
   
   <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .navbar-default .navbar-brand, .navbar-default .navbar-brand:hover { 
            color: #fff;
        }
    </style>
 
   <script src="lib/jquery-1.11.1.min.js" type="text/javascript"></script>
   <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script src="lib/bootstrap/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
	 $table = $('#example');
	    // DataTable
	    var table = $('#example').DataTable(
		
		{
			 "bSort": true,
		    "sScrollY": "450px"
	      }
      ); 
	});
	
	
	$(document).ready(function() {
		 $table1 = $('#example1');
		    // DataTable
		    var table1 = $('#example1').DataTable(
			
			{
				 "bSort": true,
			    "sScrollY": "450px"
		      }
	      ); 
		});
	
	
	</script>
</head>

<body class=" theme-blue">

<form name="listForm">
<%@ include file="/includes/header.jsp"%>
    
  <div class="content">
        <div class="header">
            <h1 class="page-title">List Ping Status</h1>
               <ul class="breadcrumb">
                 <li><a href="#">Home</a> </li>
                 <li class="active">List Ping Status</li>
              </ul>
        </div>
     <div class="main-content">  
<div class="row">
 <div class="col-xs-6">

		<table  id="example"  class="display"  >
	      <thead>
            <tr style="background: -moz-linear-gradient(center bottom , rgba(172, 185, 212, 1) 0%, #6F80A1 100%) repeat scroll 0% 0% transparent;">
                <th>URL</th>
                <th>Status</th>
            </tr>
        </thead>
       <tbody>
       <c:forEach items="${pingList}" var="ping">
         <tr >
		 <td style="padding-left: 10px;">${ping.url}</td>
		 
		 <c:set var="status" value="${ping.status}"/> 
		 <td style="padding-left: 30px;">
	<c:choose>
    <c:when test="${ status=='green'}">
      <span class=""> <img src='images/green_tick.jpeg' height='20px' width='20px'/>   </span>
    </c:when>
    <c:when test="${ status=='red'}">
      <span class=""> <img src='images/remove_icon2.jpg' height='15px' width='15px'/> </span>
    </c:when>
    <c:otherwise>
        <span class="">${ping.status}</span>
    </c:otherwise>
   </c:choose>	 
    </td>

 </tr>
	</c:forEach>
   </tbody>
 </table>
 
 </div>
 
 
  <div class="col-xs-6">

		<table  id="example1"  class="display"  >
	      <thead>
            <tr style="background: -moz-linear-gradient(center bottom , rgba(172, 185, 212, 1) 0%, #6F80A1 100%) repeat scroll 0% 0% transparent;">
                <th>Application Name</th>
                <th>IPAddress</th>
                <th>PortNo</th>
                <th>Status</th>
            </tr>
        </thead>
       <tbody>
       <c:forEach items="${telnetList}" var="telnet">
         <tr >
         <td style="padding-left: 10px;">${telnet.appName}</td>
		 <td style="padding-left: 10px;">${telnet.ipAddress}</td>
		 <td style="padding-left: 10px;">${telnet.port}</td>
		 <c:set var="status" value="${telnet.status}"/> 
		 <td style="padding-left: 30px;">
	<c:choose>
    <c:when test="${ status=='green'}">
      <span class=""> <img src='images/green_tick.jpeg' height='20px' width='20px'/>   </span>
    </c:when>
   
    <c:otherwise>
        <span class=""> <img src='images/remove_icon2.jpg' height='15px' width='15px'/> </span>
    </c:otherwise>
   </c:choose>	 
    </td>

 </tr>
	</c:forEach>
   </tbody>
 </table>
 
 </div>
 </div>
 
 
     <footer style="padding-top:180px;"> 
      <hr>
        <p style="color:black;float:center;"> © 1998-2014 Syntel, Inc. | all rights reserved</p>
     </footer>
  </div>
</div>
</form>


</body>
</html>
