<!DOCTYPE html>
<html lang="en">
<head>
  <title>Aspect Ratio with Preview Pane | Jcrop Demo</title>
  <meta http-equiv="Content-type" content="text/html;charset=UTF-8" />

<script type="text/javascript" src="${ pageContext.request.contextPath }/JS/jquery.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/JS/jquery.Jcrop.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/JS/jquery.js"></script>

<script type="text/javascript">
  jQuery(function($){

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

  });


</script>
<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/UI/form.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/UI/jcrop_files/demos.css" type="text/css" />
<link rel="stylesheet" href="${ pageContext.request.contextPath }/UI/jcrop/jquery.Jcrop.css" type="text/css" />
<link rel="stylesheet" href="demo_files/main.css" type="text/css" />
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
  border: 1px rgba(0,0,0,.4) solid;
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

	<div class="container">
		<div class="row">
			<div class="span12">

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

</body>
</html>

