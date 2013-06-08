var ofc = function() {
	return {
		rasterize : function(src, dst) {
			document.getElementById(dst).appendChild(ofc.image(src));
		},
		image : function(src) {
			var objE = document.createElement("div");
			objE.innerHTML = "<img src='data:image/png;base64,"
					+ document.getElementById(src).get_img_binary() + "' />";
			return objE.firstChild;
		},
		saveimage : function(src, url, paramname, otherParams, callback) {
			var imageData = document.getElementById(src).get_img_binary();
			var localParams = otherParams ? otherParams : {};
			localParams[paramname] = imageData;
			var settings = {
				type : "POST",
				url : url,
				data:localParams,
				error : function(XHR, textStatus, errorThrown) {
					callback.call(XHR, textStatus);
				},
				success : function(data, textStatus) {
					callback.call(data, textStatus);
				},
				headers : {
					"Content-Type" : "application/x-www-form-urlencoded"
				}
			};
			$.ajax(settings);
		},
	};
}();
