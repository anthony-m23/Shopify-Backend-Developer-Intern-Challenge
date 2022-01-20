<%@ page import="com.CompanyInventory.DBManager"%>
<%@ page import="com.CompanyInventory.InventoryItem"%>
<%@ page import="java.util.ArrayList"%>
<html>
    <body>
        <h2 style="text-align:center;background-color:blue;color:white">Company Inventory Manager</h2>
        <form action = "home.jsp">
            <table style="margin-left:left;margin-right:auto;">
                <tr>
                    <td>
                        <input type="submit" value="Home">
                    </td>
                </tr>
            </table>
        </form>

        <form action="update.jsp">
            <table style="margin-left:left;margin-right:auto;">
                <tr>
                    <td>
                        <input type="submit" value="UPDATE">
                    </td>
                </tr>
            </table>
        </form>


        <form action = "add.jsp">
            <table style="margin-left:left;margin-right:auto;">
                <tr>
                    <td>
                        <input type="submit" value="ADD">
                    </td>
                </tr>
            </table>
        </form>

        <form action="DeleteServlet">
            <table style="margin-left:left;margin-right:auto;">
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
                        SKU:
                    </td>
                    <td>
                        <input type="text" name="SKU">
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
                </table>

                    <br>

                    <%
                        }
                    %>
                </td>
            </tr>
        </table>


    </body>
</html>