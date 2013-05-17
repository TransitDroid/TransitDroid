var user;
var userCookie = 'transitdroid';

function getAction(url, handler) {
	$.ajax({
		type : "GET",
		url : url,
		dataType : "json",
		success : function(data) {
			handler(data);
		},
		failure : function() {
			alert("It Failed");
		}
	});
}

function postAction(url, content, handler) {
	$.ajax({
		type : "POST",
		data : content,
		cache : false,
		contentType : "application/json",
		dataType : "json",
		url : url,
		success : function(data) {
			handler(data);
		},
		failure : function(errMsg) {
			alert(errMsg);
		}
	});
}
function logout() {
	deleteCookie(userCookie);
}

function upload(){
	$('.holder_content').load('/TransitDroid/JSP/User/UploadPhoto.jsp');
	//loadJcrop();
}
function fileSelected() {
	  var file = document.getElementById('fileToUpload').files[0];
	  var path = $("#fileToUpload").files[0];
	  if (file) {
	    var fileSize = 0;
	    if (file.size > 1024 * 1024)
	      fileSize = (Math.round(file.size * 100 / (1024 * 1024)) / 100).toString() + 'MB';
	    else
	      fileSize = (Math.round(file.size * 100 / 1024) / 100).toString() + 'KB';
	          
//	    document.getElementById('fileName').innerHTML = 'Name: ' + file.name;
//	    document.getElementById('fileSize').innerHTML = 'Size: ' + fileSize;
//	    document.getElementById('fileType').innerHTML = 'Type: ' + file.type;
	  }
	  alert(path.name);
//	  $("#preview-image").attr("src", path);
//	  $("#preview").attr("src", path);
}

function login() {
	var username = $('#username').val();
	var password = $('#password').val();
	var data = '{"username":"'+username+'","password":"'+password+'"}';

	postAction('/TransitDroid/rest/account/login/', data, function(output) {
		if (output["succeed"] == "true"){
			user = output["user"];
			setCookie(userCookie, user, 30);
			load();
			hideOverlay();
			
		}else{
			alert('Sorry! Wrong username or password. Please try again');
			hideOverlay();
		}
	}); 
	return false;

}

function processTransaction() {
	var data = '{"keys":[{"key":"C3f7T/i7GRqztMs7H5T3WA==","key":"pOBOuItsYTeztMs7H5T3WA==","key":"1RvIpy9yUhSztMs7H5T3WA==","key":"afpjsZ7OHc6ztMs7H5T3WA=="}], "passcode":"6drWsIyUnrk=","phoneMac":"784930214321"}';
	postAction('/TransitDroid/rest/transaction/process/', data, function(
			output) {
		hideOverlay();
		return false;
	});
}
function createUser() {
	var firstName = $('#firstName').val();
	var lastName = $('#lastName').val();
	var username = $('#createUserUsername').val();
	var password = $('#createUserPassword').val();
	
	var data = '{"roles":[{"role":"user", "role":"account_manager"}], "firstName":"'+firstName+'", '
			+ '"lastName":"'+lastName+'", "username":"'+username+'", "password":"'+password+'"}';
	postAction('/TransitDroid/rest/account/user/create/', data, function(
			output) {
		var result = "Welcome " + output["user"]["firstName"] + " "
				+ output["user"]["lastName"] + "!";
		setCookie(userCookie, output["user"], 30);
		load();
		alert(result);
		
	});
	hideOverlay();
	return false;
}

function UpdateUser(){
	var firstName = $('firstName').val();
	var lastName = $('lastName').val();
	var username = $('createUserUsername').val();
	var password = $('createUserPassword').val();
	var data = '{"roles":[{"role":"user", "role":"account_manager"}], "id":"'+user[id]+'", "firstName":"'+firstName+'", '
			+ '"lastName":"'+lastName+'", "username":"'+username+'", "password":"'+password+'"}';
	postAction('/TransitDroid/rest/account/user/update/', data, function(
			output) {
		var result = "Hello " + output["user"]["firstName"] + " "
				+ output["user"]["lastName"] + "!";
		alert(result);
	});
	hideOverlay();
	return false;
}

