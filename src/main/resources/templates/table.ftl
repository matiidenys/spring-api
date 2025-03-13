<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Hello messages</h1>

<table border="3" >
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Second Name</th>
        <th>Birthdate</th>


    </tr>
    <#list items as item>
        <tr>
            <td>${item.id}</td>
            <td>${item.from}</td>
            <td>${item.to}</td>
            <td>${item.text}</td>
        </tr>
    </#list>
</table>

</body>
</html>