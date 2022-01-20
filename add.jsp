<%@ page import="com.CompanyInventory.DBManager"%>
<%@ page import="com.CompanyInventory.InventoryItem"%>
<%@ page import="java.util.ArrayList"%>
<html>
    <body>
        <style>
            body {
              font-family: "Lato", sans-serif;
              transition: background-color .5s;
            }
            
            .sidenav {
              height: 100%;
              width: 0;
              position: fixed;
              z-index: 1;
              top: 0;
              left: 0;
              background-color: #111;
              overflow-x: hidden;
              transition: 0.5s;
              padding-top: 60px;
            }
            
            .sidenav a {
              padding: 8px 8px 8px 32px;
              text-decoration: none;
              font-size: 25px;
              color: #818181;
              display: block;
              transition: 0.3s;
            }
            
            .sidenav a:hover {
              color: #f1f1f1;
            }
            
            .sidenav .closebtn {
              position: absolute;
              top: 0;
              right: 25px;
              font-size: 36px;
              margin-left: 50px;
            }
            
            #main {
              transition: margin-left .5s;
              padding: 16px;
            }
            
            @media screen and (max-height: 450px) {
              .sidenav {padding-top: 15px;}
              .sidenav a {font-size: 18px;}
            }
            
            body { 
              margin: 0;
              font-family: Arial, Helvetica, sans-serif;
            }
            
            .header {
              overflow: hidden;
              background-color: #463479;
              padding: 20px 10px;
            }
            
            .header a {
              float: left;
              color: black;
              text-align: center;
              padding: 12px;
              text-decoration: none;
              font-size: 18px; 
              line-height: 25px;
              border-radius: 4px;
            }
            
            .header a.logo {
              font-size: 25px;
              font-weight: bold;
            }
            
            .header a:hover {
              background-color: #ddd;
              color: black;
            }
            
            .header a.active {
              background-color: dodgerblue;
              color: white;
            }
            
            .header-right {
              float: right;
            }
            
            @media screen and (max-width: 500px) {
              .header a {
                float: none;
                display: block;
                text-align: left;
              }
              
              .header-right {
                float: none;
              }
            }
            </style>
      

       
    <div class="header">
        <a href="home.jsp" class="logo">CompanyLogo</a>
      </div>
      
     

<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="home.jsp">Home</a>   
  <a href="add.jsp">Add</a>
  <a href="delete.jsp">Delete</a>
  <a href="update.jsp">Update</a>
</div>

<div id="main">
  <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; </span>
</div>

<script>
function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
  document.getElementById("main").style.marginLeft = "250px";
  document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
  document.getElementById("main").style.marginLeft= "0";
  document.body.style.backgroundColor = "white";
}
</script>

        <form action="CreateServlet">
            <table style="margin-left:left;margin-right:auto;">
                <tr>
                    <td>
                        Location Name:
                    </td>
                    <td>
                        <input type="text" name="locationName">
                    </td>
                </tr>
                <tr>
                    <td>
                        Name:
                    </td>
                    <td>
                        <input type="text" name="name">
                    </td>
                </tr>
                <tr>
                    <td>
                        Address:
                    </td>
                    <td>
                        <input type="text" name="address">
                    </td>
                </tr>
                <tr>
                    <td>
                        SKU:
                    </td>
                    <td>
                        <input type="text" name="SKU">
                    </td>
                </tr>
                <tr>
                    <td>
                        Cost:
                    </td>
                    <td>
                        <input type="text" name="cost">
                    </td>
                </tr>
                <tr>
                    <td>
                        Type:
                    </td>
                    <td>
                        <input type="text" name="type">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit">
                    </td>
                </tr>
            </table>
        </form>

        <table style="margin-left:left;margin-right:auto;">
            <tr>
                <td>
                    <h1>
                    <%
                        out.println("Name / Address / SKU / Cost / Type");
                    %>
                </h1>
                    <br>
    
                    <%
                        DBManager manager = new DBManager();
                        ArrayList<InventoryItem> items = manager.getAll();
                        for(InventoryItem item: items){
                        out.println(item.getName() + " / " + item.getAddress() + " / " + item.getSKU() + " / " + item.getCost() + " / " + item.getType());
                    %>

                    <br>

                    <%
                        }
                    %>
                </td>
            </tr>
        </table>

    </body>
</html>