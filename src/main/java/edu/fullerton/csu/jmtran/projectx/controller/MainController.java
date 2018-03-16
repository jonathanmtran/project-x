package edu.fullerton.csu.jmtran.projectx.controller;

import edu.fullerton.csu.jmtran.projectx.dao.MailboxDao;
import edu.fullerton.csu.jmtran.projectx.dao.MessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    @Qualifier("messageDao")
    private MessageDao messageDao;

    @Autowired
    @Qualifier("mailboxDao")
    private MailboxDao mailboxDao;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView viewIndex() {
        ModelAndView view = new ModelAndView("index");

        view.addObject("messages", this.mailboxDao.getMessages("123456789"));

        return view;
    }
}
