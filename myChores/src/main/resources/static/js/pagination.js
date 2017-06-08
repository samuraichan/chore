$(document).ready(function() {
	
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
        "columns": [
          { data: 'choreDateDisplay'},
          { data: 'category'},
          { data: 'amount'},
          { data: 'notified'},
          { data: 'paid'}
        ],
        'columnDefs' : [{ // allow columns 1 and 2 to be displayed as HTML elements and not just straight up string values
        	"targets": 4,
        	"searchable": false,
        	"orderable": true,
            "data": "paid",
            "render": function (data, type, full, meta ) {
              if (data) {
                return '<span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span>';
              }
              else {
                return '';	  
              }
            }	
          },
          {
          	"targets": 3,
          	"searchable": false,
          	"orderable": true,
            "data": "notified",
            "render": function (data, type, full, meta ) {
              if (data) {
                return '<span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span>';
              }
              else {
                return '';	  
              }
            }	
          }
        ]
    }).on( 'error.dt', function (e, settings, techNote, message ) { // triggered when response is NOT of 2XX
    	alert(message);
        //console.log( 'An error has been reported by DataTables: ', message );
    } );
    
    $('#btn').on('click', function() {
      table.draw();
    });
} );

