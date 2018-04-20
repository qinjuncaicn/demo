package com.qjc.controller.datatable;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述:
 * dataTables demo
 *
 * @outhor qinju
 * @create 2018-04-20 22:53
 */
@Controller
@RequestMapping("/datatables")
public class DataTableDemo {

    @RequestMapping("datatabledemo1")
    public String topage(){
        return "datatables/datatabledemo1";
    }
}
