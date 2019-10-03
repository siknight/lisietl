package lisi.etl;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class EtlDriver implements Tool {
    Configuration configuration=new Configuration();
    public int run(String[] args) throws Exception {
        Job job = Job.getInstance(getConf());
        job.setJarByClass(EtlDriver.class);
        job.setMapperClass(ETLmapper.class);
        //下面这个带上时会输出很多个文件，不带时最终只会输出一个文件
//        job.setNumReduceTasks(0);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(NullWritable.class);

        FileInputFormat.setInputPaths(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));
        boolean b = job.waitForCompletion(true);
        return b?0:1;
    }

    public void setConf(Configuration conf) {
        this.configuration=conf;
    }

    public Configuration getConf() {
        return configuration;
    }

    public static void main(String[] args) throws Exception {
        int resultCode  = ToolRunner.run(new EtlDriver(), args);
        if(resultCode == 0){
            System.out.println("Success!");
        }else{
            System.out.println("Fail!");
        }
        System.exit(resultCode);
    }
}