//For testing purposes
function purchaseSinglePass() {

	var data = '{"mobileDeviceMAC":"784930214321","version":"5","quantity":"5","date":"2013-03-27T09:00:00"}';
	postAction('/TransitDroid/rest/purchase/single/', data,
			function(output) {
				alert(output['succeed']);
			});
	hideOverlay();
	return false;
}

function purchaseMonthlyPass() {

	var data = '{"mobileDeviceMAC":"784930214321","version":"1","month":"3","year":"2013"}';
	postAction('/TransitDroid/rest/purchase/monthly/', data,
			function(output) {
				alert(output['succeed']);
			});
	hideOverlay();
	return false;

}

function purchaseYearlyPass() {
	var data = '{"mobileDeviceMAC":"784930214321","version":"5","date":"2013-03-27T09:00:00"}';
	postAction('/TransitDroid/rest/purchase/yearly/', data,
			function(output) {
				alert(output['succeed']);
			});
	hideOverlay();
	return false;
}

function purchaseNightlyPass() {

	var data = '{"mobileDeviceMAC":"784930214321","version":"5","date":"2013-03-27T09:00:00"}';
	postAction('/TransitDroid/rest/purchase/nightly/', data,
			function(output) {
				alert(output['succeed']);
			});
	hideOverlay();
	return false;
}

function purchaseThreeDayPass() {
	var data = '{"mobileDeviceMAC":"784930214321","version":"5","date":"2013-03-27T09:00:00"}';
	postAction('/TransitDroid/rest/purchase/threeday/', data, function(
			output) {
		alert(output['succeed']);
	});
	hideOverlay();
	return false;
}

function purchaseWeeklyPass() {
	var data = '{"mobileDeviceMAC":"784930214321","version":"5","date":"2013-03-27T09:00:00"}';
	postAction('/TransitDroid/rest/purchase/single/', data,
			function(output) {
				alert(output['succeed']);
			});
	hideOverlay();
	return false;
}

function registerDevice() {
	var data = '{"mobileDeviceMAC":"784930214321", "username":"wsmelser", "password":"smelser"}';
	postAction('/TransitDroid/rest/account/device/register/', data,
			function(output) {
				alert(output['succeed']);
			});

	hideOverlay();
	return false;
}
// end of test functions
function hideOverlay() {
	$('#overlay').hide();
	$('#exposeMask').hide();
}

function load(){
	var user = getCookie(userCookie);
	if (user != null){
		$("#user").attr("src", "UI/img/Melinda-98-Edit.jpg");
		$('#hidden_links').css('visibility', 'visible');
		$("#setting").css('visibility', 'visible');
		$('#userName').text(user['firstName']+' '+user['lastName']);
		$('#loginListItem').load('loggedInMenu.jsp');
		$('.holder_content').load('loggedInContent.jsp');
		$('.holder_content').load('loggedInContent.jsp',function(){
			$('#accountHeader').append(user['firstName']+'!'),
			$('#singlePass').append("3"),
			$('#monthlyPass').append("false");
			
		});
		
	}
	
}

function setCookie(c_name,value,exdays)
{
var exdate=new Date();
exdate.setDate(exdate.getDate() + exdays);
var c_value=escape(JSON.stringify(value)) + ((exdays==null) ? "" : "; expires="+exdate.toUTCString());
document.cookie=c_name + "=" + c_value;
}


function getCookie(c_name)
{
var i,x,y,ARRcookies=document.cookie.split(";");
for (i=0;i<ARRcookies.length;i++)
{
  x=ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
  y=ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
  x=x.replace(/^\s+|\s+$/g,"");
  if (x==c_name)
    {
    return JSON.parse(unescape(y));
    }
  }
}

function deleteCookie(name) {
	setCookie(name, null, 0);
}


function loadScript(url)
{
    // adding the script tag to the head as suggested before
   var head = document.getElementsByTagName('head')[0];
   var script = document.createElement('script');
   script.type = 'text/javascript';
   script.src = url;

   // fire the loading
   head.appendChild(script);
}