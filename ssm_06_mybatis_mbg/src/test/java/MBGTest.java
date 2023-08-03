import com.ssm.mybatis.bean.Emp;
import com.ssm.mybatis.bean.EmpExample;
import com.ssm.mybatis.mapper.EmpMapper;
import com.ssm.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * ClassName: MBGTest
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/3 14:29
 * @Version 1.0
 */
public class MBGTest {

    @Test
    public void testMBG(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

//        Emp emp = new Emp(null, "江淑娜", 57, "f");
//        mapper.insert(emp);
//
//        Emp emp = new Emp(null, "江惠", 59, "f");
//        mapper.insert(emp);
//        EmpExample example = new EmpExample();

//        mapper.updateByPrimaryKeySelective(new Emp(4,null,null,"m"));
        List<Emp> empList = mapper.selectByExample(null);
        empList.forEach(System.out::println);
    }
}
