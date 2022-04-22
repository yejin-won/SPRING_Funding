package funding.command;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public interface FCommand {
	void execute(SqlSession sqlSession, Model model);
}
