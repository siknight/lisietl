package lisi.etl;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


public class ETLmapper extends Mapper<LongWritable, Text, Text, NullWritable> {

    Text text=new Text();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String s=EtlUtil.str(value.toString());
        if (StringUtils.isEmpty(s)){
            return;
        }
        text.set(s);
        context.write(text,NullWritable.get());
    }
}
