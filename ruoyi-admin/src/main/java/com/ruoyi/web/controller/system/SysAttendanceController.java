package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.system.domain.SysAttendanceDetail;
import com.ruoyi.system.service.ISysAttendanceDetailService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysAttendance;
import com.ruoyi.system.service.ISysAttendanceService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 考勤管理Controller
 * 
 * @author WangQ
 * @date 2022-01-28
 */
@Controller
@RequestMapping("/system/attendance")
public class SysAttendanceController extends BaseController
{
    private String prefix = "system/attendance";

    @Autowired
    private ISysAttendanceService sysAttendanceService;

    @Autowired
    private ISysAttendanceDetailService sysAttendanceDetailService;

    @RequiresPermissions("system:attendance:view")
    @GetMapping()
    public String attendance()
    {
        return prefix + "/attendance";
    }

    /**
     * 查询考勤管理列表
     */
    @RequiresPermissions("system:attendance:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysAttendance sysAttendance)
    {
        startPage();
        List<SysAttendance> list = sysAttendanceService.selectSysAttendanceList(sysAttendance);
        return getDataTable(list);
    }

    /**
     * 导出考勤管理列表
     */
    @RequiresPermissions("system:attendance:export")
    @Log(title = "考勤管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysAttendance sysAttendance)
    {
        List<SysAttendance> list = sysAttendanceService.selectSysAttendanceList(sysAttendance);
        ExcelUtil<SysAttendance> util = new ExcelUtil<SysAttendance>(SysAttendance.class);
        return util.exportExcel(list, "考勤管理数据");
    }

    /**
     * 查询考勤管理列表
     */
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long attendanceId, ModelMap mmap)
    {
        //mmap.put("detailList", list);
        SysAttendance sysAttendance = sysAttendanceService.selectSysAttendanceById(attendanceId);
        mmap.put("sysAttendance", sysAttendance);
        return prefix + "/detail";
    }

    @PostMapping("/detailList")
    @RequiresPermissions("system:attendance:detailList")
    @ResponseBody
    public TableDataInfo list(SysAttendanceDetail sysAttendanceDetail)
    {
        List<SysAttendanceDetail> list = sysAttendanceDetailService.selectSysAttendanceDetailList(sysAttendanceDetail.getAttendanceId());
        return getDataTable(list);
    }

    /**
     * 新增考勤管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存考勤管理
     */
    @RequiresPermissions("system:attendance:add")
    @Log(title = "考勤管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysAttendance sysAttendance)
    {
        return toAjax(sysAttendanceService.insertSysAttendance(sysAttendance));
    }

    /**
     * 修改考勤管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SysAttendance sysAttendance = sysAttendanceService.selectSysAttendanceById(id);
        mmap.put("sysAttendance", sysAttendance);
        return prefix + "/edit";
    }

    /**
     * 修改保存考勤管理
     */
    @RequiresPermissions("system:attendance:edit")
    @Log(title = "考勤管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysAttendance sysAttendance)
    {
        return toAjax(sysAttendanceService.updateSysAttendance(sysAttendance));
    }

    /**
     * 删除考勤管理
     */
    @RequiresPermissions("system:attendance:remove")
    @Log(title = "考勤管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysAttendanceService.deleteSysAttendanceByIds(ids));
    }
}
