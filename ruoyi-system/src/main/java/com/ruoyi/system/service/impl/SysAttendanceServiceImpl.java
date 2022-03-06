package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysAttendanceMapper;
import com.ruoyi.system.domain.SysAttendance;
import com.ruoyi.system.service.ISysAttendanceService;
import com.ruoyi.common.core.text.Convert;

/**
 * 考勤管理Service业务层处理
 * 
 * @author WangQ
 * @date 2022-01-28
 */
@Service
public class SysAttendanceServiceImpl implements ISysAttendanceService 
{
    @Autowired
    private SysAttendanceMapper sysAttendanceMapper;

    /**
     * 查询考勤管理
     * 
     * @param id 考勤管理ID
     * @return 考勤管理
     */
    @Override
    public SysAttendance selectSysAttendanceById(Long id)
    {
        return sysAttendanceMapper.selectSysAttendanceById(id);
    }

    /**
     * 查询考勤管理列表
     * 
     * @param sysAttendance 考勤管理
     * @return 考勤管理
     */
    @Override
    public List<SysAttendance> selectSysAttendanceList(SysAttendance sysAttendance)
    {
        return sysAttendanceMapper.selectSysAttendanceList(sysAttendance);
    }

    /**
     * 新增考勤管理
     * 
     * @param sysAttendance 考勤管理
     * @return 结果
     */
    @Override
    public int insertSysAttendance(SysAttendance sysAttendance)
    {
        sysAttendance.setCreateTime(DateUtils.getNowDate());
        return sysAttendanceMapper.insertSysAttendance(sysAttendance);
    }

    /**
     * 修改考勤管理
     * 
     * @param sysAttendance 考勤管理
     * @return 结果
     */
    @Override
    public int updateSysAttendance(SysAttendance sysAttendance)
    {
        sysAttendance.setUpdateTime(DateUtils.getNowDate());
        return sysAttendanceMapper.updateSysAttendance(sysAttendance);
    }

    /**
     * 删除考勤管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysAttendanceByIds(String ids)
    {
        return sysAttendanceMapper.deleteSysAttendanceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除考勤管理信息
     * 
     * @param id 考勤管理ID
     * @return 结果
     */
    @Override
    public int deleteSysAttendanceById(Long id)
    {
        return sysAttendanceMapper.deleteSysAttendanceById(id);
    }
}
