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
              "pagingFilter.start": $('input[name="pagingFilter.start"]').val(),
              "pagingFilter.end": $('input[name="pagingFilter.end"]').val(),
              "pagingFilter.statuses": dude($('.selectpicker').first().find('option:selected')),
              "pagingFilter.categories": dude($('.cat-dropdown').find('option:selected'))
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
    
    $('.btn-filter').on('click', function() {
      table.draw();
    });
    
    $('.glyphicon-remove-circle').click(function() {
  	  $('.filter-btn').click();
  	  $('.selectpicker').selectpicker('deselectAll');
  	  $('.date-picker').datepicker('clearDates');
  	  $('.btn-filter').click();
  	});
} );

