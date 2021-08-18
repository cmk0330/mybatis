import com.cmk.bean.Blog;
import com.cmk.dao.BlogMapping;
import com.cmk.utils.MybatisUtils;
import com.cmk.utils.UIDUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.*;

public class Test {
    @org.junit.Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapping mapper = sqlSession.getMapper(BlogMapping.class);

        mapper.addBlog(new Blog(UIDUtil.getId(), "乾坤大挪移", "张无忌", new Date(), 12));
        mapper.addBlog(new Blog(UIDUtil.getId(), "降龙十八掌", "洪熙宫", new Date(), 16));
        mapper.addBlog(new Blog(UIDUtil.getId(), "九阴真经", "郭襄", new Date(), 8));
        mapper.addBlog(new Blog(UIDUtil.getId(), "化骨绵掌", "玄冥二老", new Date(), 10));
        sqlSession.commit();
        sqlSession.close();
    }

    @org.junit.Test
    public void test5() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapping mapper = sqlSession.getMapper(BlogMapping.class);

        Map<String, String> map = new HashMap<>();
        map.put("title", "六脉神剑");
        map.put("id", "b340b46fe8f647a589aedae4a4b5185a");
        mapper.updateSet(map);
        sqlSession.commit();
        sqlSession.close();
    }

    @org.junit.Test
    public void test6() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapping mapper = sqlSession.getMapper(BlogMapping.class);

        Map<String, List<String>> map = new HashMap<>();
        List<String> ids = new ArrayList<>();
        ids.add("76976664812a44cda87b97dfc478597c");
        map.put("ids", ids);
        mapper.queryBlogForeach(map);
        sqlSession.commit();
        sqlSession.close();
    }
}
