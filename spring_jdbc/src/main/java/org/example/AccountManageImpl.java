package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
public class AccountManageImpl implements AccountManage{
   @Autowired
    public JdbcTemplate jdbcTemplate;
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
//        this.jdbcTemplate=jdbcTemplate;
//    }
    @Override
    public void queryAllAccount(){
        String sql = "select * from accounts";
        List<Accounts> accounts = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Accounts>(Accounts.class));
        for(Accounts account:accounts){
            System.out.println(account.toString());
        }
    }


    @Transactional(propagation=Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
    @Override
    public void transfor(Integer outAccountId, Integer inAccountId, Double money) {
        int result=jdbcTemplate.update("update accounts set balance=balance - ? where  id = ?",money,outAccountId);
        if (result>0){
            System.out.println(outAccountId+"汇款成功");
        }else {
            throw new RuntimeException(outAccountId+"汇款失败");
        }

        int result2=jdbcTemplate.update("update accounts set balance=balance + ? where  id = ?",money,inAccountId);{
            if (result2>0){
                System.out.println(inAccountId+"收款成功");
            }else {
                throw new RuntimeException(inAccountId+"收款失败");
            }
        }
    }

}
