import com.cmk.bean.Blog;
import com.cmk.dao.BlogMapping;
import com.cmk.utils.MybatisUtils;
import com.cmk.utils.UIDUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;

public class Test {
    @org.junit.Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapping mapper = sqlSession.getMapper(BlogMapping.class);

        mapper.addBlog(new Blog(UIDUtil.getId(), "乾坤大挪移", "张无忌", new Date(), 12));
        sqlSession.commit();
        sqlSession.close();
    }
}
