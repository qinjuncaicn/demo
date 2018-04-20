<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <meta charset="UTF-8" />
    <!-- DataTables CSS -->
    <link rel="stylesheet" type="text/css" href="/datatables/css/jquery.dataTables.css">
    <link rel="stylesheet" type="text/css" href="/bootstrap3/css/bootstrap.css">
    <!-- jQuery -->
    <script type="text/javascript" charset="utf8" src="/datatables/js/jquery.js"></script>

    <!-- DataTables -->
    <script type="text/javascript" charset="utf8" src="/datatables/js/jquery.dataTables.js"></script>
    <script type="text/javascript" charset="utf8" src="/datatables/js/dataTables.bootstrap.js"></script>

    <title>Title</title>

    </head>
    <body>
            <!--第二步：添加如下 HTML 代码-->
        <table id="table_id_example" class="display">
            <thead>
                    <tr>
                        <th>姓名</th>
                        <th>岗位</th>
                        <th>工资</th>
                        <th>部门</th>
                    </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </body>
</html>
<script>
    <!-- 第三步：初始化Datatables -->
    $(document).ready(function () {
    var table = $('#table_id_example').DataTable({
           language: {
                search: "在表格中搜索:"
            },
            "info" : true,
            "paging": true,
            "processing":false,
            "searching": true,
            //使用对象数组，一定要配置columns，告诉 DataTables 每列对应的属性
            //data 这里是固定不变的，name，position，salary，office 为你数据里对应的属性
            columns: [
                { data: 'name' },
                { data: 'position' },
                { data: 'salary' },
                { data: 'office' }
            ],
            //开启服务器模式
            serverSide: true,
            ajax: {
                type: 'GET',
                url: '/datatables/data.json'

            }
        });
    });

</script>