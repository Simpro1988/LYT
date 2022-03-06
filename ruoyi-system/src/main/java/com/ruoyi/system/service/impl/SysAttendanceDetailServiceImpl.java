package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysAttendanceDetailMapper;
import com.ruoyi.system.domain.SysAttendanceDetail;
import com.ruoyi.system.service.ISysAttendanceDetailService;
import com.ruoyi.common.core.text.Convert;

/**
 * 考勤管理Service业务层处理
 * 
 * @author WangQ
 * @date 2022-01-28
 */
@Service
public class SysAttendanceDetailServiceImpl implements ISysAttendanceDetailService 
{
    @Autowired
    private SysAttendanceDetailMapper sysAttendanceDetailMapper;

    /**
     * 查询考勤管理
     * 
     * @param id 考勤管理ID
     * @return 考勤管理
     */
    @Override
    public SysAttendanceDetail selectSysAttendanceDetailById(Long id)
    {
        return sysAttendanceDetailMapper.selectSysAttendanceDetailById(id);
    }

    /**
     * 查询考勤管理列表
     * 
     * @param attendanceId 考勤管理
     * @return 考勤管理
     */
    @Override
    public List<SysAttendanceDetail> selectSysAttendanceDetailList(Long attendanceId)
    {
        return sysAttendanceDetailMapper.selectSysAttendanceDetailList(attendanceId);
    }

    /**
     * 新增考勤管理
     * 
     * @param sysAttendanceDetail 考勤管理
     * @return 结果
     */
    @Override
    public int insertSysAttendanceDetail(SysAttendanceDetail sysAttendanceDetail)
    {
        sysAttendanceDetail.setCreateTime(DateUtils.getNowDate());
        return sysAttendanceDetailMapper.insertSysAttendanceDetail(sysAttendanceDetail);
    }

    /**
     * 修改考勤管理
     * 
     * @param sysAttendanceDetail 考勤管理
     * @return 结果
     */
    @Override
    public int updateSysAttendanceDetail(SysAttendanceDetail sysAttendanceDetail)
    {
        sysAttendanceDetail.setUpdateTime(DateUtils.getNowDate());
        return sysAttendanceDetailMapper.updateSysAttendanceDetail(sysAttendanceDetail);
    }

    /**
     * 删除考勤管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysAttendanceDetailByIds(String ids)
    {
        return sysAttendanceDetailMapper.deleteSysAttendanceDetailByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除考勤管理信息
     * 
     * @param id 考勤管理ID
     * @return 结果
     */
    @Override
    public int deleteSysAttendanceDetailById(Long id)
    {
        return sysAttendanceDetailMapper.deleteSysAttendanceDetailById(id);
    }
}
