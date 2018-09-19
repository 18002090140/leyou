package com.leyou.service.web;

import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
import com.leyou.service.service.SpecGroupService;
import com.leyou.service.service.SpecParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author bystander
 * @date 2018/9/18
 */
@RestController
@RequestMapping("spec")
public class SpecController {

    @Autowired
    private SpecGroupService specGroupService;

    @Autowired
    private SpecParamService specParamService;


    /**
     * 根据商品分类ID查询规格组
     *
     * @param cid
     * @return
     */
    @GetMapping("groups/{cid}")
    public ResponseEntity<List<SpecGroup>> querySpecGroupByCid(@PathVariable("cid") Long cid) {
        return ResponseEntity.ok(specGroupService.querySpecGroupByCid(cid));
    }

    /**
     * 查询商品规格参数
     * @param gid  规格组ID
     * @param cid  商品分类ID
     * @param searching  是否是搜索字段
     * @param generic  是否是通用字段
     * @return
     */
    @GetMapping("params")
    public ResponseEntity<List<SpecParam>> querySpecParams(
            @RequestParam(value = "gid", required = false) Long gid,
            @RequestParam(value = "cid", required = false) Long cid,
            @RequestParam(value = "searching", required = false) Boolean searching,
            @RequestParam(value = "generic", required = false) Boolean generic
    ) {
        return ResponseEntity.ok(specParamService.querySpecParams(gid, cid, searching, generic));
    }


}
