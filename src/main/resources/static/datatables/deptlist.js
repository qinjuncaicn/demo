$(function() {
    var table = $("#example").DataTable({

        // aLengthMenu: [[10, 25, 50, 100], ["10条", "25条", "50条", "100条"]],//二组数组，第一组数量，第二组说明文字;
        aLengthMenu: [10, 25, 50, 100],//也可以直接用一维数组设置数量
        // lengthChange: false,//是否允许用户改变表格每页显示的记录数
        serverSide: true,//分页，取数据等等的都放到服务端去
        paging: true,//是否分页
        processing: true,//载入数据的时候是否显示“载入中”
        // pageLength: 5,  //首次加载的数据条数

        ordering: false, //排序操作在服务端进行，所以可以关了。
        pagingType: "full_numbers",//除首页、上一页、下一页、末页四个按钮还有页数按钮
        autoWidth: false,
        stateSave: true,//保持翻页状态，和comTable.fnDraw(false);结合使用
        searching: false,//禁用datatables搜索
        language: {
            "lengthMenu": "每页 _MENU_ 条记录",
            "zeroRecords": " ",
            "info": "当前 _START_ 条到 _END_ 条 共 _TOTAL_ 条",
            "infoEmpty": "无记录",
            "infoFiltered": "(从 _MAX_ 条记录过滤)",
            // "search": "用户",
            "processing": "载入中",
            "paginate": {
                "first": "首页",
                "previous": "上一页",
                "next": "下一页",
                "last": "尾页"
            }
        },
        ajax: {
            type: "POST",
            url: "/dept/getData",
            dataSrc: "data",
            data: function (d) {
                // var param = {};
                // param.draw = d.draw;
                // param.start = d.start;
                // param.length = d.length;
                // console.log(draw+"--"+start+"--"+length);
                // // var formData = $("#queryForm").serializeArray();//把form里面的数据序列化成数组
                // // formData.forEach(function (e) {
                // //     param[e.name] = e.value;
                // // });
                // return param;//自定义需要传递的参数。
            },
        },
        "aoColumns" : [{
            "mData" : "id",
            "sDefaultContent" : "",
            "sWidth" : "2%"
        },{
            "mData" : "id",
            "orderable" : false, // 禁用排序
            "sDefaultContent" : "",
            "sWidth" : "6%",

        }, {
            "mData" : "deptname",
            "orderable" : false, // 禁用排序
            "sDefaultContent" : "",
            "sWidth" : "10%"
        }, {
            "mData" : "remark",
            "orderable" : false, // 禁用排序
            "sDefaultContent" : "",
            "sWidth" : "10%"
        },{
            "mData" : "state",
            "orderable" : false, // 禁用排序
            "sDefaultContent" : "",
            "sWidth" : "3%",
            "render" : function(data, type, full, meta) {
                return data == 1 ? '有效' : '<font color="red">无效</font>';
            }
        },
            {
                "mData" : "createtime",
                "orderable" : false, // 禁用排序
                "sDefaultContent" : "",
                "sWidth" : "10%",
                "render" : function(data, type, full, meta) {
                    //时间格式化
                    return  moment(data).format("YYYY-MM-DD HH:mm:ss");
                }
            },
            {
                "mData" : "id",
                "orderable" : false, // 禁用排序
                "sDefaultContent" : '',
                "sWidth" : "10%",
                "render":function(data, type, full, meta){
                    return	data='<button id="deleteOne" class="btn btn-danger btn-sm" data-id='+data+'>删 除</button>';

                }
            }],
        "columnDefs" :
            [{
                "orderable" : false, // 禁用排序
                "targets" : [0], // 指定的列
                "data" : "id",
                "render" : function(data, type, full, meta) {
                    return '<input type="checkbox" value="'+ data + '" name="id"/>';
                }
            }],
        initComplete:initComplete,


	});


    /**
     * 表格加载渲染完毕后执行的方法
     * @param data
     */
    function initComplete(data){
       console.log('initComplete')
    }


})