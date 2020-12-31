$(document).ready(function () {

    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
        console.log("hi");
    });
    
$('.delete').click(function (e) { 
  e.stopPropagation();
});

$('.tododiv').click(function() {

   if ( $('#overlap').css('visibility') == 'hidden' )
    $('#overlap').css('visibility','visible');
  
   $('#content').css('filter','blur(8px)');
   
   
   var id=$(this).attr('id');
   
   var noteid="#"+id+"id"
   var title="#"+id+"title";
   var text="#"+id+"text";
  
   var valueid=$(noteid).val();  
   var valuetitle = $(title).text();
   var valuetext = $(text).text();
  
  $('#editId').val(valueid);
  $('#editTitle').val(valuetitle);
  $('#editText').val(valuetext);
  
});

 $('#save').click(function () {            
    if ( $('#overlap').css('visibility') == 'visible' )
       $('#overlap').css('visibility','hidden');
  });


});