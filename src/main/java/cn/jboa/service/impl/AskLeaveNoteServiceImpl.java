package cn.jboa.service.impl;

import cn.jboa.dao.AskLeaveNoteDao;
import cn.jboa.service.AskLeaveNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 请假条：Service实现
 */
@Service("askLeaveNoteService")
public class AskLeaveNoteServiceImpl implements AskLeaveNoteService {

    @Autowired
    private AskLeaveNoteDao askLeaveNoteDao;
}
