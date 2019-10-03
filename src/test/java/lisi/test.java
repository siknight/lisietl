package lisi;

import lisi.etl.EtlUtil;
import org.junit.Test;

public class test {
    @Test
    public void test01(){
        String str = EtlUtil.str("SDNkMu8ZT68\tw00dy911\t630\tPeople & Blogs\t186\t10181\t3.49\t494\t257\trjnbgpPJUks");
        System.out.println(str);
    }
}
