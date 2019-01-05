package cn.jboa.action;

import cn.jboa.common.CommonProperties;
import cn.jboa.pojo.BizCheckResult;
import cn.jboa.pojo.BizClaimVoucher;
import cn.jboa.pojo.BizClaimVoucherDetail;
import cn.jboa.pojo.SysEmployee;
import cn.jboa.service.BizClaimVoucherService;
import cn.jboa.service.SysEmployeeService;
import cn.jboa.util.PageSupport;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.Timestamp;
import java.util.*;

/**
 * 报销单：action
 */
@Controller("bizClaimVoucherAction")
public class BizClaimVoucherAction extends ActionSupport {

    @Autowired
    private BizClaimVoucherService bizClaimVoucherService;

    @Autowired
    private SysEmployeeService sysEmployeeService;

    /**
     * 报销单状态数据集合
     */
    private Map<String,String> statusMap = new HashMap<String, String>(){
        {
            put("新创建","新创建");
            put("已提交","已提交");
            put("待审批","待审批");
            put("已打回","已打回");
            put("已审批","已审批");
            put("已付款","已付款");
            put("已终止","已终止");

        }
    };

    /**
     * 1、报销单列表查询条件：页面传递的属性：status
     * 2、添加保险单的对象：页面传递的属性totalAccount、status、event
     */
    private BizClaimVoucher claimVoucher;

    /**
     * 添加保险单的具体的项目：页面传递的属性：item、account、desc
     */
    private List<BizClaimVoucherDetail> detailList;

    /**
     * 报销单列表查询条件：报销单开始时间：startDate
     */
    private Timestamp startDate;

    /**
     * 报销单列表查询条件：报销单开始时间：startDate
     */
    private Timestamp endDate;

    /**
     * 进行分页操作的实体类，被分页的实体类是：BizClaimVoucher（报销单）
     */
    private PageSupport<BizClaimVoucher> pageSupport;

    /**
     * 当前页码
     */
    private int pageNo = 1;

    /**
     * 每页显示条数
     */
    private int pageSize = 5;


    /**
     * 查询所有报销单
     * @return
     */
    public String searchClaimVoucher(){
        Map session = ActionContext.getContext().getSession();
        SysEmployee currEmp = (SysEmployee) session.get(CommonProperties.CURRERNT_EMP);
        try {
            if (claimVoucher == null) {
                claimVoucher = new BizClaimVoucher();
                claimVoucher.setSysEmployeeByCreateSn((SysEmployee)session.get(CommonProperties.CURRERNT_EMP));
            }else{
                claimVoucher.setSysEmployeeByCreateSn(currEmp);
            }
            int totalCount = bizClaimVoucherService.selectBizClaimVoucherCountByConditions(currEmp.getStatus(),currEmp.getName(),claimVoucher.getStatus(),startDate,endDate);

            if (pageSupport == null) pageSupport = new PageSupport<BizClaimVoucher>();
            pageSupport.setTotalCount(totalCount);
            pageSupport.setCurrPageNo(pageNo);
            pageSupport.setPageSize(pageSize);
            pageSupport.setTotalPageCount(pageSupport.getTotalPageCount());
            pageSupport.setItems(bizClaimVoucherService.selectBizClaimVoucherByPageAndConditions(pageSupport,currEmp.getStatus(),currEmp.getName(),claimVoucher.getStatus(),startDate,endDate));
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    /**
     * 添加报销单
     * @return
     */
    public String saveClaimVoucher(){
        claimVoucher.setCreateTime(new Timestamp(System.currentTimeMillis()));
        SysEmployee current_emp = (SysEmployee)ActionContext.getContext().getSession().get(CommonProperties.CURRERNT_EMP);
        claimVoucher.setSysEmployeeByCreateSn(current_emp);
        if (!claimVoucher.getStatus().equals("新创建"))
            claimVoucher.setSysEmployeeByNextDealSn(sysEmployeeService.selectSysEmployeeByDept(current_emp.getSysDepartmentByDepartmentId()));
        detailList.get(0).setBizClaimVoucherByMainId(claimVoucher);
        claimVoucher.setBizClaimVoucherDetailsById(new HashSet(detailList));
        try {
           bizClaimVoucherService.insertBizClaimVoucher(claimVoucher);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return INPUT;
        }
    }

    /**
     * 查看报销单详细信息的
     * @return
     */
    public String getClaimVoucherById(){
        claimVoucher = bizClaimVoucherService.selectBizClaimVoucherById(claimVoucher.getId());
        if (claimVoucher == null){
            return ERROR;
        }
        return SUCCESS;
    }

    public BizClaimVoucher getClaimVoucher() {
        return claimVoucher;
    }

    public void setClaimVoucher(BizClaimVoucher claimVoucher) {
        this.claimVoucher = claimVoucher;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public PageSupport<BizClaimVoucher> getPageSupport() {
        return pageSupport;
    }

    public void setPageSupport(PageSupport<BizClaimVoucher> pageSupport) {
        this.pageSupport = pageSupport;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Map<String, String> getStatusMap() {
        return statusMap;
    }

    public void setStatusMap(Map<String, String> statusMap) {
        this.statusMap = statusMap;
    }

    public List<BizClaimVoucherDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<BizClaimVoucherDetail> detailList) {
        this.detailList = detailList;
    }
}
