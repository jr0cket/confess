$("#secret")
  .focus(function() {
        if (this.value === this.defaultValue) {
            this.value = '';
        }
  })
  .blur(function() {
        if (this.value === '') {
            this.value = this.defaultValue;
        }
});

$(function(){
  $('#container').masonry({
    // options
    itemSelector : '.item',
    columnWidth : 100,
    isAnimated : true,
    isResizable : true,
    appended : true,
    reload : true,
    animationOptions : { queue: true, duration: 500 }
  });
});  

$('#container').infinitescroll({
 
    navSelector  : "div.navigation",            
                   // selector for the paged navigation (it will be hidden)
    nextSelector : "div.navigation a:first",    
                   // selector for the NEXT link (to page 2)
    itemSelector : "#container div.item"          
                   // selector for all items you'll retrieve
  });