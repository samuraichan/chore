$(document).ready(function() {
	
	var dude = function(field) {
      var targets = [];
      $.each(field, function(){
    	targets.push($(this).val());
      });
      return targets.join(",");
    };
	
	// bootstrap tooltip init
	$('[data-toggle="tooltip"]').tooltip(); 
	
	// date picker init
	$('.date-picker').datepicker({
	  orientation: "bottom auto"
	});
	
	$.fn.dataTable.ext.errMode = 'none';
	
    var table = $('#pagination').DataTable( {
        "processing": true,
        "serverSide": true,
        "searching": false,
        "ajax": {
          "url": "/starter/summary",
          "type": "POST",
          
          "data": function (d) {
            return $.extend( {}, d, {
              "pagingFilter.start": $('input[name="pagingFilter.start"].visible').val(),
              "pagingFilter.end": $('input[name="pagingFilter.end"].visible').val(),
              "pagingFilter.statuses": dude($('.filter-st:visible').find('option:selected')),
              "pagingFilter.categories": dude($('.filter-cat:visible').find('option:selected'))
            });
          },
          "dataSrc": function ( json ) {
              // alert('you again');  // override this to see what results are in json, i will want to use jsonFormResponse and see how it goes, https://datatables.net/reference/option/ajax.dataSrc
              return json.data;
            }
        },
        "order": [[ 0, "desc" ]],
        "columns": [
          { data: 'choreDateDisplay'},
          { data: 'category'},
          { data: 'amount'},
          { data: 'status'}
        ],
        "createdRow": function(row, data, dataIndex ) {
	       $(row).addClass(data.status);
	    }
    }).on( 'error.dt', function (e, settings, techNote, message ) { // triggered when response is NOT of 2XX
    	alert(message);
        //console.log( 'An error has been reported by DataTables: ', message );
    } );
    
    $('.btn-filter:first').on('click', function() {
      table.draw();
    });
    
    $('.glyphicon-remove-circle').click(function() {
  	  $('.filter-btn').click();
  	  $('.selectpicker').selectpicker('deselectAll');
  	  $('.date-picker').datepicker('clearDates');
  	  $('.btn-filter').click();
  	});
    
    $('#form').on('submit', function(e) {
      e.preventDefault();
      var url = $(this).attr('action');
      var data = {}
      
      $(this).find('input,select,textarea').each(function() {
        data[$(this).attr('name')] = ($(this).is(':input[type="checkbox"]') ? $(this).is(':checked') : $(this).val()); 
      });
      
  	  $.ajax({
  		type : "POST",
  		contentType : "application/json",
  		url : url,
  		data : JSON.stringify(data),
  		dataType : 'json',
  		timeout : 100000,
  		success : function(data) {
  		  if (data.errors) {
  			var errorList = $('#errorList');
  		    errorList.find('li').remove();
  		    
            $.each(data.errors, function(key,value){
              $.each(value, function(index,msg) {
                errorList.append('<li>' + msg + '</li>');
              });
            });
  		    
  		    errorList.toggle(true);
  		  }
  		  else {
  	        $('.add-btn').trigger('click');
  	        table.draw();
  	        $.growl.notice({ message: "The kitten is cute!" });
  		  }
  		},
  		error : function(e) {
  			console.log("ERROR: ", e);
  			
  		},
  		done : function(e) {
  			console.log("DONE");
  		}
  	  });
    });
} );

