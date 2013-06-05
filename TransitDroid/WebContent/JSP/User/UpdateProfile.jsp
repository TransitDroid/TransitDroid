<html>
<head>
<!-- <jsp:include page="/JSP/links.jsp"></jsp:include> -->
<title>Transit Droid Account</title>

<script type="text/javascript">
	$('#uploadPhoto').change(function(e) {
		alert('hell');
		var source;
		if (this.files && this.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				source = e.target.result;
				$('.target').attr('src', source);
				$('.jcrop-holder div div img').attr('src', source);
				$('#preview-pane .preview-container img').attr('src', source);
			};

			reader.readAsDataURL(this.files[0]);
			return false;
		}

	});
	/*jQuery(function($){

	 // Create variables (in this scope) to hold the API and image size
	 var jcrop_api,
	 boundx,
	 boundy,

	 // Grab some information about the preview pane
	 $preview = $('#preview-pane'),
	 $pcnt = $('#preview-pane .preview-container'),
	 $pimg = $('#preview-pane .preview-container img'),

	 xsize = $pcnt.width(),
	 ysize = $pcnt.height();
	
	 console.log('init',[xsize,ysize]);
	 $('#target').Jcrop({
	 boxWidth: 50,
	 onChange: updatePreview,
	 onSelect: updatePreview,
	 aspectRatio: xsize / ysize
	 },function(){
	 // Use the API to get the real image size
	 var bounds = this.getBounds();
	 boundx = bounds[0];
	 boundy = bounds[1];
	 // Store the API in the jcrop_api variable
	 jcrop_api = this;

	 // Move the preview into the jcrop container for css positioning
	 $preview.appendTo(jcrop_api.ui.holder);
	 });

	 function updatePreview(c)
	 {
	 if (parseInt(c.w) > 0)
	 {
	 var rx = xsize / c.w;
	 var ry = ysize / c.h;

	 $pimg.css({
	 width: Math.round(rx * boundx) + 'px',
	 height: Math.round(ry * boundy) + 'px',
	 marginLeft: '-' + Math.round(rx * c.x) + 'px',
	 marginTop: '-' + Math.round(ry * c.y) + 'px'
	 });
	 }
	 };

	 });*/
	 function fileSelect(evt) {
		    if (window.File && window.FileReader && window.FileList && window.Blob) {
		        var files = evt.target.files;
		 
		        var result = '';
		        var file;
		        for (var i = 0; file = files[i]; i++) {
		            // if the file is not an image, continue
		            if (!file.type.match('image.*')) {
		                continue;
		            }
		 
		            reader = new FileReader();
		            reader.onload = (function (tFile) {
		                return function (evt) {
		                    var div = document.createElement('div');
		                    div.innerHTML = '<img style="width: 90px;" src="' + evt.target.result + '" />';
		                    document.getElementById('filesInfo').appendChild(div);
		                };
		            }(file));
		            reader.readAsDataURL(file);
		        }
		    } else {
		        alert('The File APIs are not fully supported in this browser.');
		    }
		}
		 
		document.getElementById('filesToUpload').addEventListener('change', fileSelect, false);
</script>

<style type="text/css">

/* Apply these styles only when #preview-pane has
   been placed within the Jcrop widget */
.jcrop-holder #preview-pane {
	display: block;
	position: absolute;
	z-index: 2000;
	top: 10px;
	right: -280px;
	padding: 6px;
	border: 1px rgba(0, 0, 0, .4) solid;
	background-color: white;
	-webkit-border-radius: 6px;
	-moz-border-radius: 6px;
	border-radius: 6px;
	-webkit-box-shadow: 1px 1px 5px 2px rgba(0, 0, 0, 0.2);
	-moz-box-shadow: 1px 1px 5px 2px rgba(0, 0, 0, 0.2);
	box-shadow: 1px 1px 5px 2px rgba(0, 0, 0, 0.2);
}

/* The Javascript code will set the aspect ratio of the crop
   area based on the size of the thumbnail preview,
   specified here */
#preview-pane .preview-container {
	width: 170px;
	height: 170px;
	overflow: hidden;
}
</style>
</head>
<body>
	<div id="container">
		<header>
		<ul id="menu">
			<li><a><img
					src="${ pageContext.request.contextPath }/UI/images/smallTransitDroidWhite.png"
					border="none"></a></li>
		</ul>
		</header>
		<section class="group1">


		<h3>Account Summary</h3>
		<h4>William Smelser</h4>
		<p>William Smelser This is where you put your details.</p>
		<h4>Michael Smelser</h4>
		<p>This is Son 2.</p>
		<h3>Your Profile Photo</h3>
		<div class="row">
			<div class="span12">

				<img
					src="${ pageContext.request.contextPath }/UI/img/Melinda-98-Edit.jpg"
					id="target" alt="[Jcrop Example]" />

				<div id="preview-pane">
					<div class="preview-container">
						<img
							src="${ pageContext.request.contextPath }/UI/img/Melinda-98-Edit.jpg"
							class="jcrop-preview" alt="Preview" />
					</div>
				</div>


				<div class="clearfix"></div>

			</div>
		</div>

<form enctype="multipart/form-data" method="post" action="upload.php">
    <div class="row">
      <label for="fileToUpload">Select Files to Upload</label><br />
      <input type="file" name="filesToUpload[]" id="filesToUpload" multiple="multiple" />
      <output id="filesInfo"></output>
    </div>
    <div class="row">
      <input type="submit" value="Upload" />
    </div>
  </form>
		</section>
		<div id="footer">
			<div class="container">
				<div id="FooterTwo">&copy; 2013 Transit Droid</div>
				<div id="FooterTree">Capstone Team 5</div>
			</div>
		</div>
	</div>
</body>
</html>