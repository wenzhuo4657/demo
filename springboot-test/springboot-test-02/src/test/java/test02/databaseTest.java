package test02;


import org.springframework.transaction.annotation.Transactional;

/**
 * @className: databaseTest
 * @author: wenzhuo4657
 * @date: 2024/8/28 10:11
 * @Version: 1.0
 * @description: 测试中可能会对数据库进行增删改查，但由于是测试，这些数据在不能再数据库中生效
 *
 */

//@Transactional(rollbackFor = Exception.class)
//其参数表示何时触发回滚，如果不加这个参数，则表明，一定回滚，适用于测试环境对数据库操作
@Transactional
public class databaseTest {

}