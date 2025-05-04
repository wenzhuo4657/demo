package cn.wenzhuo4657.zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @className: testWather
 * @author: wenzhuo4657
 * @date: 2024/6/13 18:00
 * @Version: 1.0
 * @description:
 */
public class testWather {


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


    @After
    public  void after() {
        if (client!=null){
            client.close();
        }
    }

  /**
     *  des:
   *  nodeCache:单个节点监听器
     * */
    @Test
    public  void testNodeCache () throws Exception {
        NodeCache nodeCache=new NodeCache(client,"/app4");
        nodeCache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("触发监听-----");
                byte[] data = nodeCache.getCurrentData().getData();
                System.out.println(new String(data));
            }
        });
        nodeCache.start();
        Thread.sleep(10000000);
    }

      /**
         *  des:
       *  监听节点a的所有子节点，不包括节点a。
         * */
    @Test
    public  void testPathChildrenCache() throws Exception {
        PathChildrenCache childrenCache=new PathChildrenCache(client,"/app4",true);
        childrenCache.getListenable().addListener(new PathChildrenCacheListener(){

            @Override
            public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
                System.out.println("子节点变化了");
                System.out.println(event.getType()+"\t"+event.getData().getPath()+":\t"+new String(event.getData().getData()));
            }
        });
        childrenCache.start();
        Thread.sleep(10000000);
    }


      /**
         *  des:
       *  treecache:监听节点a以及其所有子节点。
       *
         * */

      @Test
    public void testTreecache() throws Exception {
          TreeCache treeCache=new TreeCache(client,"/app4");
          treeCache.getListenable().addListener(new TreeCacheListener() {
              @Override
              public void childEvent(CuratorFramework client, TreeCacheEvent event) throws Exception {
                  System.out.println("节点变化了");
              }
          });
          treeCache.start();
          Thread.sleep(10000000);
      }
}