package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysAttendanceDetail;

/**
 * 考勤管理Mapper接口
 * 
 * @author WangQ
 * @date 2022-01-28
 */
public interface SysAttendanceDetailMapper 
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
     * 删除考勤管理
     * 
     * @param id 考勤管理ID
     * @return 结果
     */
    public int deleteSysAttendanceDetailById(Long id);

    /**
     * 批量删除考勤管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysAttendanceDetailByIds(String[] ids);
}
