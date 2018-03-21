<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 17/11/9
  Time: 上午11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
    <script src="/js/jquery-3.2.1.js"></script>
</head>
<body>
<h3>home</h3>

<form action="/login">
    <select id="department" name="departmentId">
        <option value="-1">---请选择---</option>
    </select>
    <select id="post" name="postId">
        <option value="-1">---请选择---</option>
    </select>
    学号: <br>
    ID:<input type="checkbox" name="ids" value="1"><br>
    ID:<input type="checkbox" name="ids" value="2"><br>
    ID:<input type="checkbox" name="ids" value="3"><br>
    <input type="submit" value="提交">
</form>

</body>
<script>

    //     页面加载成功直接通过ajax请求获取部门集合
    $.ajax({
        url: "/hr/findAll",
        type: "get",
        success: function (result) {

            var _html = document.getElementById("department");

            _html.innerHTML = "<option value='-1'>---请选择---</option>";

//                遍历结果集
            for (var i = 0; i < result.length; i++) {

                _html.innerHTML += "<option value='" + result[i].depID + "'>" + result[i].depName + "</option>"

            }
        }
    })

    //    根据部门id发起职务请求
    $("#department").change(function () {
//        得到选中部门id
        var depId = $("#department").val();
        $.ajax({
            type: "get",
            url: "/hr/findPostsByDepId",
            data: {
                "depId": depId
            },
            success: function (result) {
                var _html = document.getElementById("post");

                _html.innerHTML = "<option value='-1'>---请选择---</option>";

                for (var i = 0; i < result.length; i++) {

                    _html.innerHTML += "<option value='" + result[i].postId + "'>" + result[i].postName + "</option>"

                }
            }
        })

    })

    //    $.post("/hr/findAll", function (date) {
    //        var _html = "";
    //
    //        for (var i = 0; i < date.length; i++) {
    //
    //            _html += "<option value='" + date[i].depID + "'>" + date[i].depName + "</option>"
    //
    //        }
    //
    //        $("#department").empty();
    //
    //        $("#department").append("<option value='-1'>--请选择部门--</option>");
    //
    //        $("#department").append(_html);
    //    })


</script>
</html>
