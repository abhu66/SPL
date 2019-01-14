/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    
    function ajaxLink(link,update){
        $.get(link,function(data){
           $(update).html(data);
           $(update).show();
        });
        return false;  
    };
    
    $('.navbar-toggle-sidebar').click(function () {
  		$('.navbar-nav').toggleClass('slide-in');
  		$('.side-body').toggleClass('body-slide-in');
  		$('#search').removeClass('in').addClass('collapse').slideUp(200);
  	});
       
    $('#btnTambahUser').click(function(){
        var link = $("#btnTambahUser").attr("href");
        $("#FormEditUser").hide();
        $("#FormViewUser").hide();
        return ajaxLink(link,"#FormUser");
    });
     $('.editLink').click(function(){
        $("#FormUser").hide();
        $("#FormViewUser").hide();
       var link = "";
       link = $(this).attr("href");
       return ajaxLink(link,"#FormEditUser");
       
    });
     $('.viewLink').click(function(){
        $("#FormUser").hide();
        $("#FormEditUser").hide();
       var link = "";
       link = $(this).attr("href");
       return ajaxLink(link,"#FormViewUser");
    });

    
    $(".btn btn-primary cancel").click(function(){
        $("#FormUser").hide();
        $("#FormEditUser").hide();
    });
});



  
  
    
  
  
  


