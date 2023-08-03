import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.mybatis.bean.Emp;
import com.ssm.mybatis.mapper.EmpMapper;
import com.ssm.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * ClassName: PageTest
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/3 14:57
 * @Version 1.0
 */
public class PageTest {


    /**
     * PageInfo{
     * pageNum=1, pageSize=4, size=4,
     * startRow=1, endRow=4, total=30,
     * pages=8,
     * list=Page{count=true, pageNum=1, pageSize=4, startRow=0, endRow=4, total=30, pages=8, reasonable=false, pageSizeZero=false}[Emp{empId=1, empName='aaa', age=null, gender='null', deptId=null}, Emp{empId=2, empName='a', age=null, gender='null', deptId=null}, Emp{empId=3, empName='a', age=null, gender='null', deptId=null}, Emp{empId=4, empName='a', age=null, gender='null', deptId=null}],
     * prePage=0, nextPage=2, isFirstPage=true,
     * isLastPage=false, hasPreviousPage=false,
     * hasNextPage=true, navigatePages=5,
     * navigateFirstPage=1, navigateLastPage=5, navigatepageNums=[1, 2, 3, 4, 5]}
     */
    @Test
    public void testPage(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);


        //查询功能之前开启分页功能
        int pageNum = 2;    // 第几页
        int pageSize = 3;   // 一页显示几行
        // 显示 第2页, 每显示3条数据
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);

        List<Emp> empList = mapper.selectByExample(null);

        //查询功能之后可以获取分页相关的所有数据
        PageInfo<Emp> empPageInfo = new PageInfo<>(empList, 2);
        empList.forEach(System.out::println);
        System.out.println("empPageInfo = " + empPageInfo);
    }
}
