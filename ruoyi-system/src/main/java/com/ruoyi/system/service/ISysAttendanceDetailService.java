package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysAttendanceDetail;

/**
 * 考勤管理Service接口
 * 
 * @author WangQ
 * @date 2022-01-28
 */
public interface ISysAttendanceDetailService 
{
    /**
     * 查询考勤管理
     * 
     * @param id 考勤管理ID
     * @return 考勤管理
     */
    public SysAttendanceDetail selectSysAttendanceDetailById(Long id);

    /**
     * 查询考勤管理列表
     * 
     * @param attendanceId 考勤管理
     * @return 考勤管理集合
     */
    public List<SysAttendanceDetail> selectSysAttendanceDetailList(Long attendanceId);

    /**
     * 新增考勤管理
     * 
     * @param sysAttendanceDetail 考勤管理
     * @return 结果
     */
    public int insertSysAttendanceDetail(SysAttendanceDetail sysAttendanceDetail);

    /**
     * 修改考勤管理
     * 
     * @param sysAttendanceDetail 考勤管理
     * @return 结果
     */
    public int updateSysAttendanceDetail(SysAttendanceDetail sysAttendanceDetail);

    /**
     * 批量删除考勤管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysAttendanceDetailByIds(String ids);

    /**
     * 删除考勤管理信息
     * 
     * @param id 考勤管理ID
     * @return 结果
     */
    public int deleteSysAttendanceDetailById(Long id);
}
