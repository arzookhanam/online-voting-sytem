<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Voting Results</title>
  <style>
    body {
      margin: 0;
      font-family: 'Segoe UI', sans-serif;
      background: linear-gradient(to right, #fceabb, #f8b500);
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    .results-container {
      background: #ffffff;
      padding: 30px;
      border-radius: 15px;
      box-shadow: 0 8px 25px rgba(0,0,0,0.2);
      width: 90%;
      max-width: 600px;
      animation: fadeIn 0.8s ease;
    }

    h2 {
      text-align: center;
      color: #333;
      margin-bottom: 25px;
    }

    table {
      width: 100%;
      border-collapse: collapse;
      font-size: 16px;
    }

    th, td {
      padding: 14px 12px;
      text-align: center;
      border-bottom: 1px solid #ccc;
    }

    th {
      background-color: #f8b500;
      color: white;
    }

    tr:hover {
      background-color: #f1f1f1;
    }

    @keyframes fadeIn {
      from {
        opacity: 0;
        transform: translateY(-20px);
      }
      to {
        opacity: 1;
        transform: translateY(0);
      }
    }
  </style>
</head>
<body>
  <div class="results-container">
    <h2>Voting Results</h2>
    <table>
      <tr>
        <th>Party</th>
        <th>Votes</th>
      </tr>
      <%
        List<String[]> results = (List<String[]>)request.getAttribute("results");
        for (String[] row : results) {
      %>
        <tr>
          <td><%= row[0] %></td>
          <td><%= row[1] %></td>
        </tr>
      <% } %>
    </table>
  </div>
</body>
</html>