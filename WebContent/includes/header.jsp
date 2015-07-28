
	 <script> 
		function autoRefresh_div()
   		{
		 	$("#RefreshGroupdiv").load("./groupCount");
		 	$("#RefreshWorkflowdiv").load("./workflowCount");
			$("#RefreshEventdiv").load("./eventCount");
			$("#RefreshServicediv").load("./serviceCount");
		 	
		}
 		setInterval('autoRefresh_div()',3000);
	</script> 

<div class="navbar navbar-default" role="navigation"  >
	<div class="navbar-header">
    	<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
        	<span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
   		<a class="" href="#"><span class="navbar-brand"><span class="fa fa-paper-plane"></span> WorkFlow Monitor</span></a>
   	</div>
	<div class="navbar-collapse collapse" style="height: 1px;">
		<ul id="main-menu" class="nav navbar-nav navbar-right">
       		<li class="dropdown hidden-xs">
        		<a href="#" class="dropdown-toggle" data-toggle="dropdown">
        		<span class="glyphicon glyphicon-user padding-right-small" style="position:relative;top: 3px;"></span> Kalyan Raju
        		<i class="fa fa-caret-down"></i> </a>
            	<ul class="dropdown-menu">
              	 	<li><a href="#">My Account</a></li>
               	 	<li class="divider"></li>
               	 	<li><a tabindex="-1" href="./logout">Logout</a></li>
            	</ul>  
            </li>
		</ul>
	</div>
</div>

<div class="sidebar-nav">
   		<ul>
    		<li><a href="#" data-target=".dashboard-menu"   class="nav-header" data-toggle="collapse"><i class="fa fa-fw fa-dashboard"></i> Dashboard</a></li>
  </ul>
</div>
