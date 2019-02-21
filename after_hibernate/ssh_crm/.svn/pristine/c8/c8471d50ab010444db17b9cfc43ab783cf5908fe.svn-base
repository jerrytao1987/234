function loadSelect(typecode,positionId,selectname,selectedId){
		/*var $select = $("<select name='"+selectname+"'></select>");
		$select.append($("<option value ='' >---请选择---</option>"));*/
		var select = "<select name='"+selectname+"'>";
		select += "<option value ='' >---请选择---</option>";
		/*$.post(
				"${pageContext.request.contextPath}/BaseDictAction", 
				{ dict_type_code: typecode },
				function(data){
						$.each( data, function(i, n){
							//var $option = $("<option value='"+n["dict_id"]+"'>"+n["dict_item_name"]+"</option>")
							//if(n["dict_id"]==selectedId){
							//	$option.attr("selected","selected");
							//}
						  	//$select.append($option);
							if(n["dict_id"]==selectedId){
								select += "<option value='"+n["dict_id"]+"' selected='selected' >"+n["dict_item_name"]+"</option>";
							}else{
								select += "<option value='"+n["dict_id"]+"'>"+n["dict_item_name"]+"</option>";
							}
						});
				},
				"json"
		);*/
		$.ajax({
			type:"POST",
			async:false,
			url:"${pageContext.request.contextPath}/BaseDictAction",
			data:{ dict_type_code: typecode },
			success:
				function(data){
					$.each( data, function(i, n){
						//var $option = $("<option value='"+n["dict_id"]+"'>"+n["dict_item_name"]+"</option>")
						//if(n["dict_id"]==selectedId){
						//	$option.attr("selected","selected");
						//}
					  	//$select.append($option);
						if(n["dict_id"]==selectedId){
							select += "<option value='"+n["dict_id"]+"' selected='selected' >"+n["dict_item_name"]+"</option>";
						}else{
							select += "<option value='"+n["dict_id"]+"'>"+n["dict_item_name"]+"</option>";
						}
					});
				},
			dataType:"json"
		});
		select += "</select>";
		/*$("#"+positionId).append($select);*/
		$("#"+positionId).append(select);
	}