package cn.shen.jpa2.dao;

import cn.shen.jpa2.pojo.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerDao extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {
    @Query("from Customer where custName = ?1")
    Customer findByCustomerName(String customerName);

    /**
     *
     * @param customerName 用户名
     * @param customerId    用户ID
     * @return YONGHU
     */
    @Query("from Customer where custName=?1 and custId=?2")
    Customer findByCustomerNameAndCustomerId(String customerName, Long customerId);

    Customer findByCustNameEquals(String custName);

    List<Customer> findByCustLevelIsNot(String level);

    List<Customer> findByCustNameLikeOrCustIndustry(String custName,String custIndustry);

    List<Customer> findByCustIdInAndCustIndustryIsNotNull(Long[] custId);
}
