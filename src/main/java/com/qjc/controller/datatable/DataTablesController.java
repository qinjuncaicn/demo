package com.qjc.controller.datatable;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.qjc.model.Department;
import com.qjc.model.vo.DeptQueryCondition;
import com.qjc.service.DepartmentService;
import com.qjc.utils.DataTablePageUtil;
import com.qjc.utils.DatatablesView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author  qinjuncai
 * @description: dataTable 分页
 * @create 2018/04/21 10:21
 */
@RequestMapping("/dept")
@Controller
public class DataTablesController {

    // slf4j logger
    private final static Logger logger = LoggerFactory.getLogger(DataTablesController.class);

    @Autowired
    DepartmentService departmentService;

   /* @RequestMapping(value="/getData", produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String getData(@RequestParam(value="page",required=false)String page, @RequestParam(value="draw",required=false)String draw,@RequestParam(value="start",required=false)String start,@RequestParam(value="length",required=false)String length,HttpServletRequest request) {
        if(StringUtil.isEmpty(page)){
            page="1";
        }
        System.out.print(draw);
        int pageNum= Integer.parseInt(page);  //把页面传过来的页码转成整型
        //pageNum  当前传过来的页码              15代表每页显示多少条
        PageHelper.startPage(pageNum,15);
        List<Department> list=	departmentService.selectAll();

        PageInfo pageinfo=new PageInfo(list);

        DatatablesView<Department> dataTable = new DatatablesView<>();
        dataTable.setDraw(Integer.parseInt(draw));
        dataTable.setData(list);
        long total = pageinfo.getTotal();
        dataTable.setRecordsTotal(total);
//        dataTable.setDraw(query.getDraw());
        String data = JSON.toJSONString(dataTable);
        return data;    }*/

   @RequestMapping(value = "/getData")
   @ResponseBody
   @ResponseStatus(HttpStatus.OK)
   public Object getPage(HttpServletRequest request) {
       logger.debug("----->>>>>[getPage]:");
//       String name = request.getUserPrincipal().getName();

       //使用DataTables的属性接收分页数据
       DataTablePageUtil<Department> dataTable = new DataTablePageUtil<>(request);
       //开始分页：PageHelper会处理接下来的第一个查询
       PageHelper.startPage(dataTable.getPage_num(), dataTable.getLength());
       //还是使用List，方便后期用到
       List<Department> list = departmentService.selectAll();
       //用PageInfo对结果进行包装
       PageInfo<Department> pageInfo = new PageInfo<>(list);

       //封装数据给DataTables
       dataTable.setDraw(dataTable.getDraw());
       dataTable.setData(pageInfo.getList());
       dataTable.setRecordsTotal((int) pageInfo.getTotal());
       dataTable.setRecordsFiltered(dataTable.getRecordsTotal());

       //返回数据到页面
       String jsonString = JSON.toJSONString(dataTable);

       return jsonString;

   }

}
