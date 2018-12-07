package co.qingmei.pm.biz;

import co.qingmei.pm.dao.TaskMapper;
import co.qingmei.pm.entity.Task;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskBiz {

    @Autowired
    private TaskMapper  tm;

    public Task getTaskById(int pid) {
          return this.tm.selectByPrimaryKey(pid);

    }

    public void saveTask(Task ttt) {
        if (ttt.getId() != null )
            this.tm.updateByPrimaryKeySelective(ttt);
        else
            this.tm.insertSelective( ttt);
    }

    public List<Task> getTaskList(String taskName, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        return this.tm.getTaskListByTaskName(taskName);

    }

    public void deleteTaskById(int tid) {

        this.tm.deleteByPrimaryKey(tid);
    }
}
