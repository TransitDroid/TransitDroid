<!DOCTYPE html>
<html>
<head>
<title>Upload Photo</title>
<meta http-equiv="Content-type" content="text/html;charset=UTF-8" />

<script src="${ pageContext.request.contextPath }/JS/jquery.js"></script>
<script src="${ pageContext.request.contextPath }/JS/jquery.Jcrop.js"></script>
<script type="text/javascript">
/*
	var jcrop_api;
	function init() {
		jQuery(function($) {
			
			// Create variables (in this scope) to hold the API and image size
			var boundx, boundy,

			// Grab some information about the preview pane
			$preview = $('#preview-pane'), $pcnt = $('#preview-pane .preview-container'), $pimg = $('#preview-pane .preview-container img'),

			xsize = $pcnt.width(), ysize = $pcnt.height();

			console.log('init', [ xsize, ysize ]);

			$('#target').Jcrop({
				onChange : updatePreview,
				onSelect : updatePreview,
				aspectRatio : xsize / ysize
			}, function() {
				// Use the API to get the real image size
				var bounds = this.getBounds();
				boundx = bounds[0];
				boundy = bounds[1];
				// Store the API in the jcrop_api variable
				jcrop_api = this;

				// Move the preview into the jcrop container for css positioning
				$preview.appendTo(jcrop_api.ui.holder);
			});
			
			function updatePreview(c) {
				if (parseInt(c.w) > 0) {
					var rx = xsize / c.w;
					var ry = ysize / c.h;

					$pimg.css({
						width : Math.round(rx * boundx) + 'px',
						height : Math.round(ry * boundy) + 'px',
						marginLeft : '-' + Math.round(rx * c.x) + 'px',
						marginTop : '-' + Math.round(ry * c.y) + 'px'
					});
				}
				$('#x').val(c.x);
				$('#y').val(c.y);
				$('#w').val(c.w);
				$('#h').val(c.h);
			}
		});

	}
    $('#uploadPhoto').change(function(e){
    	var source;
		if (this.files && this.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				source = e.target.result;
				$('.target').attr('src', source);
				$('.jcrop-holder div div img').attr('src', source);
				$('#preview-pane .preview-container img').attr('src', source);
				jcrop_api = null;
				init();
			};
			
			reader.readAsDataURL(this.files[0]);
			return false;
		}
    });	


	function checkCoords() {
		if (parseInt($('#w').val())){
			alert($('#w').val());
			return true;
		}
		alert('Please select a crop region then press submit.');
		return false;
	}
*/
/*
$('#uploadPhoto').change(function(e){
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


function checkCoords() {
	if (parseInt($('#w').val())){
		alert($('#w').val());
		return true;
	}
	alert('Please select a crop region then press submit.');
	return false;
}
*/
init(){
jQuery(function($){

    // The variable jcrop_api will hold a reference to the
    // Jcrop API once Jcrop is instantiated.
    var jcrop_api;

    // In this example, since Jcrop may be attached or detached
    // at the whim of the user, I've wrapped the call into a function
    initJcrop();
    
    // The function is pretty simple
    function initJcrop()// {{{
    {


      // Invoke Jcrop in typical fashion
      var $pcnt = $('#preview-pane .preview-container');
      xsize = $pcnt.width(), ysize = $pcnt.height();
      $('#target').Jcrop({
			onChange : updatePreview,
			onSelect : updatePreview,
			onRelease: releaseCheck,
			aspectRatio : xsize/ysize
      	},function(){
    	  // Use the API to get the real image size
    	  var bounds = this.getBounds();
    	  boundx = bounds[0];
    	  boundy = bounds[1];
			
    	  jcrop_api = this;
    	  jcrop_api.animateTo([100,100,400,400]);

    	  // Move the preview into the jcrop container for css positioning
    	  $preview.appendTo(jcrop_api.ui.holder);
      });

    }
    
	function updatePreview(c) {
		if (parseInt(c.w) > 0) {
			var rx = xsize / c.w;
			var ry = ysize / c.h;

			$pimg.css({
				width : Math.round(rx * boundx) + 'px',
				height : Math.round(ry * boundy) + 'px',
				marginLeft : '-' + Math.round(rx * c.x) + 'px',
				marginTop : '-' + Math.round(ry * c.y) + 'px'
			});
		}
		$('#x').val(c.x);
		$('#y').val(c.y);
		$('#w').val(c.w);
		$('#h').val(c.h);
	}
 
    function getImageSize() {
    	var bounds = jcrop_api.getBounds();
  	  	boundx = bounds[0];
  	  	boundy = bounds[1];
      }
      

});
    }	 
  $('#uploadPhoto').change(function(e){
	  	var source;
			if (this.files && this.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					source = e.target.result;
					$('.target').attr('src', source);
					$('.jcrop-holder div div img').attr('src', source);
					$('#preview-pane .preview-container img').attr('src', source);
					$('#target').Jcrop({
						onChange : updatePreview,
						onSelect : updatePreview,
						onRelease: releaseCheck,
						aspectRatio : xsize/ysize
			      	},function(){
			    	  // Use the API to get the real image size
			    	  var bounds = this.getBounds();
			    	  boundx = bounds[0];
			    	  boundy = bounds[1];
						
			    	  jcrop_api = this;
			    	  jcrop_api.animateTo([100,100,400,400]);

			    	  // Move the preview into the jcrop container for css positioning
			    	  $preview.appendTo(jcrop_api.ui.holder);
			      });
					init();
				};
				
				reader.readAsDataURL(this.files[0]);
				return false;
			}
		      
		  	function updatePreview(c) {
				if (parseInt(c.w) > 0) {
					var rx = xsize / c.w;
					var ry = ysize / c.h;

					$pimg.css({
						width : Math.round(rx * boundx) + 'px',
						height : Math.round(ry * boundy) + 'px',
						marginLeft : '-' + Math.round(rx * c.x) + 'px',
						marginTop : '-' + Math.round(ry * c.y) + 'px'
					});
				}
				$('#x').val(c.x);
				$('#y').val(c.y);
				$('#w').val(c.w);
				$('#h').val(c.h);
			}
	  });
  function checkCoords() {
		if (parseInt($('#w').val())){
			alert($('#w').val());
			return true;
		}
		alert('Please select a crop region then press submit.');
		return false;
	}
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
<body onload='init()'>

	<div class="container">
		<div class="row">
			<div class="span12">
				<div class="jc-demo-box">

					<div class="page-header">
						<h1>Upload Profile Photo</h1>
					</div>
					<input id='uploadPhoto' type='file'/> 
					<img src="${ pageContext.request.contextPath }/UI/jcrop_files/pool.jpg"
						id="target" class="target" alt="[Jcrop Example]" />
					<div id="preview-pane">
						<div class="preview-container">
							<img class="preview"
								src="${ pageContext.request.contextPath }/UI/jcrop_files/pool.jpg"
								class="jcrop-preview" alt="Preview" />
						</div>
					</div>

					<div class="description">
						<p>
						<form action="crop.php" method="post"
							onsubmit="return checkCoords();">
							<input type="hidden" id="x" name="x" /> <input type="hidden"
								id="y" name="y" /> <input type="hidden" id="w" name="w" /> <input
								type="hidden" id="h" name="h" /> <input type="submit"
								value="Crop Image" class="btn btn-large btn-inverse" />
						</form>
						</p>


					</div>

					<div class="clearfix"></div>

				</div>
			</div>
		</div>
	</div>

</body>
</html>

