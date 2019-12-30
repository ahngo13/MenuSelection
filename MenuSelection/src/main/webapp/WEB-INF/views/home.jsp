<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!
	<hr>	  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Ahn2KimNa</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <style>  
      #jb-container {
        width: 940px;
        margin: 0px auto;
        padding: 20px;
        border: 1px solid #bcbcbc;
      }
      
      #jb-header {
        padding: 20px;
        margin-bottom: 20px;
        border: 1px solid #bcbcbc;
      }
      
      #jb-content {
        width: 580px;
        padding: 20px;
        margin-bottom: 20px;
        float: left;
        border: 1px solid #bcbcbc;
      }
      
      #jb-sidebar {
        width: 260px;
        padding: 20px;
        margin-bottom: 20px;
        float: right;
        border: 1px solid #bcbcbc;
      }
      
      #jb-footer {
        clear: both;
        padding: 20px;
        border: 1px solid #bcbcbc;
      }
      
      @media screen and (max-width:480px) {
        #jb-container {
          width: auto;
        }
        
        #jb-content {
          float: none;
          width: auto;
        }
        
        #jb-sidebar {
          float: none;
          width: auto;
        }
      }
    </style>

</head>

<body>

    <div id="jb-container">

      <div id="jb-header">

        <h1>Start page</h1>

      </div>

      <div id="jb-content">

        <h2>Content</h2>

        <p>Hello, What are you eating today?</p>

      </div>

      <div id="jb-sidebar">

        <h2>Login</h2>

        <ul>

          <li>ID</li>

          <li>PW</li>

        </ul>

      </div>

      <div id="jb-footer">

        <p>Copyright</p>

      </div>

    </div>

</body>

</html>