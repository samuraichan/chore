$(document).ready(function() {
	
	// bootstrap tooltip init
	$('[data-toggle="tooltip"]').tooltip(); 
	
	$.fn.dataTable.ext.errMode = 'none';
	
    var table = $('#pagination').DataTable( {
        "processing": true,
        "serverSide": true,
        "searching":   true,
        "ajax": {
          "url": "/starter/summary",
          "type": "POST",
          
          "data": function (d) {
            return $.extend( {}, d, {
              "searchFilter.statusId": $('#status option:selected').val(),
              "searchFilter.startDate": $('#startDate').val(),
              "searchFilter.endDate": $('#endDate').val(),
              "search": $('#mySearch').val()
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
    
    $('#btn').on('click', function() {
      table.draw();
    });
} );

