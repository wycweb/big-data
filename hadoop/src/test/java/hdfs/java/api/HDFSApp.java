package hdfs.java.api;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;

/**
 * Hadoop HDFS Java API 操作
 */
public class HDFSApp {

    public static final String HDFS_PATH = "hdfs://192.168.20.81:8020";
    public static final String USER = "hadoop";

    FileSystem fileSystem = null;
    Configuration configuration = null;

    /**
     * 创建文件夹
     *
     * @throws Exception
     */
    @Test
    public void mkdir() throws Exception {
        fileSystem.mkdirs(new Path("/hdfsapi/test"));
    }

    /**
     * 创建文件
     *
     * @throws Exception
     */
    @Test
    public void create() throws Exception {
        FSDataOutputStream outputStream = fileSystem.create(new Path("/hdfsapi/test/a.txt"));
        outputStream.write("hello hadoop".getBytes());
        outputStream.flush();
        outputStream.close();
    }

    /**
     * 读取文件
     *
     * @throws Exception
     */
    @Test
    public void cat() throws Exception {
        FSDataInputStream inputStream = fileSystem.open(new Path("/hdfsapi/test/a.txt"));
        IOUtils.copyBytes(inputStream, System.out, 1024);
        inputStream.close();
    }

    /**
     * 重命名
     *
     * @throws Exception
     */
    @Test
    public void rename() throws Exception {
        Path oldPath = new Path("/hdfsapi/test/a.txt");
        Path newPath = new Path("/hdfsapi/test/b.txt");

        fileSystem.rename(oldPath, newPath);
    }

    /**
     * 上传文件到hdfs
     *
     * @throws Exception
     */
    @Test
    public void copyFromLocalFile() throws Exception {
        Path localPath = new Path("/var/study/log.2018-08-16");
        Path hdfsPath = new Path("/hdfsapi/test/");

        fileSystem.copyFromLocalFile(localPath, hdfsPath);
    }

    /**
     * 上传文件到hdfs(带有进度条，方便上传大文件时查看进度)
     *
     * @throws Exception
     */
    @Test
    public void copyFromLocalFileWithProcess() throws Exception {
        Path localPath = new Path("/Users/wangyichao/Downloads/1.mp4");
        Path hdfsPath = new Path("/hdfsapi/test/");
        fileSystem.copyFromLocalFile(localPath, hdfsPath);

        InputStream inputStream = new BufferedInputStream(
                new FileInputStream(
                        new File("/Users/wangyichao/Downloads/1.mp4")
                ));

        FSDataOutputStream outputStream = fileSystem.create(new Path("/hdfsapi/test/1.mp4"),
                new Progressable() {
                    @Override
                    public void progress() {
                        System.out.println(".");
                    }
                });

        IOUtils.copyBytes(inputStream, outputStream, 4096);
    }

    /**
     * 从HDFS下载文件到本地
     *
     * @throws Exception
     */
    @Test
    public void copyToLocalFile() throws Exception {
        Path localPath = new Path("/hdfsapi/test/b.txt");
        Path hdfsPath = new Path("/Users/wangyichao/Downloads/");
        fileSystem.copyToLocalFile(localPath, hdfsPath);
    }

    /**
     * 查看指定目录下的文件
     *
     * @throws Exception
     */
    @Test
    public void listFile() throws Exception {
        FileStatus[] fileStatuses = fileSystem.listStatus(new Path("/hdfsapi/test"));

        for (FileStatus fileStatus : fileStatuses) {
            String isDr = fileStatus.isDirectory() ? "文件夹" : "文件";

            short replication = fileStatus.getReplication();    //副本系数
            long len = fileStatus.getLen();                     //文件大小
            String path = fileStatus.getPath().toString();      //文件路径

            System.out.println(isDr + "\t" + replication + "\t" + len + "\t" + path);
        }

    }

    /**
     * 删除文件
     *
     * @throws Exception
     */
    @Test
    public void delete() throws Exception {
        fileSystem.delete(new Path("/hdfsapi/test"), true);
    }

    @Before
    public void setUp() throws Exception {
        configuration = new Configuration();
        fileSystem = FileSystem.get(new URI(HDFS_PATH), configuration, USER);

        System.out.println("---------hfds set up---------");
    }

    @After
    public void tearDown() throws Exception {
        configuration = null;
        fileSystem = null;

        System.out.println("---------hdfs set down---------");
    }

}