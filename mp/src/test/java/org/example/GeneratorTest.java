package org.example;


import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.Test;


//mp代码生成。
public class GeneratorTest {
    @Test
    public void generate() {
        AutoGenerator generator = new AutoGenerator();

        // 全局配置
        GlobalConfig config = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        // 设置输出到的目录
        config.setOutputDir(projectPath + "/src/main/java");
        config.setAuthor("wenzhuo4657");
        // 生成结束后是否打开文件夹
        config.setOpen(false);

        // 全局配置添加到 generator 上
        generator.setGlobalConfig(config);

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3307/root1?characterEncoding=utf-8&serverTimezone=UTC");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("465700");

        // 数据源配置添加到 generator
        generator.setDataSource(dataSourceConfig);

        // 包配置, 生成的代码放在哪个包下
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.wenzhuo4657.mp.generator");

        // 包配置添加到 generator
        generator.setPackageInfo(packageConfig);

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        // 下划线驼峰命名转换
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        // 开启lombok
        strategyConfig.setEntityLombokModel(true);
        // 开启RestController
        strategyConfig.setRestControllerStyle(true);
        generator.setStrategy(strategyConfig);
        generator.setTemplateEngine(new FreemarkerTemplateEngine());

        // 开始生成
        generator.execute();
    }
}
