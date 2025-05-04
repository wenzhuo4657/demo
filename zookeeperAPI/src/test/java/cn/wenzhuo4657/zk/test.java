package cn.wenzhuo4657.zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @className: test
 * @author: wenzhuo4657
 * @date: 2024/6/13 11:38
 * @Version: 1.0
 * @description: zk
 */
public class test {
    static CuratorFramework client;

      /**
         *  des: 建立连接
         * */
      @Before
    public void test(){
          RetryPolicy retryPolicy = new ExponentialBackoffRetry(2, 6);

//          client = CuratorFrameworkFactory.newClient("47.92.150.10:2181", retryPolicy);
          client = CuratorFrameworkFactory.builder().connectString("47.92.150.10:2181")
                  .sessionTimeoutMs(3 * 1000)
                  .connectionTimeoutMs(6 * 1000)
                  .retryPolicy(retryPolicy).namespace("app1").build();
          client.start();
      }

//=========================================create=======================================================================
      @Test
      public void testBasic() throws Exception {
          String path;
//          path = client.create().forPath("/app3");
//          System.out.println(path);
          path = client.create().forPath("/app4","heheh".getBytes());//设置数据
          System.out.println(path);
          path = client.create().withMode(CreateMode.EPHEMERAL).forPath("/app5","heheh".getBytes());//设置节点类型
          System.out.println(path);
          path = client.create().creatingParentsIfNeeded().forPath("/app4/app3","heheh".getBytes());//多级节点直接创建,如果父节点不存在，会创建父节点
          System.out.println(path);
      }

//=========================================get===========================================================================
  /**
     *  des:
   *
   *  查询节点
   *  1，查询数据 get
   *  2，查询子节点  ls
   *  3，查询节点状态信息   ls -s
     * */
        @Test
        public  void testget1() throws Exception {
            byte[] bytes = client.getData().forPath("/app2");
            System.out.println(new String(bytes));
        }
    @Test
    public  void testget2() throws Exception {
        List<String> strings = client.getChildren().forPath("/");
        System.out.println(strings);
    }
    @Test
    public  void testget3() throws Exception {
        Stat stat = new Stat();
        System.out.println(stat);
        client.getData().storingStatIn(stat).forPath("/app2");//查询节点状态信息
        System.out.println(stat);
    }

//=================================set==============================================================

      /**
         *  des:
       *  1,修改数据
       *  2，修改指定版本
         * */
@Test
public  void testSet1() throws Exception {
     client.setData().forPath("/app2", "itcat".getBytes());
}
    @Test
    public  void testSet2() throws Exception {
        Stat stat = new Stat();
        client.getData().storingStatIn(stat).forPath("/app2");
        int version=stat.getVersion();
        System.out.println(version);
        client.setData().forPath("/app2", "hahha".getBytes());
    }
//=============================delete===============================================================

      /**
         *  des:
       *  删除节点
       *
       * 1，删除单个节点
       * 2，删除带有子节点的节点，也就是父节点
       * 3，必须成功的删除
       * 4，回调
         * */
      @Test
      public  void testDelete1() throws Exception {
          client.delete().forPath("/app2");
      }
    @Test
    public  void testDelete2() throws Exception {
        client.delete().deletingChildrenIfNeeded().forPath("/app2");
    }
    @Test
    public  void testDelete3() throws Exception {
        client.delete().guaranteed().forPath("/app2");//重复删除直到删除
    }

    @Test
    public  void testDelete4() throws Exception {
        client.delete().guaranteed().inBackground(new BackgroundCallback() {
            @Override
            public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
                System.out.println("成功了！！！");
            }
        }).forPath("/app3");//回到函数通知，支持多种重载
        Thread.sleep(1000000);
    }





      @After
    public  void after() {
          if (client!=null){
              client.close();
          }
      }
}