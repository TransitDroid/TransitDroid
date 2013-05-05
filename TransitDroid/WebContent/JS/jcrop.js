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
	  });
  
