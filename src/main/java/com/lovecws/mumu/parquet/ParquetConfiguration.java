package com.lovecws.mumu.parquet;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author babymm
 * @version 1.0-SNAPSHOT
 * @Description: hdfs配置
 * @date 2017-10-09 15:09
 */
public class ParquetConfiguration {

    private static final Logger log = Logger.getLogger(ParquetConfiguration.class);
    public static String HDFS_URI = "hdfs://192.168.11.25:9000";

    /**
     * 获取到分布式文件
     *
     * @return
     */
    public DistributedFileSystem distributedFileSystem() {
        String hadoop_address = System.getenv("HADOOP_ADDRESS");
        if (hadoop_address != null) {
            HDFS_URI = hadoop_address;
        }
        DistributedFileSystem distributedFileSystem = new DistributedFileSystem();
        Configuration conf = new Configuration();
        try {
            distributedFileSystem.initialize(new URI(HDFS_URI), conf);
        } catch (IOException | URISyntaxException e) {
            log.error(e);
        }
        return distributedFileSystem;
    }
}
