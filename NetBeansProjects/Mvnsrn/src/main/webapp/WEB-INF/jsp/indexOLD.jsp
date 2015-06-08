<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
        <script type="text/javascript">
            
            $(function(){
                $('#btn').click(function(){
                    
                var data = "first=Pizda&last=ivanovna";
                alert("Pizda");
                $.ajax({
                    type:"POST",
                    
                    url:"getUser.htm",
                    
                    data:data,

                    success: function(data){
                        
                        alert(data)
                        
                        $('#result').html(data);
                    }
                    
                }); 
               }); 
            });
         
            function hello(){
                
                var data = "first=Pizda&last=ivanovna";
                $.ajax({
                    url:"getRandom.htm",
                    success: function(data){
                        
                        $('#result').html(data);
                    }
                    
                });
            }
            
            
        </script>
        <script type="text/javascript">
//            var interval = 0;
//            interval = setInterval(hello,3000);
        </script>
    </head>

    <body>
       <p>Hello Spring Controller</p> 
       <div id="result"></div>
       <button id="btn">Daldan</button>
    </body>
</html>
