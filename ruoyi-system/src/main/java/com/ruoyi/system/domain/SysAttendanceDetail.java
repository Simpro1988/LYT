package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 考勤管理对象 sys_attendance_detail
 * 
 * @author WangQ
 * @date 2022-01-28
 */
public class SysAttendanceDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 主表id */
    @Excel(name = "主表id")
    private Long attendanceId;

    /** 考勤日期 */
    @Excel(name = "考勤日期")
    private String date;

    /** 出勤时间 */
    @Excel(name = "出勤时间")
    private String startTime;

    /** 退勤时间 */
    @Excel(name = "退勤时间")
    private String endTime;

    /** 休憩時間 */
    @Excel(name = "休憩時間")
    private Long breakTime;

    /** 勤務時間 */
    @Excel(name = "勤務時間")
    private Long workTime;

    /** 時間外 */
    @Excel(name = "時間外")
    private Long workOvertime;

    /** 作業内容（週単位でも可） */
    @Excel(name = "作業内容", readConverterExp = "週=単位でも可")
    private String workContent;

    /** 勤怠状況 */
    @Excel(name = "勤怠状況")
    private Integer status;

    /** 備考 */
    @Excel(name = "備考")
    private String memo;

    private String startAndEnd;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAttendanceId(Long attendanceId) 
    {
        this.attendanceId = attendanceId;
    }

    public Long getAttendanceId() 
    {
        return attendanceId;
    }
    public void setDate(String date) 
    {
        this.date = date;
    }

    public String getDate() 
    {
        return date;
    }
    public void setStartTime(String startTime) 
    {
        this.startTime = startTime;
    }

    public String getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(String endTime) 
    {
        this.endTime = endTime;
    }

    public String getEndTime() 
    {
        return endTime;
    }
    public void setBreakTime(Long breakTime) 
    {
        this.breakTime = breakTime;
    }

    public Long getBreakTime() 
    {
        return breakTime;
    }
    public void setWorkTime(Long workTime) 
    {
        this.workTime = workTime;
    }

    public Long getWorkTime() 
    {
        return workTime;
    }
    public void setWorkOvertime(Long workOvertime) 
    {
        this.workOvertime = workOvertime;
    }

    public Long getWorkOvertime() 
    {
        return workOvertime;
    }
    public void setWorkContent(String workContent) 
    {
        this.workContent = workContent;
    }

    public String getWorkContent() 
    {
        return workContent;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setMemo(String memo) 
    {
        this.memo = memo;
    }

    public String getMemo() 
    {
        return memo;
    }

    public String getStartAndEnd() { return startTime + " ~ " + endTime; }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("attendanceId", getAttendanceId())
            .append("date", getDate())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("breakTime", getBreakTime())
            .append("workTime", getWorkTime())
            .append("workOvertime", getWorkOvertime())
            .append("workContent", getWorkContent())
            .append("status", getStatus())
            .append("memo", getMemo())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
