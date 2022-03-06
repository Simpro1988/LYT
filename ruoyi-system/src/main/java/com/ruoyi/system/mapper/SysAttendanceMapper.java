package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysAttendance;

/**
 * 考勤管理Mapper接口
 * 
 * @author WangQ
 * @date 2022-01-28
 */
public interface SysAttendanceMapper 
{
    /**
     * 查询考勤管理
     * 
     * @param id 考勤管理ID
     * @return 考勤管理
     */
    public SysAttendance selectSysAttendanceById(Long id);

    /**
     * 查询考勤管理列表
     * 
     * @param sysAttendance 考勤管理
     * @return 考勤管理集合
     */
    public List<SysAttendance> selectSysAttendanceList(SysAttendance sysAttendance);

    /**
     * 新增考勤管理
     * 
     * @param sysAttendance 考勤管理
     * @return 结果
     */
    public int insertSysAttendance(SysAttendance sysAttendance);

    /**
     * 修改考勤管理
     * 
     * @param sysAttendance 考勤管理
     * @return 结果
     */
    public int updateSysAttendance(SysAttendance sysAttendance);

    /**
     * 删除考勤管理
     * 
     * @param id 考勤管理ID
     * @return 结果
     */
    public int deleteSysAttendanceById(Long id);

    /**
     * 批量删除考勤管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysAttendanceByIds(String[] ids);
}
