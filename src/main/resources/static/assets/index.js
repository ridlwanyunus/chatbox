/**
 * 
 */
 
 var index = function(){
 
 	var clearChatBotMemory = function(){

 		$.ajax({
 			url: '/answer/refresh',
 			method: 'GET',
 			contentType: 'application/json',
 			success: function(response){
 				answer = response.toString().replace(/"/g,'');
 				console.log(answer);
 			}
 		});
 	}
 	
 	
 
 	return {
 		init: function(){
 			clearChatBotMemory();
 		}
 	}
 }();
 
 jQuery(document).ready(function(){
 	index.init();
 });