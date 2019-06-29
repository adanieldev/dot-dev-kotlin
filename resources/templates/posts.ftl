<html>
<head>
    <title>A. Daniel DEV</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h1>Posts</h1>
<ul>
    <#list posts as post>
        <li>${ post }</li>
    </#list>
</ul>
</body>
</html>