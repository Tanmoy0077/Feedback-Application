<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.firstapp.model.Department"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Feedback</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        body{
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        .outer-box{
            padding: 5vh;
            width: 40vw;
            margin-top: 10vh;
            border-radius: 8px;
            box-shadow: 5px 5px 15px 5px #888888;
        }
       .heading{
            margin-bottom: 10px;
       }
        button{
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <% Department d = (Department) request.getAttribute("oldData"); %>
    <div class="container border border-primary outer-box">
        <div class="d-flex justify-content-center heading">
            <h1>Edit Feedback</h1>
        </div>
        <div class="container data">
            <form action="/edit" method="get">
                <div class="md-3">
                    <label class="form-label">Department</label><br>
                    <input type="text" name="department" id="department" class="form-control form-control-lg" value="<%=d.dept%>"><br>
                </div>
                <div class="md-3">
                    <label class="form-label">Remarks</label><br>
                    <textarea class="form-control" id="remarks" name="remarks" rows="3"><%=d.remk%></textarea>
                </div>
                    <input type="hidden" id="id" name="id" value="<%=d.id%>">
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>