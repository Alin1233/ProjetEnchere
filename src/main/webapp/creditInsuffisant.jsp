<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta charset="UTF-8">
<!--Import Bootstrap-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<!--Import Font awesome-->
<script src="https://kit.fontawesome.com/0bec6bfa71.js" crossorigin="anonymous"></script>

<style>
body {
            margin: 0;
            padding: 0;
        }

        form {
            max-width: 800px;
            margin: 0 auto;
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
        }

        .form-group {
            width: 48%;
            box-sizing: border-box;
            padding: 10px;
            margin-bottom: 15px;
            text-align: left;
        }

        input {
            width: 100%;
            box-sizing: border-box;
            padding: 8px;
            margin-bottom: 10px;
            display: block;
        }

        h1 {
            text-align: center;
            margin: 0;
            padding: 16px;
        }

        .boutton {
            text-align: center;
            margin-top: 20px;
            width: 100%;
            display: flex;
            justify-content: center;
        }

        button {
            background-color: #808080;
            color: white;
            padding: 12px 24px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
            margin-right: 10px;
        }

        button:hover {
            background-color: #555;
        }

        .bouton-lien {
            background-color: #808080;
            color: white;
            padding: 12px 24px;
            text-decoration: none;
            border-radius: 5px;
            font-size: 16px;
            transition: background-color 0.3s;
            margin: 0;
        }

        .bouton-lien:hover {
            background-color: #555;
        }
        
    </style>
</head>
<body>

<p>
Credit insuffisant
</p>
<a href="detailVenteAcheteur.jsp" target="_blank" class="bouton-lien">Retour</a>

</body>
</html>